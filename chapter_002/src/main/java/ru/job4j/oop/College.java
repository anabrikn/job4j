package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Student michael = new Student();
        michael.setName("Михайлов Михаил Михайлович");
        michael.setGroupNumber("145ITACS-5");
        michael.setDate("29.07.2015");

        System.out.println(michael.toString());


        String song = "I believe, I can fly";
        michael.music(song);

    }
}
