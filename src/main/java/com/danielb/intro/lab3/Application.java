package com.danielb.intro.lab3;

public class Application {

    public static void main(String[] args) {
        Teacher Steven = new Teacher("src/main/resources/Students.txt", "src/main/resources/Memorable.txt");
        Student Jacob = new Student("Jacob", 679);
        Student Adeline = new Student("Adeline", 276);
        System.out.println("TESTING " + Steven.recallName(Jacob));
        System.out.println("TESTING " + Steven.recallName(Adeline));
    }

}
