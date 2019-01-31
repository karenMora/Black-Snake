/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author hcadavid
 */
public class CountThread  extends Thread{
    
    public void run(int a, int  b){
        //int numA=0;
        //int numB=10;
        //int numC=ThreadLocalRandom.current().nextInt(numA, numB);
        //System.out.println(numC);
        
        for(int i=a;i<b;i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        //CountThread hilo=new CountThread();
        //hilo.start();
        
    }
    
   public CountThread(int a, int b){
       run(a,b);
   }
   
    
}
