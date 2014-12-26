package com.liferay.techtalks.flywaydb.migrations;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @author Manuel de la Peña
 */
public class V6__ThirdComplicatedChange implements JdbcMigration {

	@Override
	public void migrate(Connection connection) throws Exception {
		CallableStatement callableStatement = null;

		try {
			callableStatement = connection.prepareCall(
				"CREATE TABLE Person (" +
					"name VARCHAR(25) NOT NULL, PRIMARY KEY(name));"
			);

			callableStatement.execute();

			callableStatement = connection.prepareCall(
				"INSERT INTO Person VALUES(?)"
			);

			for (int i = 0; i < 100; i++) {
				callableStatement.setString(1, "Name number " + i);

				callableStatement.execute();
			}
		}
		finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
		}
	}

}