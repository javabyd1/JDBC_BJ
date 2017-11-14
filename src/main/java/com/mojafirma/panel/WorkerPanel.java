package com.mojafirma.panel;

import com.mojafirma.utility.JDBCWorkerUtility;

import java.util.Scanner;

public class WorkerPanel {

    JDBCWorkerUtility jdbcWorkerUtility = new JDBCWorkerUtility();

    public void iniWorkerPanel() {

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć listę pracowników, 2 aby dodać pracownika, 3 aby zaktualizować dane pracownika " +
                "oraz 4 aby usunąć pracownika z bazy");
        int inputNumber = scanner2.nextInt();

        switch (inputNumber) {
            case 1: {
                jdbcWorkerUtility.showData();
                break;
            }
            case 2: {
                System.out.println("Wprowadź imię, nazwisko, kolor oczu, wzrost, telefon, email, id_stanowsika i id_firmy");
                Scanner scanner1 = new Scanner(System.in);
                String name = scanner1.nextLine();
                String surname = scanner1.nextLine();
                String eye_color = scanner1.nextLine();

                Scanner scanner3 = new Scanner(System.in);
                int heigh = scanner3.nextInt();
                String phone = scanner1.nextLine();
                String email = scanner1.nextLine();
                int stand_id = scanner3.nextInt();
                int company_id = scanner3.nextInt();

                jdbcWorkerUtility.insertData(name, surname, eye_color, heigh, phone, email, stand_id, company_id);
                break;
            }
            case 3: {
                System.out.println("Podaj imie i nazwisko pracownika");
                Scanner scanner = new Scanner(System.in);
                String workerName = scanner.nextLine();
                String workerLastName = scanner.nextLine();
                System.out.println("Podaj telefon, email, id stanowsika i id firmy");

                String phone = scanner.nextLine();
                String email = scanner.nextLine();
                Scanner scanner1 = new Scanner(System.in);
                int stand_id = scanner1.nextInt();
                int company_id = scanner1.nextInt();

                String sql = "UPDATE pracownicy SET telefon = '" + phone + "', email = '" + email + "', id_stanowiska = '"
                        + stand_id + "', id_firmy = '" + company_id +"'  WHERE imie = '" +  workerName + "' AND nazwisko = '" +  workerLastName + "';";

                jdbcWorkerUtility.executeStatement(sql);
                break;
            }
            case 4: {
                System.out.println("Podaj imie i nazwisko pracownika ");
                Scanner scanner = new Scanner(System.in);
                String workerName = scanner.nextLine();
                String workerLastName = scanner.nextLine();

                String sql = "DELETE FROM pracownicy WHERE imie = '" + workerName + "' AND nazwisko = '" + workerLastName +"';";
                jdbcWorkerUtility.executeStatement(sql);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
