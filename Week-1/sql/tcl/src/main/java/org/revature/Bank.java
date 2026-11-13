package org.revature;

import java.sql.*;

public class Bank {

    public static void main(String[] args) throws SQLException {
        try{
            setupBank();
            checkAccounts();
//            badTransferAutoCommitting();
            badTransferManualCommitting();
            checkAccounts();
        } catch (Exception e){
            System.out.println(e.getMessage());
            checkAccounts();
        }
    }

    public static void setupBank() throws SQLException {
        String resetSQL = "drop table if exists accounts";
        String sql = "create table accounts(id integer primary key, balance integer check (balance >= 0))";
        String sql2 = "insert into accounts (balance) values (100), (100)";
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute(resetSQL);
            statement.execute(sql);
            statement.execute(sql2);
        }
    }

    public static void checkAccounts() throws SQLException{
        String sql = "select * from accounts";
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int balance = rs.getInt("balance");
                Account account = new Account(id, balance);
                System.out.println(account);
            }
        }
    }

    public static void badTransferAutoCommitting() throws SQLException{
        try(Connection connection = ConnectionFactory.getConnection()){
            // this is a bad transfer: account 11 does not exist, so in the real world account 2 should not actually lose
            // any money
            String transferFrom = "update accounts set balance = 0 where id = 2";
            String transferTo = "update accounts set balance = 200 where id = 11";
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(transferFrom);
            if(rowsAffected != 1){
                throw new RuntimeException("Transfering money from account failed, need to cancel whole transaction");
            }
            rowsAffected = statement.executeUpdate(transferTo);
            if(rowsAffected != 1){
                throw new RuntimeException("Money not recieved, need to cancel whole transaction");
            }
        }
    }

    public static void badTransferManualCommitting() throws SQLException{
        try(Connection connection = ConnectionFactory.getManualCommitConnection()){
            // this is a bad transfer: account 11 does not exist, so in the real world account 2 should not actually lose
            // any money
            String transferFrom = "update accounts set balance = 0 where id = 2";
            String transferTo = "update accounts set balance = 200 where id = 11";
            Statement statement = connection.createStatement();
            // you can make your savepoints
            Savepoint savepoint = connection.setSavepoint("Start of Transaction");
            int rowsAffected = statement.executeUpdate(transferFrom);
            if(rowsAffected != 1){
                // you can rollback to a savepoint
                connection.rollback(savepoint);
                throw new RuntimeException("Transferring money from account failed, need to cancel whole transaction");
            }
            rowsAffected = statement.executeUpdate(transferTo);
            if(rowsAffected != 1){
                // or rollback the whole transaction
                connection.rollback();
                throw new RuntimeException("Money not received, need to cancel whole transaction");
            }
            // make sure to commit your work if everything goes well
            connection.commit();
        }
    }

}
