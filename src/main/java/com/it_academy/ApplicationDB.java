package com.it_academy;

import com.it_academy.service.DeveloperService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static com.it_academy.query_executor.DeveloperQueryExecutor.*;

public class ApplicationDB {
    private static final String DATA_BASE_URL =
            "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\resources\\developersdb.db";

    public static void main(String[] args) throws SQLException {
        if (isDriverExists()) {
            Connection connection = DriverManager.getConnection(DATA_BASE_URL);
            String action;
            do {
                printMenu();
                action = new Scanner(System.in).nextLine();
                switch (action) {
                    case "1":
                        printAllDevelopers(connection);
                        break;
                    case "2":
                        addDeveloper(connection, DeveloperService.inputDeveloper()) ;
                        break;
                    case "3":
                        System.out.println("Enter id for delete");
                        int idForDelete = new Scanner(System.in).nextInt();
                        deleteDeveloper(connection, idForDelete);
                        break;
                    case "4":
                        System.out.println("Enter id for update");
                        int idForUpdate = new Scanner(System.in).nextInt();
                        updateDeveloper(connection, idForUpdate, DeveloperService.inputDeveloper());
                        break;
                }
            } while (!"5".equals(action));
            connection.close();
        }
    }

    public static boolean isDriverExists() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver was not found");
            return false;
        }
    }

    private static void printMenu() {
        System.out.println("1 - show all developers");
        System.out.println("2 - add new developer");
        System.out.println("3 - delete developer");
        System.out.println("4 - update developer");
        System.out.println("5 - exit");
    }
}
