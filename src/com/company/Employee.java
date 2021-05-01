package com.company;
import java.util.*;

public class Employee implements Comparable<Employee> {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + salary;
    }

    @Override
    public int compareTo(Employee employee) {
        if (getSalary() > employee.getSalary()) {
            return 1;
        }
        if (getSalary() < employee.getSalary()) {
            return -1;
        }
        return getName().compareTo(employee.getName());
    }

    public static void main(String[] args) {

        List<Employee> staffList = initList();

        System.out.println("Работа с множеством\n");
        Set<Employee> staffSet = new TreeSet<>(staffList);
        print(staffSet);

        System.out.println("\nРабота со списком\n");
        System.out.println("После создания списка:");
        print(staffList);
        sortEmployee(staffList);
        System.out.println("\nОтсортированный список:");
        print(staffList);
    }

    public static List<Employee> initList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Катя", 8000));
        list.add(new Employee("Алина", 1000000));
        list.add(new Employee("Даша", 8000));
        list.add(new Employee("Аня", 50));
        list.add(new Employee("Настя", 900000));
        list.add(new Employee("Лена", 50));
        list.add(new Employee("Полина", 8000));
        return list;
    }

    public static void sortEmployee(List<Employee> employeeList) {
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getSalary() > e2.getSalary()) {
                    return 1;
                }
                if (e1.getSalary() < e2.getSalary()) {
                    return -1;
                }
                return e1.getName().compareTo(e2.getName());
            }
        });
    }

    private static void print(Collection<Employee> list) {
        list.forEach(System.out::println);
    }
}
