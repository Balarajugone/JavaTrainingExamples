package com.javatraining.assignment4;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.HashSet;

import java.util.LinkedList;

import java.util.TreeMap;

import java.util.TreeSet;

 

public class Collectioncomparision {

    //declaring properties

    private static long startTime;

    private static long endTime;

    private static long beforeMemory;

    private static long afterMemory;

    private static long totalTime;

    private static long totalMemory;

 

 

    public static long getMemoryUsage() {

 

        Runtime runtime = Runtime.getRuntime();

        return runtime.totalMemory() -runtime.freeMemory();

    }

 

    public static void main(String args[]) {

 

        ArrayList<Integer>  arrlist= new ArrayList<>();

        LinkedList<Integer> linkedlist = new LinkedList<>();

        TreeSet<Integer> treeset = new TreeSet<>();

        HashSet<Integer> hashset = new HashSet<>();

        HashMap<String, Integer> hashmap =new HashMap<>();

        TreeMap<String, Integer> treemap = new TreeMap<>();

 

        //time and space complexity of  ArrayList

        startTime = System.nanoTime();

        beforeMemory = getMemoryUsage();

 

        for(int i=0; i<100000; i++) {

            arrlist.add(i);

 

        }

 

        endTime = System.nanoTime();

        afterMemory = getMemoryUsage();

        totalTime = endTime - startTime;

        totalMemory = afterMemory - beforeMemory;

 

        System.out.println("ArrayList Insertion time : "+totalTime+ " Ns");

        System.out.println("ArrayList Memory Usage : "+totalMemory+" bytes");

        System.out.println("================================================");

 

        //time and space complexity of LinkedList

        startTime = System.nanoTime();

        beforeMemory = getMemoryUsage();

 

        for(int i=0; i<100000; i++) {

            linkedlist.add(i);

 

        }

 

        endTime = System.nanoTime();

        afterMemory = getMemoryUsage();

        totalTime = endTime - startTime;

        totalMemory = afterMemory - beforeMemory;

 

        System.out.println("LinkedList Insertion time : "+totalTime+ " Ns");

        System.out.println("LinkedList Memory Usage : "+totalMemory+" bytes");

        System.out.println("================================================");

 

        //time and space complexity of TreeSet

        startTime = System.nanoTime();

        beforeMemory = getMemoryUsage();

 

        for(int i=0; i<100000; i++) {

            treeset.add(i);

 

        }

 

        endTime = System.nanoTime();

        afterMemory = getMemoryUsage();

        totalTime = endTime - startTime;

        totalMemory = afterMemory - beforeMemory;

 

        System.out.println("TreeSet Insertion time : "+totalTime+ " Ns");

        System.out.println("TreeSet Memory Usage : "+totalMemory+" bytes");

        System.out.println("================================================");

 

        //time and space complexity of HashSet

        startTime = System.nanoTime();

        beforeMemory = getMemoryUsage();

 

        for(int i=0; i<100000; i++) {

            hashset.add(i);

 

        }

 

        endTime = System.nanoTime();

        afterMemory = getMemoryUsage();

        totalTime = endTime - startTime;

        totalMemory = afterMemory - beforeMemory;

 

        System.out.println("HashSet Insertion time : "+totalTime+ " Ns");

        System.out.println("HashSet Memory Usage : "+totalMemory+" bytes");

        System.out.println("================================================");

 

 

        //time and space complexity of HashMap

        startTime = System.nanoTime();

        beforeMemory = getMemoryUsage();

 

        for(int i=0; i<100000; i++) {

            hashmap.put("i", i);

 

        }

 

        endTime = System.nanoTime();

        afterMemory = getMemoryUsage();

        totalTime = endTime - startTime;

        totalMemory = afterMemory - beforeMemory;

 

        System.out.println("HashMap Insertion time : "+totalTime+ " Ns");

        System.out.println("HashMap Memory Usage : "+totalMemory+" bytes");

        System.out.println("================================================");

 

        //time and space complexity of  TreeMap

        startTime = System.nanoTime();

        beforeMemory = getMemoryUsage();

 

        for(int i=0; i<100000; i++) {

            treemap.put("i", i);

        }

        endTime = System.nanoTime();

        afterMemory = getMemoryUsage();

        totalTime = endTime - startTime;

        totalMemory = afterMemory - beforeMemory;

 

        System.out.println("TreeMap Insertion time : "+totalTime+ " Ns");

        System.out.println("TreeMap Memory Usage : "+totalMemory+" bytes");

        System.out.println("================================================");


    }

 

}