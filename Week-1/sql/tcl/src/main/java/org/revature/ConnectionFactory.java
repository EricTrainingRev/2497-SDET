package org.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DATABASE_URL = "jdbc:sqlite:example.db";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static Connection getManualCommitConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        // this will allow us to manually controll the commiting and rolling back of our transactions
        connection.setAutoCommit(false);
        return connection;
    }

    // in a real app, don't do this with the throws statement
    public static void main(String[] args) throws SQLException {
        getConnection();
        getManualCommitConnection();
    }

}
