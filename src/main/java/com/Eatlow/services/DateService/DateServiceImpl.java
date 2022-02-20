package com.Eatlow.services.DateService;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.google.common.base.Preconditions;

public class DateServiceImpl implements DateService {

	private final DateTimeZone timeZone;

	/**
	 * Force system-wide timezone to ensure consistent dates over all servers,
	 * independently from the region the server is running.
	 */
	DateServiceImpl(final DateTimeZone timeZone) {
		super();
		this.timeZone = Preconditions.checkNotNull(timeZone);

		System.setProperty("user.timezone", timeZone.getID());
		TimeZone.setDefault(timeZone.toTimeZone());
		DateTimeZone.setDefault(timeZone);
	}

	@Override
	public DateTime now() {
		return DateTime.now(timeZone);
	}

}
