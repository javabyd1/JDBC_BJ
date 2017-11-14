package com.mojafirma.panel;

import com.mojafirma.utility.Database;

import java.util.Scanner;

public class MainPanel {

    public void iniMainPanel() {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Z którą tabelą chcesz pracować?");
        System.out.println("1 - adresy, 2 - pracownicy, 3 - stanowiska, 4 - firmy, 0 - wyjście z programu");
        int choosingTable = scanner1.nextInt();

        switch (choosingTable) {
            case 0 : {
                Database.closeConnection();
                break;
            }
            case 1 : {
                AdressPanel adressPanel = new AdressPanel();
                adressPanel.iniAdressPanel();
                iniMainPanel();
                break;
            }
            case 2 : {
                WorkerPanel workerPanel = new WorkerPanel();
                workerPanel.iniWorkerPanel();
                iniMainPanel();
                break;
            }
            case 3 : {
                StandingPanel standingPanel = new StandingPanel();
                standingPanel.iniStandingPanel();
                iniMainPanel();
                break;
            }
            case  4 : {
                CompanyPanel companyPanel = new CompanyPanel();
                companyPanel.iniCompanyPanel();
                iniMainPanel();
                break;
            }
            default : {
                System.out.println("Błędne wprowadzenie");
                iniMainPanel();
            }
        }
    }
}
