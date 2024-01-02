package com.mukila;
import java.util.LinkedList;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        LinkedList<Member> memberList = new LinkedList<>();
        Member aditya = new Member("Aditya", 20, "male");
        Member murali = new Member("Murali", 52, "male");
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
         * 5 TODO
         * 6 quit
         */
        while (true) {
            int input = printMenu();
            switch (input) {
                case 1:
                memberList.add(addMember());
                break;
                case 2:
                itemList.add(addItem());
                break;
                case 3:
                checkoutItem(itemList);
                break;
                case 4:
                returnItem(itemList);
                break;
                case 5:
                break;
                case 6:
                quit(memberList, itemList);
                break;
                default:
                System.out.println("Invalid Input: Input an integer from 1 to 6.");
                break;
            }
        }
    }

    public static int printMenu()
    {
        System.out.println("1: Add Member");
        System.out.println("2: Add Item");
        System.out.println("3: Checkout Item");
        System.out.println("4: Return Item");
        System.out.println("5: null");
        System.out.println("6: Quit");
        int input = -1;
        System.out.print("Select an option:\t");
        try
        {
            input = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }
        return input;
    }

    public static Member addMember()
    {
        String name = null;
        int age = -1;
        String gender = null;

        try {
            System.out.print("Name:\t");
            name = (br.readLine());
            System.out.print("Age:\t");
            age = Integer.parseInt(br.readLine());
            System.out.print("Gender (\'male\' or \'female\'):\t");
            gender = (br.readLine());
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }
        
        Member member = new Member(name, age, gender);
        return member;
    }

    public static Item addItem()
    {
        System.out.println("b: Book");
        System.out.println("m: Magazine");
        System.out.println("d: DVD");
        System.out.print("Choose a type of Item to add:\t");
        String input = null;
        
        try
        {
            input = (br.readLine());
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }

        if (input.equalsIgnoreCase("b"))
        {
            String title = null;
            String author = null;
            
            try {
                System.out.print("Title:\t");
                title = (br.readLine());
                System.out.print("Author:\t");
                author = (br.readLine());
            } catch (Exception e) {
                System.err.print(e);
                System.exit(1);
            }

            Book book = new Book(title, author, null);
            return book;
        } else if (input.equalsIgnoreCase("m"))
        {
            String title = null;
            String editor = null;
            
            try {
                System.out.print("Title:\t");
                title = (br.readLine());
                System.out.print("Editor:\t");
                editor = (br.readLine());
            } catch (Exception e) {
                System.err.print(e);
                System.exit(1);
            }

            Magazine magazine = new Magazine(title, editor, null);
            return magazine;
        } else if (input.equalsIgnoreCase("d"))
        {
            String title = null;
            String director = null;
            
            try {
                System.out.print("Title:\t");
                title = (br.readLine());
                System.out.print("Director:\t");
                director = (br.readLine());
            } catch (Exception e) {
                System.err.print(e);
                System.exit(1);
            }

            DVD dvd = new DVD(title, director, null);
            return dvd;
        }

        System.out.println("Invalid Input: Input the letter \'b\', \'m\', or \'d\'");
        return null;
    }

    public static void checkoutItem(LinkedList<Item> itemList)
    {
        String input = null;
        
        try {
            System.out.print("Name of item to checkout:\t");
            input = br.readLine();
            int size = itemList.size();
            for (int  i = 0; i < size; i++)
            {
                if (itemList.get(i).getTitle().equalsIgnoreCase(input))
                {
                    if (itemList.get(i).getOwner() == null)
                    {
                        System.out.print("Name of member checking out:\t");
                        input = br.readLine();
                        itemList.get(i).setOwner(input);
                        System.out.println("Item has been checked out.");
                    } else {
                        System.out.println("This item is already checked out.");
                    }

                    break;
                }
            }
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }
    }

    public static void returnItem(LinkedList<Item> itemList)
    {
        String input = null;
        
        try {
            System.out.print("Name of item to return:\t");
            input = br.readLine();
            int size = itemList.size();
            for (int  i = 0; i < size; i++)
            {
                if (itemList.get(i).getTitle().equalsIgnoreCase(input))
                {
                    if (itemList.get(i).getOwner() != null)
                    {
                        itemList.get(i).setOwner(null);
                        System.out.println("Item has been returned.");
                    } else {
                        System.out.println("This item is not checked out.");
                    }

                    break;
                }
            }
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }
    }

    public static void quit(LinkedList<Member> memberList, LinkedList<Item> itemList)
    {
        try {
            FileWriter mem = new FileWriter("Members.txt");
            for (int i = 0; i < memberList.size(); i++)
            {
                mem.write(memberList.get(i).getName());
                mem.write("\n");
                mem.write(memberList.get(i).getAge());
                mem.write("\n");
                mem.write(memberList.get(i).getGender());
                mem.write("\n");
            }
            mem.close();

            FileWriter itm = new FileWriter("Items.txt");
            for (int i = 0; i < itemList.size(); i++)
            {
                itm.write(itemList.get(i).getType());
                itm.write("\n");
                itm.write(itemList.get(i).getTitle());
                itm.write("\n");
                itm.write(itemList.get(i).getOwner());
                itm.write("\n");
            }
            itm.close();
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }
        System.out.println("Goodbye...");
        try {
            br.close();
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }
        System.exit(0);
    }
}