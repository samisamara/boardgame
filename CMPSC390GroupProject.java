package cmpsc.pkg390.group.project;

import java.util.Random;
import java.util.Scanner;

public class CMPSC390GroupProject {

    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        Double money;
        System.out.println("Hello Welcome to Casino Night!");

        System.out.println("Here is a list of available games");
        //List of games
        String[] games = {"Blackjack", "Baccarat", "Cee-lo", "Craps"};
        for (int i = 0; i < games.length; i++) {
            System.out.println("-" + games[i]);
        }
        System.out.println("");

        //Player enters how much money they would like to start with 
       
        System.out.println("Enter amount of money you would like to start with: ");
        money = scnr.nextDouble();
        while (money <= 0) {
            System.out.println("Enter positive number");
            money = scnr.nextDouble();
        }

        System.out.println("Money: $" + money);

        boolean quit = false;
        while (quit == false || money<=0) {
            System.out.println("Please choose a game:");
            System.out.println(">1. [ Blackjack ]");
            System.out.println(">2. [ Baccarat ]");
            System.out.println(">3. [ Cee-lo ]");
            System.out.println(">4. [ Craps ]");
            System.out.println(">5. [ Help ]");
            System.out.println(">6. [ Quit Game ]");
            //Player selection
            Scanner reader = new Scanner(System.in);
            int chooseGame = reader.nextInt();

            //loop until a valid selection is entered
            while (chooseGame < 1 || chooseGame > 6) {
                System.out.println("Invalid selection, please re-enter.");
                chooseGame = reader.nextInt();
            }

            //Choose game or quit
            switch (chooseGame) {
                case 1:
                    //blackjack(money);
                    break;
                case 2:
                    baccarat(money); //Play baccarat using current Money
                    break;
                case 3:
                    Ceelo(money);
                    break;
                case 4:
                    //craps(money);
                    break;
                case 5:
                    help();
                    break;
                case 6:
                    quit = true; //Exit program
                    break;
            }

        }

    }

    public static void help() {
        System.out.println("Enter game you need help with:");
        boolean quit = false;
        while (quit == false) {
            System.out.println("Please choose a game you need help with:");
            System.out.println(">1. [ Blackjack ]");
            System.out.println(">2. [ Baccarat ]");
            System.out.println(">3. [ Cee-lo ]");
            System.out.println(">4. [ Craps ]");
            System.out.println(">5. [ Quit help ]");

            //Player selection
            Scanner reader = new Scanner(System.in);
            int chooseGame = reader.nextInt();

            //loop until a valid selection is entered
            while (chooseGame < 1 || chooseGame > 5) {
                System.out.println("Invalid selection, please re-enter.");
                chooseGame = reader.nextInt();
            }

            //Choose game or quit
            switch (chooseGame) {
                case 1:
                    System.out.println("Blackjack\n"
                            + "The goal of blackjack is to beat the dealer's hand without going over 21.\n"
                            + "Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.\n"
                            + "Each player starts with two cards, one of the dealer's cards is hidden until the end.\n"
                            + "To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n"
                            + "If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\n"
                            + "If you are dealt 21 from the start (Ace & 10), you got a blackjack.\n"
                            + "Blackjack usually means you win 1.5 the amount of your bet. Depends on the casino.\n"
                            + "Dealer will hit until his/her cards total 17 or higher.");
                    break;
                case 2:
                    System.out.println("Baccarat\n"
                            + "If either the player or banker is dealt a total of eight or nine, both the player and banker stand.\n"
                            + "If the player’s total is five or less, then the player will receive another card. Otherwise, the player will stand.\n"
                            + "If the player stands, then the banker hits on a total of 5 or less.\n"
                            + "The final betting option, a tie, pays out 8-to-1. Conveniently, there are also sheets at the table for you to keep track of your score.");
                    break;
                case 3:
                    System.out.println("Ceelo\n"
                            + "The player and dealer both rolls three dice.\n"
                            + "The goal is to roll a 'hand', which is typically composed of a pair and an outlier.\n"
                            + "There are also some special rolls with special effects like 1-2-3 or 4-5-6, or even a set.\n"
                            + "The player and dealer's rolls are compared and the winner is the one with the higher value hand.");
                    
                    break;
                case 4:
                    System.out.println("Simplified Craps\n"
                            + "There are dozens of variations of standard craps.\n" + ""
                            + "This variant, , is a wonderful game to start with for the beginner gambler.\n"
                            + "In this game a player simply wins if she throws 2, 3, 4, 10, 11 or 12\n"
                            + "and loses if they roll 5, 6, 7, 8 or 9.");
                    break;
                case 5:
                    quit = true; //Exit program
                    break;
            }

        }

    }

    
    public static double blackjack(double money){
        Scanner scnr = new Scanner(System.in);
        int bet=0;
        System.out.println("Welcome to Blackjack! Please select one of the following options");
        System.out.println(">1. [Play game]");
        System.out.println(">2. [View rules]");
        System.out.println(">3. [Go back]");
        int select = scnr.nextInt();
        do {
            if ((select > 3) || (select < 1)) {
                System.out.println("Error. Please select from the following options");
                System.out.println(">1. [Play game]");
                System.out.println(">2. [View rules]");
                System.out.println(">3. [Go back]");
                select = scnr.nextInt();
            }
            switch (select) {
                case 1:
                    System.out.println("Total Money: " + money);
                    System.out.println("Select your bet value:");
                    bet = scnr.nextInt();
                    while((bet > money) || (bet < 1)) {
                        System.out.println("Invalid bet value. Select a value larger than zero and less than or equal to your total money");
                        System.out.println("Total Money: " + money);
                        bet = scnr.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("///////////////////////////////////////////////////////////////////////");
                    System.out.println("Rules Of Blackjack:");
                    System.out.println("You and the dealer will be recieving cards one at a time until you decide to stop");
                    System.out.println("Every card is worth their face value (ex: a 9 card is worth 9)");
                    System.out.println("An ace can either be a 1 or an 11");
                    System.out.println("Kings, Queens, and Jacks are worth 10");
                    System.out.println("The goal of the game is to reach 21, or higher than the dealer's hand");
                    System.out.println("If your hand goes past 21, you bust");
                    System.out.println("If the dealer busts, you automatically win");
                    System.out.println("///////////////////////////////////////////////////////////////////////");
                    System.out.println("");
                    System.out.println("Please select from the following options");
                    System.out.println(">1. [Play game]");
                    System.out.println(">2. [View rules]");
                    System.out.println(">3. [Go back]");
                    select = scnr.nextInt();
                    break;
                case 3:
                    return money;
            }
        } while (!(select==1));
        
        //declares values
        int playerTotal = 0;
        int numCard = 0;
        int dealer = 0;
        Random rn = new Random();
        for (int i=0; i<2; i++) {
            dealer = getDealerCard(dealer);
        }
        //for loop to recieve two cards
        for (int i=0; i<2; i++){
            playerTotal = getCard(playerTotal, scnr);
            numCard++;
        }
        //value that checks which option the player chooses
        Character option;
        //this loop plays until player chooses no, reaches 21, or busts
        do {
        System.out.println("You have recieved " + numCard + " cards. Your current total is " + playerTotal + ".");
        System.out.println("The dealer's total is " + dealer + ". Would you like another card?");
        System.out.println("Select \"Y\" for yes, or \"N\" for no");
        option = scnr.next().charAt(0);
        option = Character.toUpperCase(option);
            while (option != 'Y' && option != 'N'){
                System.out.println("Invalid input");
                System.out.println("Select \"Y\" for yes, or \"N\" for no");
                option = scnr.next().charAt(0);
                option = Character.toUpperCase(option);
        }
        // if the dealer has a total less than 17, get new card
        if (option.equals('Y')) {
            if (dealer < 17) {
                dealer = getDealerCard(dealer);
            }
            playerTotal = getCard(playerTotal, scnr);
            numCard++;
        }
        //option of whether the player wants to keep going or not
        } while (playerTotal <= 20 && option.equals('Y') && dealer <= 21);
        System.out.println(playerTotal);
        money = check(playerTotal, money, bet, dealer);
        
        return money;
    }
    
    //this method gives you a card of a random value in blackjack
    public static int getCard(int playerTotal, Scanner scnr) {
        //randomly picks a number from 1-13 and then sends number to method to assign value
        Random rn = new Random();
        int card = rn.nextInt(13)+1;
        //sends card to additional method to fix card value due to rules of blackjack
        card = cardValue(card, scnr);
        playerTotal = playerTotal + card;
        return playerTotal;
    }
    
    //this method alters the card value in coordination with the rules of blackjack
    public static int cardValue(int card, Scanner scnr){
        //assigns a card value based on the number
        if (card >= 10) {
            switch (card) {
                case 11:
                    System.out.println("Card was a Joker. Card's value is 10");
                    break;
                case 12:
                    System.out.println("Card was a Queen. Card's value is 10");
                    break;
                case 13:
                    System.out.println("Card was a King. Card's value is 10");
                    break;
                default:
                    break;
            }
            card = 10;
        }
        else if (card == 1) {
            //option to make an ace a 1 or 11
            System.out.println("Your card was an ace. Would you like this card to be a 1 or an 11?");
            int num;
            card = scnr.nextInt();
            while ((card != 1) && (card != 11)) {
                System.out.println("Invalid number. Please select 1 or 11:");
                card = scnr.nextInt();
            }
        }
        System.out.println("Card value: " + card);
        return card;
    }
    
    public static int getDealerCard(int dealer) {
        //gives the dealer a card and adds to dealer's total
        Random rn = new Random();
        int card = rn.nextInt(13)+1;
        if (card > 10) {
            card = 10;
        }
        if (card == 1) {
            if ((dealer + card) > 21) {
                card = 1;
            }
            else {
                card = 11;
            }
        }
        return (dealer + card);
    }
    
    //checks if thr player won or bust
    public static double check(int player, double money, int bet, int dealer) {
        // this if statement only functions when the dealer busts
        if (dealer > 21) {
            System.out.println("Dealer busts...You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned your bet");
            money = money + bet;
            System.out.println("Total money after playing: $" + money);  
        }
        // this if statement only functions when the player beats the dealer normally
        if ((player <= 20) && (player > dealer)) {
            System.out.println("You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned your bet");
            money = money + bet;
            System.out.println("Total money after playing: $" + money);
        }
        // this if statement only functions when the player busts
        if (player > 21) {
            System.out.println("Player bust. You lose");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've lost your bet");
            money = money - bet;
            System.out.println("Total money after playing: $" + money);
        }
        // this if statement only functions when the player beats the dealer normally
        if ((player < 21) && (dealer > player) && (dealer < 21)) {
            System.out.println("Dealer's value was greater. You lose");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've lost your bet");
            money = money - bet;
            System.out.println("Total money after playing: $" + money);
        }
        // this if statement only functions when the player gets 21 exactly
        if (player == 21) {
            System.out.println("You win!");
            System.out.println("Total money before playing: $" + money);
            System.out.println("Your bet: " + bet);
            System.out.println("You've earned your bet");
            money = money + bet;
            System.out.println("Total money after playing: $" + money);
        }
        return money;
    }
    
    public static void baccarat(Double money) 
    {
        //Intro
        System.out.println("Welcome to Baccarat!");

        boolean playingBaccarat = true;
        while(playingBaccarat == true)
        {
            System.out.println("Current Money: $" + money);

            //Options: Play the game or go to Menu
            System.out.println("Please select an option: ");
            System.out.println("> 1. Place a bet");
            System.out.println("> 2. Go back to the Menu");

            //Player selection
            Scanner reader = new Scanner(System.in);
            int selection = reader.nextInt();
                //keep player in loop until a valid selection is made
                while((selection != 1) && (selection != 2))
                {
                    System.out.println("Please enter a valid selection.");
                    System.out.println("> 1. Place a bet");
                    System.out.println("> 2. Go back to the Menu");
                    selection = reader.nextInt();
                }

            //Quitting Baccarat
            if(selection == 2)
            {
                playingBaccarat = false ;
            }

            //Choose bet size and what to bet on
            while(selection == 1)
            {
                //Choose bet size
                System.out.println("Enter how much you would like to bet: ");
                int betSize = reader.nextInt();
                //Choose who to bet on
                System.out.println("What would you like to bet on?: ");
                System.out.println(">1. PLAYER");
                System.out.println(">2. BANKER");
                System.out.println(">3. TIE (8x Payout)");
                int betChoice = reader.nextInt();

                    //keep player in loop until a valid selection is made
                    while((betChoice < 1) || (betChoice > 3))
                    {
                        System.out.println("Please choose a valid bet choice.");
                        System.out.println(">1. PLAYER");
                        System.out.println(">2. BANKER");
                        System.out.println(">3. TIE (8x Payout)");
                        betChoice = reader.nextInt();
                    }

                    //set name of betChoice based on player input
                    String betChoiceName = "";
                    switch(betChoice)
                    {
                        case 1:
                            betChoiceName = "PLAYER" ;
                            break;
                        case 2:
                            betChoiceName = "BANKER" ;
                            break;
                        case 3:
                            betChoiceName = "TIE" ;
                            break;
                    }

                //Announce Player's decisions, then proceed to Dealing the cards
                System.out.println("You have bet $" + betSize + " on " + betChoiceName);

                //DEAL CARDS
                int playerTotal = 0;
                String playerHand = "";
                int bankerTotal = 0;
                String bankerHand = "";

                //PLAYER Cards
                for(int i = 0; i < 2; i++)
                {
                    //Draw a random card and get the baccarat value added to it
                    String cardDrawn = cardDraw();
                    playerHand += cardDrawn ; //add cardDrawn to playerHand
                    playerTotal += baccaratValues(cardDrawn); //add the value to player total

                    while(playerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                    {
                        playerTotal -= 10;
                    }
                }
                System.out.println("PLAYER: " + playerHand);

                //BANKER Cards
                for(int i = 0; i < 2; i++)
                {
                    //Draw a random card and get the baccarat value added to it
                    String cardDrawn = cardDraw();
                    bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                    bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                    while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                    {
                        bankerTotal -= 10;
                    }
                }
                System.out.println("BANKER: " + bankerHand);

                //COMPARE and do Payout
                System.out.println("[PLAYER: " + playerTotal + "] || [BANKER: " + bankerTotal + "]");

                if(playerTotal > bankerTotal)
                {
                    if(betChoice == 1)
                    {
                        System.out.println("You won! You gain $" + betSize);
                        money += betSize ;
                    }
                    else
                    {
                        System.out.println("You lost! You lost $" + betSize);
                        money -= betSize ;
                    }
                }
                if(playerTotal < bankerTotal)
                {
                    if(betChoice == 2)
                    {
                        System.out.println("You won! You gain $" + betSize);
                        money += betSize ;
                    }
                    else
                    {
                        System.out.println("You lost! You lost $" + betSize);
                        money -= betSize ;
                    }
                }
                if(playerTotal == bankerTotal)
                {
                    if(betChoice == 3)
                    {
                        System.out.println("You won! You gain $" + (8 * betSize));
                        money += (8 * betSize) ;
                    }
                    else
                    {
                        System.out.println("You lost! You lost $" + betSize);
                        money -= betSize ;
                    }
                }

            break;
            }

        }
    }

    public static String cardDraw()
    {
        //Set min to max (1-13 is Ace thru King)
        int min = 1;
        int max = 13;
        int cardNum = (int)(Math.random() * (max - min + 1) + min);

        //initialize the card variable
        String card = "";

        //Take that random value and apply the card type
        switch(cardNum)
        {
            case 1: 
                card = "A";
                break;
            case 2: 
                card = "2";
                break;
            case 3: 
                card = "3";
                break;
            case 4: 
                card = "4";
                break;
            case 5: 
                card = "5";
                break;
            case 6: 
                card = "6";
                break;
            case 7: 
                card = "7";
                break;
            case 8: 
                card = "8";
                break;
            case 9: 
                card = "9";
                break;
            case 10: 
                card = "10";
                break;
            case 11: 
                card = "J";
                break;
            case 12: 
                card = "Q";
                break;
            case 13: 
                card = "K";
                break;
        }

        return card;
    }

    public static int baccaratValues(String card)
    {
        int value = 0;
        switch(card)
        {
            case "A": 
                value = 1;
                break;
            case "2": 
                value = 2;
                break;
            case "3": 
                value = 3;
                break;
            case "4": 
                value = 4;
                break;
            case "5": 
                value = 5;
                break;
            case "6": 
                value = 6;
                break;
            case "7": 
                value = 7;
                break;
            case "8": 
                value = 8;
                break;
            case "9": 
                value = 9;
                break;
            case "10": 
                value = 0;
                break;
            case "J": 
                value = 0;
                break;
            case "Q": 
                value = 0;
                break;
            case "K": 
                value = 0;
                break;
        }

        return value;
    }
    
    public static Double Ceelo(Double money){
        Scanner scnr = new Scanner(System.in);
        Random rnd = new Random();
        int bet = 0;
        int option;
        Boolean canPlay = false;
        Boolean end = false;
        
        do{
            //home page 
            System.out.println("Welcome to Cee-lo! Please select one of the following options:");
            System.out.println("> 1. Play a game");
            System.out.println("> 2. View rules");
            System.out.println("> 3. Back to menu");
            option = scnr.nextInt();
            
            //option select
            if(option == 1){
                System.out.println("Total Money: $" + money);
                System.out.println("Place your bet");
                bet = scnr.nextInt();
                while(bet > money || bet < 1){
                    System.out.println("Invalid  Value. Select a value greater than one and less than or equal to your total money");
                    System.out.println("Total Money: $" + money);
                    bet = scnr.nextInt();
                }
                canPlay = true;
            }
            else if(option == 2){
                System.out.println();
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println("Cee-lo Rules");
                System.out.println("The player and the dealer will roll three dice");
                System.out.println("They will have up to three chances to the roll a hand");
                System.out.println("A hand is a pair and a single");
                System.out.println("The point value is the single. If there is no hand, then the point value is zero");
                System.out.println("The rolls will automatically done for you and displayed each time.");
                System.out.println("In order to win, the player's value must be higher than the dealer's value");
                System.out.println("The payout is one to one meaning that your bet will be matched");
                System.out.println("The minimum bet is $1");
                System.out.println("Good Luck! Have Fun!"); 
                System.out.println("---------------------------------------------------------------------------------------------------------");
                System.out.println();
            }
            else if(option == 3){
                return money;
            }
            else{
                System.out.println("Error: Invalid Input. Please select one of the following options:");
            }
        }while(canPlay == false);
        
        //Deaker dice and value
        int DealerDie1;
        int DealerDie2;
        int DealerDie3;
        int DealerValue = 0;
        
        //Dealer roll 
        for(int i = 0; i < 3; i++){
            System.out.println("Dealer's Roll");
            DealerDie1 = rnd.nextInt(6) + 1;
            DealerDie2 = rnd.nextInt(6) + 1;
            DealerDie3 = rnd.nextInt(6) + 1;
            System.out.println(DealerDie1 + " " + DealerDie2 + " " + DealerDie3);
            
            if(DealerDie1==DealerDie2){
                DealerValue = DealerDie3;
                break;
            }
            else if(DealerDie1==DealerDie3){
                DealerValue = DealerDie2;
                break;
            }
            else if(DealerDie2==DealerDie3){
                DealerValue = DealerDie1;
                break;
            }
            else{
                DealerValue = 0;
            }
        }
        
        //Player dice and value
        int PlayerDie1;
        int PlayerDie2;
        int PlayerDie3;
        int PlayerValue = 0;
        
        //Player roll 
        for(int i = 0; i < 3; i++){
            System.out.println("Player's Roll");
            PlayerDie1 = rnd.nextInt(6) + 1;
            PlayerDie2 = rnd.nextInt(6) + 1;
            PlayerDie3 = rnd.nextInt(6) + 1;
            System.out.println(PlayerDie1 + " " + PlayerDie2 + " " + PlayerDie3);
            
            //cheacks for 1-1-1 roll 5x payout
            if(PlayerDie1 == 1 && PlayerDie2 == 1 && PlayerDie3 == 1){
                System.out.println("You Win! 1-1-1 was rolled: 5x payout");
                money = money + (bet*4);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            //checks for triple roll 3x payout
            else if(PlayerDie1 == PlayerDie2 && PlayerDie2 == PlayerDie3){
                System.out.println("You Win! A triple was rolled: 3x payout");
                money = money + (bet*2);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            //checks for 4-5-6 roll 2x payout
            else if(PlayerDie1 == 4 && PlayerDie2 == 5 && PlayerDie3 == 6){
                System.out.println("You Win! 4-5-6 was rolled: 2x payout");
                money = money + bet;
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 4 && PlayerDie2 == 6 && PlayerDie3 == 5){
                System.out.println("You Win! 4-5-6 was rolled: 2x payout");
                money = money + bet;
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 5 && PlayerDie2 == 4 && PlayerDie3 == 6){
                System.out.println("You Win! 4-5-6 was rolled: 2x payout");
                money = money + bet;
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 5 && PlayerDie2 == 6 && PlayerDie3 == 4){
                System.out.println("You Win! 4-5-6 was rolled: 2x payout");
                money = money + bet;
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 6 && PlayerDie2 == 4 && PlayerDie3 == 5){
                System.out.println("You Win! 4-5-6 was rolled: 2x payout");
                money = money + bet;
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }else if(PlayerDie1 == 6 && PlayerDie2 == 5 && PlayerDie3 == 4){
                System.out.println("You Win! 4-5-6 was rolled: 2x payout");
                money = money + bet;
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            //checks for 1-2-3 roll -2x payout
            else if(PlayerDie1 == 1 && PlayerDie2 == 2 && PlayerDie3 == 3){
                System.out.println("You Lose! 1-2-3 was rolled: 2x loss");
                money = money - (bet*2);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 1 && PlayerDie2 == 3 && PlayerDie3 == 2){
                System.out.println("You Lose! 1-2-3 was rolled: 2x loss");
                money = money - (bet*2);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 2 && PlayerDie2 == 1 && PlayerDie3 == 3){
                System.out.println("You Lose! 1-2-3 was rolled: 2x loss");
                money = money - (bet*2);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 2 && PlayerDie2 == 3 && PlayerDie3 == 1){
                System.out.println("You Lose! 1-2-3 was rolled: 2x loss");
                money = money - (bet*2);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            else if(PlayerDie1 == 3 && PlayerDie2 == 1 && PlayerDie3 == 2){
                System.out.println("You Lose! 1-2-3 was rolled: 2x loss");
                money = money - (bet*2);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }else if(PlayerDie1 == 3 && PlayerDie2 == 2 && PlayerDie3 == 1){
                System.out.println("You Lose! 1-2-3 was rolled: 2x loss");
                money = money - (bet*2);
                System.out.println("Total Money: $" + money);
                end = true;
                break;
            }
            //checks for a player value
            else if(PlayerDie1==PlayerDie2){
                PlayerValue = PlayerDie3;
                break;
            }
            else if(PlayerDie1==PlayerDie3){
                PlayerValue = PlayerDie2;
                break;
            }
            else if(PlayerDie2==PlayerDie3){
                PlayerValue = PlayerDie1;
                break;
            }
            else{
                PlayerValue = 0;
            }
        }
        
        //results if no special roll was triggered
        while(end == false){
            if(DealerValue>PlayerValue){
                System.out.println("Dealer's point value: " + DealerValue);
                System.out.println("Player's point value: " + PlayerValue);
                money = money - bet;
                System.out.println("You Lose! Dealer's point value was greater");
                System.out.println("Total Money: $" + money);
                end = true;
            }
            else if(PlayerValue>DealerValue){
                System.out.println("Dealer's point value: " + DealerValue);
                System.out.println("Player's point value: " + PlayerValue);
                money = money + bet;
                System.out.println("You Win! Your point value was greater");
                System.out.println("Total Money: $" + money);
                end = true;
            }
            else{
                System.out.println("Dealer's point value: " + DealerValue);
                System.out.println("Player's point value: " + PlayerValue);
                money = money;
                System.out.println("Draw. Point values were equal");
                System.out.println("Total Money: $" + money);
                end = true;
            }
        }
        
        Ceelo(money);
        return money;
    }
}
