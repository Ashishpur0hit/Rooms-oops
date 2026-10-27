package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


//    static class Student {
//        String name, gender, course;
//        boolean allotted = false;
//
//        Student(String name, String gender, String course) {
//            this.name = name;
//            this.gender = gender;
//            this.course = course;
//        }
//    }


    public static void main(String[] args) {

                List<Integer> boys_pair = new ArrayList<>();
        List<Integer> girls_pair = new ArrayList<>();
        List<Integer> not_alloc = new ArrayList<>();

        char[] students = {
                'M', 'F', 'M', 'M', 'F',
                'F', 'M', 'F', 'M', 'M',
                'F', 'M', 'F', 'F', 'M',
                'M', 'F', 'M', 'F', 'M',
                'F'
        };

        List<List<Integer>> rooms= new ArrayList<>();

        int boys = 0,girls=0;
        for(int i=0;i<21;i++)
        {
            if(students[i]=='M') boys++;
            else girls++;
        }
        for(int i=0;i<21;i++)
        {
                if(students[i]=='M')
                {
                    boys_pair.add(i);
                }
                else {
                    girls_pair.add(i);
                }

                if(boys_pair.size()==2)
                {
                    rooms.add(new ArrayList<>(boys_pair));
                    boys_pair.clear();
                }
                if(girls_pair.size()==2) {
                    rooms.add(new ArrayList<>(girls_pair));
                    girls_pair.clear();
                }
        }
        not_alloc.addAll(boys_pair);
        not_alloc.addAll(girls_pair);
        for(int i=0;i<rooms.toArray().length;i++)
        {
            System.out.println("room number "+i+" is allocated to Student "+rooms.get(i).get(0) +" and "+rooms.get(i).get(1) + " are in same room");
        }
        System.out.println("Not allocating Students are");
        for(int i=0;i<not_alloc.toArray().length;i++) {
            System.out.println(not_alloc.get(i));
        }






//        Scanner sc = new Scanner(System.in);
//
//        Student[] s = new Student[20];
//
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println("\nEnter details of Student " + (i + 1));
//
//            System.out.print("Name: ");
//            String name = sc.nextLine();
//
//            System.out.print("Gender (Boy/Girl): ");
//            String gender = sc.nextLine().trim();
//
//            System.out.print("Course (UG/PG): ");
//            String course = sc.nextLine().trim();
//
//            s[i] = new Student(name, gender, course);
//        }
//
//        int room = 1;
//        int[] roomOf = new int[20];
//
//
//        for (int i = 0; i < 20; i++) {
//            if (s[i].allotted)
//                continue;
//
//            int partner = -1;
//
//
//            for (int j = i + 1; j < 20; j++) {
//                if (!s[j].allotted
//                        && s[i].gender.equalsIgnoreCase(s[j].gender)
//                        && s[i].course.equalsIgnoreCase(s[j].course)) {
//                    partner = j;
//                    break;
//                }
//            }
//
//            if (partner == -1) {
//                for (int j = i + 1; j < 20; j++) {
//                    if (!s[j].allotted
//                            && s[i].gender.equalsIgnoreCase(s[j].gender)) {
//                        partner = j;
//                        break;
//                    }
//                }
//            }
//
//            s[i].allotted = true;
//            roomOf[i] = room;
//
//            if (partner != -1) {
//                s[partner].allotted = true;
//                roomOf[partner] = room;
//            }
//
//            room++;
//        }
//
//
//
//        for (int r = 1; r < room; r++) {
//            System.out.println("\nRoom " + r + ":");
//
//            for (int i = 0; i < 20; i++) {
//                if (roomOf[i] == r) {
//                    System.out.println(
//                            "Name: " + s[i].name
//                                    + " | Gender: " + s[i].gender
//                                    + " | Course: " + s[i].course
//                    );
//                }
//            }
//        }
//
//        sc.close();
    }
}