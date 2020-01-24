package com.company;

import java.util.Arrays;

public class QuickUnion{
    private int[] id;
    private int [] size;
    private int c;

    public QuickUnion(int n)
    {
        id = new int[n];
        size = new int[n];
        int c;

        for(int i = 0; i < n; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int getCount(){
        return c;
    }

    public boolean connected(int x, int y)
    {
        return find(x) == find(y);
    }

    public int find(int n){
        n = id[n];
        return n;
    }

    public void union(int x, int y)
    {
        int id_1 = x;
        int id_2 = y;

        if(id_1 != id_2)
        {
            if(size[id_1] < size[id_2]){
                id[id_1] = id_2;
                size[id_2] += size[id_1];
            }
            else{
                id[id_2] = id_1;
                size[id_1] += size[id_2];
            }
            c--;
        }

//        for(int i = 0; i < id.length; i++)
//        {
//            if(id[i] == id_1)
//                id[i] = id_2;
//        }
    }

    @Override
    public String toString() {
        return "QuickUnion{" +
                "id=" + Arrays.toString(id) +
                '}' +
                "/n" + "size=" + Arrays.toString(size);

    }
}
