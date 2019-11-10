package ru.geekbrains.javaone.lesson4;

public class Main {
    public static void main(String[] args) {
        Employee[] emps = {
                new Employee("Иванов Иван Иванович", "Андроид разработчик", "+79269885125", 150000.02, 30),
                new Employee("Петров Петр Петрович", "Графический дизайнер", "+79295143864", 85000.23, 46),
                new Employee("Галченкова Мария Федоровна", "Секретарь", "+79263543636", 28000.0, 25),
                new Employee("Жданова Анастасия Юрьевна", "Маркетолог", "+79295681416", 85500.6, 48),
                new Employee("Хромченко Елена Александровна", "Бренд менеджер", "+79254822564", 120000.0, 42)
        };


        showInfolist(emps);
        System.out.println();

        showInfoLimitAge(emps, 40);
        System.out.println();

        newSalary(emps, 45, 5000);


    }


    public static void showInfolist(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Уникальный номер сотрудника: " + employees[i].getId() + " ФИО сотрудника: " + employees[i].getFullName() + " Должность сотрудника: " + employees[i].getPosition());
        }
    }

    public static void showInfoLimitAge(Employee[] employees, int limitAge) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > limitAge) {
                System.out.println(employees[i]);
            }
        }

    }

    public static void newSalary(Employee[] employees, int limitAge, int increase) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > limitAge) {
                double newSalary = employees[i].getSalary() + increase;
                employees[i].setSalary(newSalary);

                System.out.println("Новая зарплата сотрудника " + employees[i].getFullName() + " " + employees[i].getSalary());
            }
        }

    }
}

