package com.it_academy.service;

import com.it_academy.model.Developer;

import java.util.Scanner;

public class DeveloperService {

    public static Developer inputDeveloper() {
        Developer developer = new Developer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dev name: ");
        developer.setName(scanner.nextLine());
        System.out.println("Enter dev specialty: ");
        developer.setSpecialty(scanner.nextLine());
        System.out.println("Enter dev salary: ");
        developer.setSalary(Integer.parseInt(scanner.nextLine()));
        return developer;
    }
}
