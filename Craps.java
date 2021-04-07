
package craps;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Craps {

 public static double craps(Double money) {
        //initialize variables
        boolean play = true;
        Double mon = money;
        Scanner scnr = new Scanner(System.in);

        //asks user to enter help to see rules or continue
        System.out.println("     Welcome to Craps!");
        System.out.println("To see rules enter -Help or -No to continue");
        String askHelp = scnr.next();
        if (askHelp.equalsIgnoreCase("help")) {
            help();
        } //enter bet before dice roll, if bet > player money, player must enter another bet
        else {
            while (play == true && mon > 0) {
                System.out.println("Player Money: $"+mon);
                //ask user what kind of bet would they like to make
                System.out.println("Enter R for regular betting or S for specific betting(10x payout)");
                String select = scnr.nextLine();
                while (!select.equalsIgnoreCase("r") && !select.equalsIgnoreCase("s")) {
                    System.out.println("Please enter R or S");
                    select = scnr.nextLine();
                }
                if (select.equalsIgnoreCase("r")) {
                    //regular bet
                    mon = regBet(mon);
                }
                if (select.equalsIgnoreCase("s")) {
                    mon = specBet(mon);
                }
                //checks if money is <=0 if so then player is kicked from game to main menu
                System.out.println("Player Money: $" + mon);
                if (mon <= 0) {
                    mon = 0.0;
                    break;
                }
                //ask to play again or exit
                System.out.println("Want to play again? Enter: Y/N");
                String ans = scnr.next();
                if (ans.equalsIgnoreCase("n")) {
                    play = false;
                }
                if (ans.equalsIgnoreCase("y")) {
                    play = true;
                }
            }

        }
        return mon;
    }

    public static int diceRoll() {
        //dice roll
        Random rnd = new Random();
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int total = die1 + die2;
        return total;

    }

    public static double regBet(Double mon) {
        //ask user to enter bet within range
        Scanner scnr = new Scanner(System.in);
        System.out.println("To begin enter your bet!");
        Double bet = scnr.nextDouble();
        while (bet > mon) {
            System.out.println("Bet can't be more than $" + mon + "  Enter again:");
            bet = scnr.nextDouble();
        }
        //dice roll
        int tot = diceRoll();
        //checks if win
        int[] win = {2, 3, 4, 10, 11, 12};
        int[] lose = {5, 6, 7, 8, 9};
        for (int i = 0; i < 6; i++) {
            if (tot == win[i]) {
                System.out.println("Dice Roll: " + tot);
                bet = bet * 2;
                System.out.println("YOU WIN: $" + bet);
                mon = mon + bet;
            }
        }
        //checks if lose 
        for (int k = 0; k < 5; k++) {
            if (tot == lose[k]) {
                System.out.println("Dice Roll: " + tot);
                System.out.println("YOU LOSE: $" + bet);
                mon = mon - bet;
            }
        }
        return mon;
    }

    public static double specBet(Double mon) {
        //ask user to enter bet within range
        Scanner scnr = new Scanner(System.in);
        System.out.println("To begin enter your bet!");
        Double bet = scnr.nextDouble();
        while (bet > mon) {
            System.out.println("Bet can't be more than $" + mon + "  Enter again:");
            bet = scnr.nextDouble();
        }
        System.out.println("Enter specific number 1-12 you wish to bet on: ");
        int num = scnr.nextInt();
        while (num < 1 || num > 12) {
            System.out.println("Enter specific number 1-12 you wish to bet on: ");
            num = scnr.nextInt();
        }
        //dice roll
        int tot = diceRoll();
        //checks if win

        if (tot == num) {
            System.out.println("Dice Roll: " + tot);
            bet = bet * 10;
            System.out.println("YOU WIN: $" + bet);
            mon = mon + bet;
        } //checks if lose 
        else {
            System.out.println("Dice Roll: " + tot);
            bet = bet * 10;
            System.out.println("YOU LOSE: $" + bet);
            if(bet>=mon){
                mon = 0.0;
            }
            else{
            mon = mon - bet;
            }
        }

        return mon;
    }
}
