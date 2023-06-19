package com.javatraining.assignment4;

import java.util.HashSet;

import java.util.Iterator;

import java.util.TreeSet;

 

public class HashsetInsertionandDeletion {

 

    

    public static void main(String args[]) {

        

        long beforeTime;

        long afterTime;

        long totalTime;

        HashSet<Integer> hashset = new HashSet<>();

        TreeSet<Integer> treeset = new TreeSet<>();

        //add time complexity of HashSet

        beforeTime = System.nanoTime();

        for(int i = 0; i<100000; i++) {

            hashset.add(i);

            

        }

        afterTime = System.nanoTime();

        totalTime = afterTime - beforeTime;

        System.out.println();

        System.out.println("HashSet insertion time complexity :"+totalTime);

        System.out.println("======================================");

        

        

        //deletion elements of HashSet time complexity

                beforeTime = System.nanoTime();

                Iterator<Integer> itr = hashset.iterator();

                while(itr.hasNext()) {

                    itr.next();

                    itr.remove();

                }

                            

                

                afterTime = System.nanoTime();

                totalTime = afterTime - beforeTime;

                System.out.println("HashSet deletion time complexity :"+totalTime);

                System.out.println("======================================");

                

                //add elements time complexity of TreeSet

                beforeTime = System.nanoTime();

                for(int i = 0; i<100000; i++) {

                    treeset.add(i);

                    

                }

                afterTime = System.nanoTime();

                totalTime = afterTime - beforeTime;

                System.out.println("TreeSet insertion time complexity :"+totalTime);

                System.out.println("======================================");

                

                

                //deletion elements of TreeSet time complexity

                        beforeTime = System.nanoTime();

                        Iterator<Integer> itr1 = treeset.iterator();

                        while(itr1.hasNext()) {

                            itr1.next();

                            itr1.remove();

                        }

                        afterTime = System.nanoTime();

                        totalTime = afterTime - beforeTime;

                        System.out.println("TreeSet deletion time complexity :"+totalTime);

                        System.out.println("======================================");

    }

}