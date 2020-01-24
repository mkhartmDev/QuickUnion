package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        QuickUnion q = new QuickUnion(9 );

        q.union(4, 3);

        q.union(3, 8);




        System.out.print(q.toString());





   }
}

