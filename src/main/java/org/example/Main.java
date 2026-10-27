package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static class Student {
        String name, gender, course;
        boolean allotted = false;

        Student(String name, String gender, String course) {
            this.name = name;
            this.gender = gender;
            this.course = course;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] s = new Student[20];


        for (int i = 0; i < 20; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender (Boy/Girl): ");
            String gender = sc.nextLine().trim();

            System.out.print("Course (UG/PG): ");
            String course = sc.nextLine().trim();

            s[i] = new Student(name, gender, course);
        }

        int room = 1;
        int[] roomOf = new int[20];


        for (int i = 0; i < 20; i++) {
            if (s[i].allotted)
                continue;

            int partner = -1;


            for (int j = i + 1; j < 20; j++) {
                if (!s[j].allotted
                        && s[i].gender.equalsIgnoreCase(s[j].gender)
                        && s[i].course.equalsIgnoreCase(s[j].course)) {
                    partner = j;
                    break;
                }
            }

            if (partner == -1) {
                for (int j = i + 1; j < 20; j++) {
                    if (!s[j].allotted
                            && s[i].gender.equalsIgnoreCase(s[j].gender)) {
                        partner = j;
                        break;
                    }
                }
            }

            s[i].allotted = true;
            roomOf[i] = room;

            if (partner != -1) {
                s[partner].allotted = true;
                roomOf[partner] = room;
            }

            room++;
        }



        for (int r = 1; r < room; r++) {
            System.out.println("\nRoom " + r + ":");

            for (int i = 0; i < 20; i++) {
                if (roomOf[i] == r) {
                    System.out.println(
                            "Name: " + s[i].name
                                    + " | Gender: " + s[i].gender
                                    + " | Course: " + s[i].course
                    );
                }
            }
        }

        sc.close();
    }
}