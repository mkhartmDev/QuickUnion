package com.company;

import java.util.Arrays;

public class QuickUnion{
    private int[] id;
    private int [] size;
    private boolean weight;
    private int depth;

    public QuickUnion(int n, boolean w)
    {
        id = new int[n];
        size = new int[n];
        weight = w;
        depth = 1;

        for(int i = 0; i < n; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
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
        int current = n;
        int next = id[n];

        if(current == next) {
            return 0;
        }
        return depth(next) + 1;
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
            }
        }
        else {
            if (id_1 != id_2) {
                id[id_1] = id_2;
                size[id_2] += size[id_1];
            }
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
