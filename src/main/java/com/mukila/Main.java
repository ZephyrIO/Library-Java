package com.mukila;
import java.util.LinkedList;
import java.io.*;

public class Main
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        LinkedList<Member> memberList = new LinkedList<>();
        LinkedList<Item> itemList = new LinkedList<>();

        /* menu:
         * 1 add member
         * 2 add item
         * 3 checkout item
         * 4 return item
         * 5 list members
         * 6 list items
         * 7 quit
         */
        while (true) {
            int input = printMenu();
            switch (input) {
                case 1:
                Member member = addMember();
                if (member != null)
                {
                    memberList.add(member);
                } else {
                    System.out.println("Invalid Input");
                }
                break;
                case 2:
                Item item = addItem();
                if (item != null)
                {
                    itemList.add(item);
                } else {
                    System.out.println("Invalid Input");
                }
                break;
                case 3:
                checkoutItem(itemList);
                break;
                case 4:
                returnItem(itemList);
                break;
                case 5:
                listMembers(memberList);
                break;
                case 6:
                listItems(itemList);
                break;
                case 7:
                quit(memberList, itemList);
                break;
                default:
                System.out.println("Invalid Input: Input an integer from 1 to 7.");
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
        System.out.println("5: List Members");
        System.out.println("6: List Items");
        System.out.println("7: Quit");
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
        
        Member member = null;
        if (name != null && age != -1 && gender != null)
        {
            member = new Member(name, age, gender);
        }
        return member;
    }

    public static Item addItem()
    {
        String title = null;
        String type = null;
        String creator = null;

        try {
            System.out.print("Title:\t");
            title = (br.readLine());
            System.out.print("Type:\t");
            type = br.readLine();
            System.out.print("Creator (Author, Director, Editor, etc.):\t");
            creator = (br.readLine());
        } catch (Exception e) {
            System.err.print(e);
            System.exit(1);
        }

        Item item = null;
        if (title != null && type != null && creator != null)
        {
            item = new Item(title, null, type, creator);
        }
        return item;
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

    public static void listMembers(LinkedList<Member> memberList)
    {
        System.out.print("Members: ");
        for(int i = 0; i < memberList.size(); i++)
        {
            System.out.print(memberList.get(i).getName());
            if(++i < memberList.size())
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void listItems(LinkedList<Item> itemList)
    {
        System.out.print("Items: ");
        for(int i = 0; i < itemList.size(); i++)
        {
            System.out.print(itemList.get(i).getTitle());
            if(++i < itemList.size())
            {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void quit(LinkedList<Member> memberList, LinkedList<Item> itemList)
    {
        try {
            FileWriter mem = new FileWriter("Members.save");
            for (int i = 0; i < memberList.size(); i++)
            {
                mem.write(memberList.get(i).getName());
                mem.write("\n");
                mem.write(Integer.toString(memberList.get(i).getAge()));
                mem.write("\n");
                mem.write(memberList.get(i).getGender());
                mem.write("\n");
            }
            mem.close();

            FileWriter itm = new FileWriter("Items.save");
            for (int i = 0; i < itemList.size(); i++)
            {
                itm.write(itemList.get(i).getType());
                itm.write("\n");
                itm.write(itemList.get(i).getTitle());
                itm.write("\n");
                itm.write(itemList.get(i).getOwner());
                itm.write("\n");
                itm.write(itemList.get(i).getCreator());
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