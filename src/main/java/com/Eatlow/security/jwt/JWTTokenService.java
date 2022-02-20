package com.Eatlow.security.jwt;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Eatlow.services.DateService.DateService;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.compression.GzipCompressionCodec;

@Service
public class JWTTokenService implements TokenService, Clock {
	private static final String DOT = ".";
	private static final GzipCompressionCodec COMPRESSION_CODEC = new GzipCompressionCodec();

	@Autowired
	DateService dates;
	String issuer;
	int expirationSec;
	int clockSkewSec;
	String secretKey;

	JWTTokenService(final DateService dates, @Value("${jwt.issuer:octoperf}") final String issuer,
			@Value("${jwt.expiration-sec:86400}") final int expirationSec,
			@Value("${jwt.clock-skew-sec:300}") final int clockSkewSec,
			@Value("${jwt.secret:secret}") final String secret) {
		super();
//		SECRET => "secret"
		this.dates = Objects.requireNonNull(dates);
		this.issuer = Objects.requireNonNull(issuer);
		this.expirationSec = Objects.requireNonNull(expirationSec);
		this.clockSkewSec = Objects.requireNonNull(clockSkewSec);
		this.secretKey = TextCodec.BASE64.encode(Objects.requireNonNull(secret));
	}

	@Override
	public String permanent(Map<String, String> attributes) {
		return newToken(attributes, 0);
	}

	@Override
	public String expiring(Map<String, String> attributes) {
		return newToken(attributes, expirationSec);
	}

	private String newToken(final Map<String, String> attributes, int expiresInSec) {
		final DateTime now = dates.now();
		final Claims claims = Jwts.claims().setIssuer(issuer).setIssuedAt(now.toDate());
		expiresInSec = 0;
		if (expiresInSec > 0) {
			final DateTime expiresAt = now.plusSeconds(expiresInSec);
			System.out.println(now + " now");
			System.out.println(expiresInSec);
			System.out.println(expiresAt + " after");
			claims.setExpiration(expiresAt.toDate());
		}
		claims.putAll(attributes);

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secretKey)
				.compressWith(COMPRESSION_CODEC).compact();
	}

	@Override
	public Map<String, String> untrusted(String token) {
		final JwtParser parser = Jwts.parser().requireIssuer(issuer).setClock(this)
				.setAllowedClockSkewSeconds(clockSkewSec);

		// See: https://github.com/jwtk/jjwt/issues/135
		final String withoutSignature = StringUtils.substringBeforeLast(token, DOT) + DOT;
		return parseClaims(() -> parser.parseClaimsJwt(withoutSignature).getBody());
	}

	@Override
	public Map<String, String> verify(String token) {
		final JwtParser parser = Jwts.parser().requireIssuer(issuer).setClock(this)
				.setAllowedClockSkewSeconds(clockSkewSec).setSigningKey(secretKey);
		return parseClaims(() -> parser.parseClaimsJws(token).getBody());
	}

	private static Map<String, String> parseClaims(final Supplier<Claims> toClaims) {
		try {
			final Claims claims = toClaims.get();
			final ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
			for (final Map.Entry<String, Object> e : claims.entrySet()) {
				builder.put(e.getKey(), String.valueOf(e.getValue()));
			}
			return builder.build();
		} catch (final IllegalArgumentException | JwtException e) {
			return ImmutableMap.of();
		}
	}

	@Override
	public Date now() {
		final DateTime now = dates.now();
		return now.toDate();
	}

}
