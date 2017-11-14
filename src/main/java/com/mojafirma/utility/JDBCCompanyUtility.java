package com.mojafirma.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCompanyUtility {

        // com.mojafirma.utility.JDBCCompanyUtility driver name and database URL
//        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        static final String DB_URL = "jdbc:mysql://localhost:3306/j1b";
        // Database credentials
//        static final String USER = "root";
//        static final String PASS = "";

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
            String sql = "SELECT nazwa, ulica, numer_domu, nip FROM firmy";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("nazwa");
                String street = rs.getString("ulica");
                String number = rs.getString("numer_domu");
                String nip = rs.getString("nip");
                //Display values
                System.out.print("Nazwa: " + name);
                System.out.print(", adres: " + street + " " + number);
                System.out.println(", nip: " + nip);
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

    public static void insertData(String name, String street, String number, String nip) {
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

            int company_id = 0;
            String sql1;
            sql1 = "SELECT id_firmy FROM firmy ORDER BY id_firmy DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql1);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                company_id = rs.getInt("id_firmy");
            }

            String sql;
            sql = "INSERT INTO firmy (id_firmy, nazwa, ulica, numer_domu, numer_mieszkania, nip) VALUES ("+(company_id+1) +" , '"+ name +"', '"+street+"', '"+number+"', NULL, '"+ nip +"')";
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
}//end FirstExample
