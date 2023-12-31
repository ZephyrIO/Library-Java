package com.mukila;
import java.util.LinkedList;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        LinkedList<Member> memberList = new LinkedList<>();
        Member aditya = new Member("Aditya", 20, 2023, 12, 30);
        Member murali = new Member("Murali", 52, 2023, 12, 30);
        memberList.add(aditya);
        memberList.add(murali);

        LinkedList<Item> itemList = new LinkedList<>();
        Item book1 = new Book("Rich Dad, Poor Dad", "Mukila", null);
        Item magazine1 = new Magazine("Time", "New York Times", null);
        Item dvd1 = new DVD("Blackhat", "Chris Hemswork", null);
        itemList.add(book1);
        itemList.add(magazine1);
        itemList.add(dvd1);

        /* menu:
         * 1 add member
         * 2 add item
         * 3 checkout item
         * 4 return item
         * 5 quit
         */
        while (true) {
            int input = printMenu();
            switch (input) {
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5:
                System.out.println("Goodbye...");
                try {
                    br.close();
                } catch (Exception e) {
                    System.err.print(e);
                    System.exit(1);
                }
                System.exit(0);
                break;
                default:
                System.out.println("Invalid Input. Input an integer from 1 to 5.");
                break;
            }
        }
    }

    public static int printMenu()
    {
        System.out.println("1 Add Member");
        System.out.println("2 Add Item");
        System.out.println("3 Checkout Item");
        System.out.println("4 Return Item");
        System.out.println("5 Quit");
        int input = -1;
        try
        {
            input = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }
        return input;
    }
}