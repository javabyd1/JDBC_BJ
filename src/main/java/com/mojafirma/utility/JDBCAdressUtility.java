package com.mojafirma.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCAdressUtility {

    public static void showData() {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register com.mojafirma.utility.JDBCCompanyUtility driver
//            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
            conn = Database.getConnection();
            //STEP 4: Execute a query
//            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT miasto, ulica, numer_domu, numer_mieszkania FROM adresy";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String city = rs.getString("miasto");
                String street = rs.getString("ulica");
                String home_number = rs.getString("numer_domu");
                String flat_number = rs.getString("numer_mieszkania");
                //Display values
                System.out.print("Miasto: " + city);
                System.out.println(", ulica: " + street + " " + home_number + "/" + flat_number);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
//            conn.close();
        } catch (SQLException se) {
            //Handle errors for com.mojafirma.utility.JDBCCompanyUtility
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } //finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
        System.out.println("Wykonano!");
    }//end main

    public static void insertData(String city, String street, String home_number, String flat_number) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register com.mojafirma.JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            conn = Database.getConnection();
            //STEP 4: Execute a query
            System.out.println("Tworzenie wyrażenia...");
            stmt = conn.createStatement();

            int adress_id = 0;
            String sql1;
            sql1 = "SELECT id_adresu FROM adresy ORDER BY id_adresu DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql1);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                adress_id = rs.getInt("id_adresu");
            }

            String sql;
            sql = "INSERT INTO adresy (id_adresu, ulica, numer_domu, numer_mieszkania, kod_pocztowy, miasto, panstwo, wojewodztwo)" +
                    " VALUES ("+(adress_id + 1) +", '"+street+"', '"+home_number+"', '"+flat_number+"', NULL, '"+ city +"', 'Polska', NULL )";
            stmt.executeUpdate(sql);
            //STEP 6: Clean-up environment
            stmt.close();
//            conn.close();
        } catch (SQLException se) {
            //Handle errors for com.mojafirma.JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } //finally {
        //finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
        System.out.println("Wykonano!");
    }//end main

    public static void executeStatement(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register com.mojafirma.JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            conn = Database.getConnection();
            //STEP 4: Execute a query
            System.out.println("Tworzenie wyrażenia...");
            stmt = conn.createStatement();

            stmt.executeUpdate(sql);
            //STEP 6: Clean-up environment
            stmt.close();
//            conn.close();
        } catch (SQLException se) {
            //Handle errors for com.mojafirma.JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } //finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
        System.out.println("Wykonano!");
    }//end main
}
