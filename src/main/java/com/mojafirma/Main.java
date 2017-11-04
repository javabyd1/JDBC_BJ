package com.mojafirma;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć bazę firm. Wprowadź 2, aby dodać firmę");
        int inputNumber = scanner1.nextInt();
        JDBC jdbc = new JDBC();
        JDBCInsertValue jdbcInsertValue = new JDBCInsertValue();

        switch (inputNumber){
            case 1: {
                jdbc.showData();
                break;
            }
            case 2:{
                System.out.println("Wprowadź nazwę, ulicę, nr domu i NIP firmy");
                Scanner scanner2 = new Scanner(System.in);
                String name = scanner2.nextLine();
                String street = scanner2.nextLine();
                String number = scanner2.nextLine();
                String nip = scanner2.nextLine();
                jdbcInsertValue.insertData(name, street, number, nip);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
