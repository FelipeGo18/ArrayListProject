/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author gonza
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        int c;
        
        System.out.print("Ingrese un numero");
        a = sc.nextInt();
        
        System.out.print("Ingrese un numero");
        b = sc.nextInt();
        
        c = a + b;
        
        System.out.println(c);
        
    }
    
}
