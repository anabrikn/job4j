package ru.job4j.oop;

public class Student {
    private String name;
    private String groupNumber;
    private String date;

    public void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Имя студента: " + this.getName() + " Номер группы: " + this.getGroupNumber() + " Дата поступления: " + this.getDate();
    }
}
