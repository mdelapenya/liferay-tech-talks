package com.liferay.techtalks.flywaydb.migrations;

import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.migration.MigrationChecksumProvider;
import org.flywaydb.core.api.migration.MigrationInfoProvider;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @author Manuel de la Peña
 */
public class AnotherComplicatedChange
	implements JdbcMigration, MigrationChecksumProvider, MigrationInfoProvider {

	@Override
	public void migrate(Connection connection) throws Exception {
		System.out.println("Dropping table...");

		CallableStatement callableStatement = null;

		try {
			callableStatement = connection.prepareCall("DROP TABLE Person;");

			callableStatement.execute();
		}
		finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
		}
	}

	@Override
	public MigrationVersion getVersion() {
		return MigrationVersion.fromVersion("5");
	}

	@Override
	public String getDescription() {
		return "This is another complicated change";
	}

	@Override
	public Integer getChecksum() {
		return 1234567890;
	}

}