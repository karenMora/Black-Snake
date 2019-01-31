/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]){
        Thread h1 =new CountThread(0, 100);
        Thread h2 =new CountThread(99, 200);
        Thread h3 =new CountThread(200,300);
        
        h1.run();
        h2.run();
        h3.run();
        
    }
    
}
