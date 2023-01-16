import java.util.Scanner;

public class main
{
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
//Segment 1.1: introduction to the program

        System.out.println("Stones");
        System.out.println("--------");
        System.out.println();
        System.out.println("Welcome! This game focuses on strategy" + "\n" + "and trying to knock out your opponent." + "\n");
        System.out.println("You'll be given the option to:");
        System.out.println("Gather a Stone");
        System.out.println("Throw a Stone");
        System.out.println("Block");
        System.out.println();
        System.out.println("You may hold up to 3 stones at a time.");
        System.out.println("If a player throws and the other isn't blocking/throwing,");
        System.out.println("you win!");
        System.out.println();
        System.out.println("Continue the game until either a player is KO'd" + "\n" + "or 10 turns have been reached.");
        System.out.println();
        
        System.out.print("What is player 1's name: ");
            String playerA = input.nextLine();
        
        System.out.print("What is player 2's name: ");
            String playerB = input.nextLine();
        
        System.out.println("\n" + "Let's rumble!" + "\n");
        
        //shortens the player's name temporarily to 1 character
        //to help the user identify which stickman is which
        System.out.println("       " + playerA.substring(0,1) + "              " + playerB.substring(0,1) + "");
        System.out.println("       O              O");
        System.out.println("      /|\\            /|\\");
        System.out.println("      / \\            / \\");
        

        

        
//Segment 1.2: determining player choice input for player A

        Stones game = new Stones(playerA, playerB); // creates the game object to use methods in Stones.java
        int confirmWin = 0; //later confirms if a player has won by the time 16 turns have passed
        
        for(int i = 1; i < 11; i++) // general loop (i is number of turns)
        {
            String choiceA;
            String choiceB;
            System.out.println();
            System.out.println("Turn " + i); //prints the number of turns
            System.out.println("--------");

            while(true) //loop to confirm player A choice
            {
                System.out.println("What does " +playerA+ " do? (gather, throw, block)");
                choiceA = input.nextLine();

                if(choiceA.equals("gather")) //if player A entered gather
                {
                    if(!game.checkStonesMax(playerA)) //tells user to enter again if stone count will exceed 3
                    {
                        System.out.println();
                        System.out.println("You can't have more than 3 stones!");
                        System.out.println();
                    }
                    else
                    {
                        game.gatherA(); //if stone won't exceed 3, continue to player B
                        break;
                        
                    }
                }
                if(choiceA.equals("block"))//if player entered block
                {
                    break;
                }
                if(choiceA.equals("throw"))//if player entered throw
                {
                    if(!game.checkStonesMin(playerA))//checks if player has a stone
                    {
                        System.out.println();
                        System.out.println("You don't have a stone!");
                        System.out.println();
                    }
                    else //if player has a stone, continues to player B
                    {
                        game.throwA();
                        break;
                    }
                }
                //if player entered something that's not 1 of the 3 options, asks player to enter again
                else if(!choiceA.equals("gather") && !choiceA.equals("block") && !choiceA.equals("throw")) 
                {
                    System.out.println();
                    System.out.println("You entered an invalid option!");
                    System.out.println();

                }
                
            }

//Segment 1.3: Determining player choice input for player B

            while(true) //loop to confirm player B choice (same code as with player A)
            {
                System.out.println("What does " +playerB+ " do? (gather, throw, block)");
                choiceB = input.nextLine();

                if(choiceB.equals("gather"))
                {
                    if(!game.checkStonesMax(playerB))
                    {
                        System.out.println();
                        System.out.println("You can't have more than 3 stones!");
                        System.out.println();
                    }
                    else
                    {
                        game.gatherB();
                        break;
                       
                    }
                }
                if(choiceB.equals("block"))
                {
                    break;
                }
                if(choiceB.equals("throw"))
                {
                    if(!game.checkStonesMin(playerB))
                    {
                        System.out.println();
                        System.out.println("You don't have a stone!");
                        System.out.println();
                    }
                    else
                    {
                        game.throwB();
                        break;
                    }
                }
                else if(!choiceB.equals("gather") && !choiceB.equals("block") && !choiceB.equals("throw"))
                {
                    System.out.println();
                    System.out.println("You entered an invalid option!");
                    System.out.println();

                }
            }
            
            //spacing and divider to make appearance slightly less squished
            System.out.println("------------------------------------------");
            System.out.println();
            
//Segment 1.4: Determining print image
            
            if(choiceA.equals("gather")) //printing result if player A chose gather
            {
                if(choiceB.equals("gather")) //both players gather
                {
                game.bothGather();
                game.stoneNum();
                System.out.println("<Both players gather a stone>");
                }
                
                if(choiceB.equals("block")) //player A gathers, player B blocks
                {
                game.gatherBlock();
                game.stoneNum();
                System.out.println("<" + playerA + " gathers a stone while " + playerB + " blocks>");
                }
                
                if(choiceB.equals("throw")) //player A gathers, player B throws (win)
                {
                    game.printWin(playerB);
                    confirmWin = -1;
                    System.out.println("<" + playerB + " wins!!!>");
                    break;
                }
            }
            
            if(choiceA.equals("block")) //printing result if player A chose block
            {
                if(choiceB.equals("block")) //both players block
                {
                    game.bothBlock();
                    game.stoneNum();
                    System.out.println("<Both players block>");
                }
                
                if(choiceB.equals("gather")) //player A blocks, player B gathers
                {
                    game.blockGather();
                    game.stoneNum();
                    System.out.println("<" + playerB + " gathers a stone while " + playerA + " blocks>");
                }
                
                if(choiceB.equals("throw")) //player A blocks, player B throws
                {
                    game.blockThrow();
                    game.stoneNum();
                    System.out.println("<" + playerB + " throws a stone but " + playerA + " blocks it!>");
                }
            }
            
            if(choiceA.equals("throw")) //printing result if player A chose throw
            {
                if(choiceB.equals("throw")) //both players throw
                {
                    game.bothThrow();
                    game.stoneNum();
                    System.out.println("<The thrown stones deflect each other!>");
                }
                
                if(choiceB.equals("gather")) //player A throws, player B gathers (win)
                {
                    game.printWin(playerA);
                    confirmWin = -1;
                    System.out.println("<" + playerA + " wins!!!>");
                    break;
                }
                
                if(choiceB.equals("block")) //player A throws, player B blocks
                {
                    game.throwBlock();
                    game.stoneNum();
                    System.out.println("<" + playerA + " throws a stone but " + playerB + " blocks it!>");
                }
            }
            
            System.out.println("------------------------------------------");
        }
        
        //check if either player has won (throwing while other is gathering)
        //if a player has won, confirm == -1
        //if a player hasn't won after 15 turns, confirm is still == 0 and prints this message
        if(confirmWin == 0) 
        {
            System.out.println();
            System.out.println("<" + playerA +" and " + playerB + " have tied!>");
        }
        
    }
}
