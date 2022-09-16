package br.com.sgsistemas.sgsaude.factories;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionFactory {

    public PGConnectionPoolDataSource dataSource;

    public ConnectionFactory() {

        PGConnectionPoolDataSource pgcConnectionPoolDataSource = new PGConnectionPoolDataSource();
        //pgcConnectionPoolDataSource.setDefaultAutoCommit(false);
        pgcConnectionPoolDataSource.setURL("jdbc:postgresql://localhost:5432/sgsaude");
        pgcConnectionPoolDataSource.setUser("postgres");
        pgcConnectionPoolDataSource.setPassword("senha1");

        this.dataSource = pgcConnectionPoolDataSource;

        }

        public Connection obterConexao () throws SQLException {
            return this.dataSource.getConnection();
        }

    }
