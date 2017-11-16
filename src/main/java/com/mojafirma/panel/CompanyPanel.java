package com.mojafirma.panel;

import com.mojafirma.utility.JDBCCompanyUtility;

import java.util.Scanner;

public class CompanyPanel {

    JDBCCompanyUtility jdbcCompanyUtility = new JDBCCompanyUtility();

    public void iniCompanyPanel() {

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć bazę firm, 2 aby dodać firmę, 3 aby zaktualizować dane firmy " +
                "oraz 4 aby usunąć firmę");
        int inputNumber = scanner2.nextInt();

        switch (inputNumber) {
            case 1: {
                jdbcCompanyUtility.showData();
                break;
            }
            case 2: {
                System.out.println("Wprowadź nazwę firmy, ulicę, numer domu i numer mieszkania");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                String street = scanner.nextLine();
                String home_number = scanner.nextLine();
                String flat_number = scanner.nextLine();

                jdbcCompanyUtility.insertData(name, street, home_number, flat_number);
                break;
            }
            case 3: {
                System.out.println("Podaj nazwę firmy ");
                Scanner scanner = new Scanner(System.in);
                String companyName = scanner.nextLine();
                System.out.println("Podaj ulicę, numer domu i NIP firmy");
                String street = scanner.nextLine();
                String number = scanner.nextLine();
                String nip = scanner.nextLine();

                String sql = "UPDATE firmy SET ulica = '" + street + "', numer_domu = '" + number + "', nip = '"
                        + nip + "' WHERE nazwa = '" +  companyName + "';";

                jdbcCompanyUtility.executeStatement(sql);
                break;
            }
            case 4: {
                System.out.println("Podaj nazwę firmy ");
                Scanner scanner = new Scanner(System.in);
                String companyName = scanner.nextLine();

                String sql = "DELETE FROM firmy WHERE nazwa = '" + companyName + "';";
                jdbcCompanyUtility.executeStatement(sql);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
