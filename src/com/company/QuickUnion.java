package com.company;

import java.util.Arrays;

public class QuickUnion{
    private int[] id;
    private int [] size;
    private int c;
    private boolean weight;

    public QuickUnion(int n, boolean w)
    {
        id = new int[n];
        size = new int[n];
        weight = w;

        for(int i = 0; i < n; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int getCount(){
        return c;
    }

    public int getSize(int j){
        return size[j];
    }

    public boolean connected(int x, int y)
    {
        return find(x) == find(y);
    }

    public int find(int n){
        while (n != id[n]) {
            n= id[n];
        }

        return n;
    }

    public int depth(int n){

        return 1;
    }


    public void union(int x, int y)
    {
        int id_1 = find(x);
        int id_2 = find(y);

        if(weight)
        {
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
        }
        else {
            if (id_1 != id_2) {
                id[id_1] = id_2;
                size[id_2] += size[id_1];
            }

//            for (int i = 0; i < id.length; i++) {
//                if (id[i] == id_1) {
//                    size[i] = size[id_1];
//                }
//            }

        }


    }

    @Override
    public String toString() {
        int index[] = new int[id.length];
        for(int i = 0; i < id.length; i++)
            index[i] = i;
        return "Node#="  +
                Arrays.toString(index) + "\n" +
                "Value=" + Arrays.toString(id) + "\n" +
                "Size =" + Arrays.toString(size) + "\n";

    }
}
