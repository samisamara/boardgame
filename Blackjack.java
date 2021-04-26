package casino;

import java.util.Random;
import java.util.Scanner;

public class Casino 
{
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
                    money = blackjack(money);
                    break;
                case 2:
                    money = baccarat(money);
                    break;
                case 3:
                    money = Ceelo(money);
                    break;
                case 4:
                    money = craps(money);
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
                    System.out.println("The goal of blackjack is to beat the dealer's hand without going over 21.\n"
                            + "Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.\n"
                            + "Each player starts with two cards, one of the dealer's cards is hidden until the end.\n"
                            + "To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.\n"
                            + "If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.\n"
                            + "If you are dealt 21 from the start (Ace & 10), you got a blackjack.\n"
                            + "Blackjack usually means you win 1.5 the amount of your bet. Depends on the casino.\n"
                            + "Dealer will hit until his/her cards total 17 or higher.");
                    break;
                case 2:
                    System.out.println("If either the player or banker is dealt a total of eight or nine, both the player and banker stand.\n"
                            + "If the player’s total is five or less, then the player will receive another card. Otherwise, the player will stand.\n"
                            + "If the player stands, then the banker hits on a total of 5 or less.\n"
                            + "The final betting option, a tie, pays out 8-to-1. Conveniently, there are also sheets at the table for you to keep track of your score.");
                    break;
                case 3:
                    System.out.println("The player and dealer both rolls three dice.\n"
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
    
    public static Double baccarat(Double money) 
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
            System.out.println("> 2. Baccarat Description");
            System.out.println("> 3. Go back to the Menu");

            //Player selection
            Scanner reader = new Scanner(System.in);
            int selection = reader.nextInt();
                //keep player in loop until a valid selection is made
                while((selection != 1) && (selection != 2) && (selection != 3))
                {
                    System.out.println("Please enter a valid selection.");
                    System.out.println("> 1. Place a bet");
                    System.out.println("> 2. Baccarat Description");
                    System.out.println("> 3. Go back to the Menu");
                    selection = reader.nextInt();
                }
            
            //Quitting Baccarat
            if(selection == 3)
            {
                playingBaccarat = false ;
            }
            
            //Baccarat Description
            if(selection == 2)
            {
                System.out.println("Baccarat is a game about betting on cards that will be dealt.\n"
                            + "The dealer will deal cards to two different sides: the 'Player' and the 'Banker'.\n"
                            + "The side with the highest value wins. If the value reaches ten, the values loops back down to zero. Card draws are interdependent based on what each side draws.\n"
                            + "Both sides draw two cards by default.\n"
                            + "The Player side will draw a third card if their total is less than 6. The Banker will draw a third card if their total is less than 7 and depending on what the Player side drew.\n"
                            + "You may select your bet size and what you bet will win: Player, Banker, or Tie.\n");
                
                    System.out.println("> 1. Place a bet");
                    System.out.println("> 2. Baccarat Description");
                    System.out.println("> 3. Go back");
                    selection = reader.nextInt();
            }

            //Choose bet size and what to bet on
            while(selection == 1)
            {
                //Choose bet size
                System.out.println("Enter how much you would like to bet: ");
                int betSize = reader.nextInt();
                
                //check if you have the funds
                if(betSize > money)
                {
                    System.out.println("You do not have enough money for that bet.");
                    break;
                }
                
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
                int lastPlayerCardValue = -1 ; //necessary to keep track of this because the Banker side changes based on it. (negative 1 for now, in case the player does not need a 3rd card)
                for(int i = 0; i < 2; i++)//Initial two cards drawn
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
                if(playerTotal < 6) //Player side will draw an extra card if below 6
                {
                    //Draw a random card and get the baccarat value added to it
                    String cardDrawn = cardDraw();
                    playerHand += cardDrawn ; //add cardDrawn to playerHand
                    playerTotal += baccaratValues(cardDrawn); //add the value to player total
                    lastPlayerCardValue = baccaratValues(cardDrawn); //set the last card

                    while(playerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                    {
                        playerTotal -= 10;
                    }
                }
                System.out.println("PLAYER: " + playerHand);//output Player value at the end

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
                
                while(lastPlayerCardValue != -1) //Banker only gets another card if the Player side took one
                {
                    //Banker's own total effects whether or not you draw as well
                    if(bankerTotal == 0)
                    {
                        //Draw a random card and get the baccarat value added to it
                        String cardDrawn = cardDraw();
                        bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                        bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                        while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                        {
                            bankerTotal -= 10;
                        }
                        
                        break;
                    }
                    else if(bankerTotal == 1)
                    {
                        //Draw a random card and get the baccarat value added to it
                        String cardDrawn = cardDraw();
                        bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                        bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                        while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                        {
                            bankerTotal -= 10;
                        }
                        
                        break;
                    }
                    else if(bankerTotal == 2)
                    {
                        //Draw a random card and get the baccarat value added to it
                        String cardDrawn = cardDraw();
                        bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                        bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                        while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                        {
                            bankerTotal -= 10;
                        }
                        
                        break;
                    }
                    else if(bankerTotal == 3 && lastPlayerCardValue != 8)//only draw if Banker is 3 and lastPlayerCard drawn is not 8
                    {
                        //Draw a random card and get the baccarat value added to it
                        String cardDrawn = cardDraw();
                        bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                        bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                        while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                        {
                            bankerTotal -= 10;
                        }
                        
                        break;
                    }
                    else if(bankerTotal == 4 && (lastPlayerCardValue >= 2 && lastPlayerCardValue <= 7))
                    {
                        //Draw a random card and get the baccarat value added to it
                        String cardDrawn = cardDraw();
                        bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                        bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                        while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                        {
                            bankerTotal -= 10;
                        }
                        
                        break;
                    }
                    else if(bankerTotal == 5 && (lastPlayerCardValue >= 4 && lastPlayerCardValue <= 7))
                    {
                        //Draw a random card and get the baccarat value added to it
                        String cardDrawn = cardDraw();
                        bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                        bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                        while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                        {
                            bankerTotal -= 10;
                        }
                        
                        break;
                    }
                    else if(bankerTotal == 6 && (lastPlayerCardValue >= 6 && lastPlayerCardValue <= 7))
                    {
                        //Draw a random card and get the baccarat value added to it
                        String cardDrawn = cardDraw();
                        bankerHand += cardDrawn ; //add cardDrawn to bankerHand
                        bankerTotal += baccaratValues(cardDrawn); //add the value to banker total

                        while(bankerTotal >= 10)//in baccarat, when you hit 10 you loop back down to 0
                        {
                            bankerTotal -= 10;
                        }
                        
                        break;
                    }
                    else //don't draw if Banker total is 7 or more, or if no other values cause a draw
                    {
                        break;
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
        
        return money ;
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
        
        //blackjack(money);
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
    
    public static Double Ceelo(Double money){
        Scanner scnr = new Scanner(System.in);
        Random rnd = new Random();
        int bet = 0;
        int option;
        Boolean canPlay = false;
        
        do{
            //home page 
            System.out.println("Welcome to Cee-lo! Please select one of the following options:");
            System.out.println("> 1. Play a game");
            System.out.println("> 2. View rules");
            System.out.println("> 3. Back to menu");
            option = scnr.nextInt();
            
            //option select
            if(option == 1){
                System.out.println("Total Money: " + money);
                System.out.println("Place your bet");
                bet = scnr.nextInt();
                while(bet > money || bet < 1){
                    System.out.println("Invalid  Value. Select a value greater than one and less than or equal to your total money");
                    System.out.println("Total Money: " + money);
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
                System.out.println("The rolls will automatically done for you ans displayed each time.");
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
        System.out.println("Player's Roll");
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
            
            if(PlayerDie1==PlayerDie2){
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
        
        //results
        if(DealerValue == 0){
            System.out.println("Dealer busts!");
        }
        else{
            System.out.println("Dealer value: " + DealerValue);
        }
        if(PlayerValue == 0){
            System.out.println("Player busts!");
        }
        else{
            System.out.println("Player value: " + PlayerValue);
        }
    
        
        if(DealerValue>PlayerValue){
            System.out.println("Dealer Wins! You lose $" + bet);
            money = money - bet;
        }
        else if(PlayerValue>DealerValue){
            System.out.println("Player Wins! You gain $" + bet);
            money = money + bet;
        }
        else{
            System.out.println("It's a tie!");
            money = money;
        }
        
        
        Ceelo(money);
        return money;
    }
    

}
