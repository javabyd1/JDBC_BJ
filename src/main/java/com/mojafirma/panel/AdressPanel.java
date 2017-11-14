package com.mojafirma.panel;

import com.mojafirma.utility.JDBCAdressUtility;

import java.util.Scanner;

public class AdressPanel {

    JDBCAdressUtility jdbcAdressUtility = new JDBCAdressUtility();

    public void iniAdressPanel() {

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć bazę adresów, 2 aby dodać adres oraz 3 aby usunąć adres");
        int inputNumber = scanner2.nextInt();

        switch (inputNumber) {
            case 1: {
                jdbcAdressUtility.showData();
                break;
            }
            case 2: {
                System.out.println("Wprowadź miasto, ulicę, nr domu i NIP firmy");
                Scanner scanner = new Scanner(System.in);
                String city = scanner.nextLine();
                String street = scanner.nextLine();
                String number = scanner.nextLine();
                String nip = scanner.nextLine();

                jdbcAdressUtility.insertData(city, street, number, nip);
                break;
            }
            case 3: {
                System.out.println("Id adresu");
                Scanner scanner = new Scanner(System.in);
                int adresId = scanner.nextInt();

                String sql = "DELETE FROM adresy WHERE id_adresu = '" + adresId + "';";
                jdbcAdressUtility.executeStatement(sql);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
