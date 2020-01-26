package com.company;

import java.util.Scanner;

public class Main {
    static QuickUnion q;

    public static void main(String[] args) {
        initialize();
        getInput();
   }

    public static void initialize() {
        Scanner scn = new Scanner(System.in);
        System.out.println("How many nodes?");
        int size = scn.nextInt();

        while(size < 1) {
            System.out.println("Please enter a valid size (positive integer)");
            size = scn.nextInt();
        }

        System.out.println("Enable weighting? (Y or N)");
        char ans = scn.next().toUpperCase().charAt(0);
        if(ans == 'Y')
            q = new QuickUnion(size, true);
        else
            q = new QuickUnion(size, false);

    }

    public static void getInput(){
        Scanner scn = new Scanner(System.in);
        printMenu();
        int selection = scn.nextInt();

        while(selection != 5)
        {
            switch (selection){
                case 1: connect();
                break;
                case 2: checkCon();
                break;
                case 3: getDep();
                break;
                case 4: System.out.println(q.toString());
                break;
            }
            printMenu();
            selection = scn.nextInt();
        }
        System.out.println("Peace Out");
    }

    public static void getDep(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the node to find depth");
        int x = scn.nextInt();
        int depth = q.depth(x);
        System.out.println("The depth of node " + x + " is " + depth + "\n");
    }

    public static void connect(){
        Scanner scn = new Scanner(System.in);
        int x,y = 0;
        System.out.println("Enter the first node you would like to connect");
        x = scn.nextInt();
        System.out.println("Enter the second node you would like to connect");
        y = scn.nextInt();
        q.union(x, y);
        System.out.println("Nodes " + x + " and " + y + " have been connected" + "\n");
    }

    public static void checkCon() {
        Scanner scn = new Scanner(System.in);
        int x, y = 0;
        System.out.println("Enter the first node to check connectivity");
        x = scn.nextInt();
        System.out.println("Enter the second node to check connectivity");
        y = scn.nextInt();
        if (q.connected(x, y))
            System.out.println("Nodes " + x + " and " + y + " are connected!" + "\n");
        else
            System.out.println("Nodes " + x + " and " + y + " are NOT connected!" + "\n");
    }


   public static void printMenu(){
        System.out.println("Choose a Menu Option:");
        System.out.println("1: Connect Nodes");
        System.out.println("2: Check Connectivity");
        System.out.println("3: Get Node Depth");
        System.out.println("4: Print Structure as String");
        System.out.println("5: Exit" + "\n");
   }


}

