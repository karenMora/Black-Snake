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
    
    public static void main(String a[]) throws InterruptedException{
        CountThread h1,h2,h3;
        h1 =new CountThread(0, 100);
        h2 =new CountThread(99, 200);
        h3 =new CountThread(200,300);
        
        h1.start();
        h2.start();
        h3.start();
        
    }
    
}
