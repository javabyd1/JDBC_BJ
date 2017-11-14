package com.mojafirma.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStandingUtility {

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
            String sql = "SELECT nazwa FROM stanowiska";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("nazwa");
                //Display values
                System.out.println("Nazwa: " + name);
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

    public static void insertData(String name) {
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

            int standing_id = 0;
            String sql1;
            sql1 = "SELECT id_stanowiska FROM stanowiska ORDER BY id_stanowiska DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql1);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                standing_id = rs.getInt("id_stanowiska");
            }

            String sql;
            sql = "INSERT INTO stanowiska (id_stanowiska, nazwa) VALUES ("+(standing_id+1) +" , '"+ name +"')";
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
