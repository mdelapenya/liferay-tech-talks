package com.liferay.techtalks.flywaydb.migrations;

import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.migration.MigrationInfoProvider;
import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @author Manuel de la Peña
 */
public class V7__TechTalk_2 implements JdbcMigration, MigrationInfoProvider {

	@Override
	public void migrate(Connection connection) throws Exception {

	}

	@Override
	public MigrationVersion getVersion() {
		return MigrationVersion.fromVersion("8");
	}

	@Override
	public String getDescription() {
		return "Version 8";
	}

}