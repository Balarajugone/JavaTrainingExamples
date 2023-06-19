package com.javatraining.assignment4;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.LinkedList;

 

public class ArraylistInsertionandDeletion {

    

    public static void main(String args[]) {

        

        long startTime;

        long endTime;

        long totalTime;

        

        //insertion time complexity of ArryList

        ArrayList<Integer> arraylist = new ArrayList<>();

        LinkedList<Integer> linkedlist = new LinkedList<>();

        

        startTime = System.nanoTime();

        for (int i=0; i<100000; i++) {

            arraylist.add(i);

            

        }

        endTime = System.nanoTime();

        totalTime = endTime - startTime;

        System.out.println("ArrayList Insertion time :"+ totalTime);

        System.out.println("=========================================");

        

        //retrieve time complexity of ArrayList

        

        startTime = System.nanoTime();

        

        for (Integer integer : arraylist) {

            

        arraylist.get(integer);

            

        }

    

        endTime = System.nanoTime();

        totalTime = endTime - startTime;

        System.out.println("ArrayList retrieve time :"+totalTime);

        System.out.println("=========================================");

        

        //remove time complexity of ArrayList

        

        startTime = System.currentTimeMillis();

 

        Iterator<Integer> itr=arraylist.iterator();

        while(itr.hasNext())    {

            

            itr.next();

            

                itr.remove();

            }

        

        endTime = System.currentTimeMillis();

        totalTime = endTime - startTime;

        System.out.println("ArrayList remove time complexity :"+totalTime);

        System.out.println("=========================================");

        

        //insertion time complexity of LinkedList

        

        startTime = System.nanoTime();

        for (int i =0; i<100000; i++) {

            linkedlist.add(i);

            

        }

        endTime = System.nanoTime();

        totalTime = endTime - startTime;

        System.out.println("LinkedList Insertion time :"+ totalTime);

        System.out.println("=========================================");

        

        //retrieve time complexity of LinkedList

        startTime = System.nanoTime();

        for (Integer integer : linkedlist) {

            

            linkedlist.get(integer);

                

        }

        

        endTime = System.nanoTime();

        totalTime = endTime - startTime;

        System.out.println("LinkedList retrieve time :"+totalTime);

        System.out.println("=========================================");

        

        //remove time complexity of LinkedList

        

        startTime = System.nanoTime();

        

            Iterator<Integer> itr1 = linkedlist.iterator();

            

            while(itr1.hasNext()) {

                itr1.next();

                itr1.remove();

            }

        

        endTime = System.nanoTime();

        totalTime = endTime - startTime ;

        

        System.out.println("Linkedlist remove time complexity :"+totalTime);

        System.out.println("=========================================");

        

    }

 

}