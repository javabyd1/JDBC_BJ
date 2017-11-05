package com.mojafirma;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertValue {

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
            conn.close();
        } catch (SQLException se) {
            //Handle errors for com.mojafirma.JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
//        System.out.println("Goodbye!");
    }//end main
}//end FirstExample
