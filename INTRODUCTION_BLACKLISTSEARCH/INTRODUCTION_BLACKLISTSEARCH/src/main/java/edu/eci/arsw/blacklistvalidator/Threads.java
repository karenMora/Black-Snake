/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

/**
 *
 * @author 2092692
 */
public class Threads extends Thread{
    
    public Threads(){
    }
    
    /**
     * preguntar a las instancias (los hilos) cuántas
     * ocurrencias de servidores maliciosos ha encontrado
     * 
     * @return el numero de servidores maliciosos
     */
    public int getInstanciasMalas(){
        return 0;
    }
    
    /**
     * busca un segmento del grupo de servidores disponibles.
     */
    public void run(){
        HostBlackListsValidator hblv=new HostBlackListsValidator();
        List<Integer> blackListOcurrences=hblv.checkHost("200.24.34.55");
        System.out.println("\n");
        System.out.println("Los Servidores disponibles son: "+blackListOcurrences);
    }
}
