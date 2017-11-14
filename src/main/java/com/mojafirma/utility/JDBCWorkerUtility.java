package com.mojafirma.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCWorkerUtility {

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
            String sql = "SELECT pracownicy.imie, nazwisko, telefon, email, stanowiska.nazwa FROM pracownicy " +
                    "INNER JOIN stanowiska ON pracownicy.id_stanowiska = stanowiska.id_stanowiska";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("imie");
                String surname = rs.getString("nazwisko");
                String phone = rs.getString("telefon");
                String email = rs.getString("email");
                String stand = rs.getString("nazwa");
                //Display values
                System.out.print("Pracownik: " + name + " " + surname);
                System.out.print(", telefon: " + phone + ", email: " + email);
                System.out.println(", stanowisko: " + stand);
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

    public static void insertData(String name, String surname, String eye_color, int heigh, String phone, String email, int stand_id, int company_id) {
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

            int worker_id = 0;
            String sql1;
            sql1 = "SELECT id_pracownika FROM pracownicy ORDER BY id_pracownika DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql1);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                worker_id = rs.getInt("id_pracownika");
            }

            String sql;
            sql = "INSERT INTO pracownicy (id_pracownika, imie, nazwisko, kolor_oczu, wzrost, plec, telefon, email, PESEL, data_urodzin, id_stanowiska, wynagrodzenie, id_firmy) " +
                    "VALUES ("+(worker_id+1) +" , '"+ name +"', '"+surname+"', '"+eye_color+"', '"+heigh +"', NULL, '"+ phone +"', '"+email+"', NULL, NULL, "+stand_id+", NULL, "+company_id+")";
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
