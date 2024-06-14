package application;

import entities.Department;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter department´s name: ");
        String departamentName= sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName=sc.nextLine();
        System.out.println("Level: ");
        String workerLevel=sc.nextLine();
        System.out.println("Base salary:: ");
        Double baseSalary= sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departamentName));



        sc.close();

        System.out.println("Hello world!");
    }
}