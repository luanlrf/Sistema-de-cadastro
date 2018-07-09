/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj_collections;

import java.util.Collection;
import java.util.*;


/**
 *
 * @author Luan
 */
public class Prj_Collections {
    
    public static void main (String[] args){
       Collection <Integer> col= new LinkedList<Integer>();
         // List <T> col= new List<T>();
        col.add(1); // adicionar
        col.add(2);
        
        System.out.println("remover "+col.remove(1));
        System.out.println("buscar: "+col.contains(5));
        
        // impressão
        for(int x: col){
            System.out.println(x);
        }
        
    }
    
}
