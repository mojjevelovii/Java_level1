package ru.geekbrains.javaone.lesson4;
/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
2. Конструктор класса должен заполнять эти поля при создании объекта;
3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
4. Вывести при помощи методов из пункта 3 ФИО и должность.
5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию
   только о сотрудниках старше 40 лет;
6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
7. *** Продумать конструктор таким образом, чтобы при создании каждому
   сотруднику присваивался личный уникальный идентификационный порядковый номер */


public class Employee {
    private String fullName;
    private String position;
    private String phone;
    private double salary;
    private int age;
    private static int uniqueId = 0;
    private int id;


    public int getId() {
        return id;
    }

    Employee(String fullName, String position, String phone, double salary, int age) {
        this.id = uniqueId++;
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ФИО сотрудника: " + getFullName() +
                " Должность сотрудника: " + getPosition() +
                " Номер телефона: " + getPhone() +
                " Зарплата сотрудника: " + getSalary() +
                " Возраст сотрудника: " + getAge();
    }
}
