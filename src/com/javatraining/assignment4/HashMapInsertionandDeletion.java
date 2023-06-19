package com.javatraining.assignment4;

import java.util.HashMap;
import java.util.TreeMap;

 

public class HashMapInsertionandDeletion {

    public static void main(String args[]) {
    //declaring variables;    
    long beforeTime;
    long afterTime;
    long totalTime;

       //insertion time complexity of HashMap
          HashMap<String, Integer> hashmap = new HashMap<>();
          TreeMap<String, Integer> treemap = new TreeMap<>();

          beforeTime = System.nanoTime();
          for(int i =0; i<100000; i++) {
              hashmap.put("i", i);
          }
          afterTime = System.nanoTime();
          totalTime = afterTime - beforeTime;
          System.out.println("HashMap insertion time complexity :"+totalTime);

          //Remove time complexity of HashMap

          beforeTime = System.nanoTime();
          hashmap.remove("i");
          afterTime = System.nanoTime();
          totalTime = afterTime - beforeTime;
          System.out.println("Remove elements time complexity of HashMap :"+totalTime);

          //Insertion elements time complexity of TreeMap

          beforeTime = System.nanoTime();
          for(int i = 0; i<100000; i++) {
              treemap.put("i", i);
          }
          afterTime = System.nanoTime();
          totalTime = afterTime - beforeTime;
          System.out.println("Insertion time complexity of TreeMap :"+totalTime);

          //remove elements time complexity of TreeMap

          beforeTime = System.nanoTime();
          treemap.remove("i", 99999);
          afterTime = System.nanoTime();
          totalTime = afterTime - beforeTime;
          System.out.println("deletion time complexity of TreeMap :"+totalTime);

        }


}
