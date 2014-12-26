package com.liferay.techtalks.flywaydb.migrations;

import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.migration.MigrationChecksumProvider;
import org.flywaydb.core.api.migration.MigrationInfoProvider;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @author Manuel de la Peña
 */
public class ComplicatedChange
	implements JdbcMigration, MigrationChecksumProvider, MigrationInfoProvider {

	@Override
	public void migrate(Connection connection) throws Exception {
		// delete file system

		System.out.println("Creating the filesystem...");

		File directory = new File("/tmp");

		File.createTempFile("prefix", "suffix.bak", directory);

		// update indexes

		System.out.println("Re-indexing...");

		// Create table

		System.out.println("Creating table...");

		CallableStatement callableStatement = null;

		try {
			callableStatement = connection.prepareCall(
				"CREATE TABLE Person (" +
					"name VARCHAR(25) NOT NULL, PRIMARY KEY(name));"
			);

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
		return MigrationVersion.fromVersion("4");
	}

	@Override
	public String getDescription() {
		return "This is a complicated change";
	}

	@Override
	public Integer getChecksum() {
		return 1234567890;
	}

}