package com.mojafirma.panel;

import com.mojafirma.utility.JDBCStandingUtility;

import java.util.Scanner;

public class StandingPanel {

    JDBCStandingUtility jdbcStandingUtility = new JDBCStandingUtility();

    public void iniStandingPanel() {

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć listę stanowisk, 2 aby dodać stanowisko lub 3 aby usunąć stanowisko");
        int inputNumber = scanner2.nextInt();

        switch (inputNumber) {
            case 1: {
                jdbcStandingUtility.showData();
                break;
            }
            case 2: {
                System.out.println("Wprowadź nazwę stanowiska");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();

                jdbcStandingUtility.insertData(name);
                break;
            }
            case 3: {
                System.out.println("Podaj nazwę stanowiska ");
                Scanner scanner = new Scanner(System.in);
                String standingName = scanner.nextLine();

                String sql = "DELETE FROM stanowiska WHERE nazwa = '" + standingName + "';";
                jdbcStandingUtility.executeStatement(sql);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
