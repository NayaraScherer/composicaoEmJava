package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;



public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department´s name: ");
        String departamentName= sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName=sc.nextLine();
        System.out.println("Level: ");
        String workerLevel=sc.nextLine();
        System.out.println("Base salary:: ");
        Double baseSalary= sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,new Department(departamentName));
        System.out.printf("How many contracts to this worker? ");
        int n= sc.nextInt();

        for (int i =1; i<=n;i++){
            System.out.printf("ENter contract #"+ i +" data: ");
            System.out.print("Date DD/MM/YYYY: ");
            Date contractDate = sdf.parse(sc.next());
            System.out.println( "Value per hour: ");
            double valuerPerHour = sc.nextDouble();
            System.out.print("Duration (hour): ");
            int hours = sc.nextInt();
            HourContract contract= new HourContract(contractDate,valuerPerHour,hours);
            worker.addContratct(contract);
        }
        System.out.println("");
        System.out.print("Enter moth and year to calculate income (MM/YYYY): ");
        String monthAndYear =sc.next();
        int month =Integer.parseInt(monthAndYear.substring(0,2));
        int year =Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: "+worker.getName());
        System.out.println("Departament: "+ worker.getDepartment().getName());
        System.out.println("Income for "+ monthAndYear+ ": "+ worker.income(month, year));




        sc.close();

        System.out.println("Hello world!");
    }
}