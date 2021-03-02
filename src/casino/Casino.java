/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Casino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scnr = new Scanner(System.in);
        Double money;
        System.out.println("Hello Welcome to Casino Night!");
        System.out.println("Here is a list of available games");
        //List of games
        String[] games = {"Blackjack", "Bakarat", "Cee Lo"};
        for (int i = 0; i < games.length; i++) {
            System.out.println("-" + games[i]);
        }
        System.out.println("");
        //Player enters how much money they would like to start with 
        //made money a double just so we can ask for whole number if they do not provide one.
        System.out.println("Enter amount of money you would like to start with: ");
        money = scnr.nextDouble();
        while (money % 1 != 0) {
            System.out.println("Enter whole number");
            money = scnr.nextDouble();
        }
        System.out.print("Money: $" + money);

    }

}
