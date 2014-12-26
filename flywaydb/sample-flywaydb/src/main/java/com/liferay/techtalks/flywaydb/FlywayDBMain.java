package com.liferay.techtalks.flywaydb;

import org.flywaydb.core.Flyway;

/**
 * @author mdelapenya
 */
public class FlywayDBMain {

	public static void main(String[] args) {
		Flyway flyway = new Flyway();

		String url =
			"jdbc:mysql://localhost/flywaydb?useUnicode=true" +
				"&characterEncoding=UTF-8&useFastDateParsing=false";

		String user = "flyway";
		String password = "flyway";

		flyway.setDataSource(url, user, password, new String[0]);

		flyway.setLocations("com.liferay.techtalks.flywaydb.migrations");

		flyway.setInitOnMigrate(true);

		flyway.migrate();
	}

}