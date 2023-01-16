public class Stones {
    
    //New class to help separate codes to make main program less cluttered
    //Also calculates and keeps track of the # of stones for each player
    
    
    
//Segment 2.1: Game Constructor

    private String playerA;
    private String playerB;
    
    //initializing the stone counts for both players
    int stoneA =0;
    int stoneB =0; 
    
    public Stones(String pA, String pB) //game constructor to use methods
    {
        playerA = pA;
        playerB = pB;
    }
    
    
    
//Segment 2.2: changing stone values

    public int gatherA() //gathers 1 stone for player A
    {
        return stoneA++;
    }
    public int gatherB()//gathers 1 stone for player B
    {
        return stoneB++;
    }
    
    public int throwA() //uses 1 stone to throw for player A
    {
        return stoneA--;
    }
    public int throwB()//uses 1 stone to throw for player B
    {
        return stoneB--;
    }
    
    //block method is not needed as it does not directly affect stone count



//Segment 2.3: Methods checking and maintaining stone values

    //checks if stone count is greater than 0 
    public boolean checkStonesMin(String player)
    {
        if(player.equals(playerA))
        {
            if(stoneA > 0)
            {
                return true;
            }
        }
        if(player.equals(playerB))
        {
            if(stoneB > 0)
            {
                return true;
            }
        }
        return false;
    }
    
    //checks if the stone count is no more than 3
        public boolean checkStonesMax(String player)
    {
        if(player.equals(playerA))
        {
            if(stoneA < 3)
            {
                return true;
            }
        }
        if(player.equals(playerB))
        {
            if(stoneB < 3)
            {
                return true;
            }
        }
        return false;
    }
    
//Segment 2.4: prints out the stones as an image
//             based on the current stone counts
    
    public void stoneNum() //prints out a line of stones (up to 3)
    {
         if(stoneA == 0 && stoneB == 0) //if both players have 0 stones
         {
             System.out.println();
         }
         else if(stoneA == 0) //if only player A has 0 stones
         {
             if(stoneB > 0) //if statement for stoneB is used to prevent error with prior if statement
             {
                 System.out.print("                                 ");
                 for(int x = 0; x < stoneB; x++) //loops based on number of B stones
                 {
                     System.out.print("o");
                 }
             }
             System.out.println();
         }
         else if(stoneA == 1) //if player A has 1 stone
         {
             System.out.print("      o                          ");
             for(int x = 0; x< stoneB; x++) //loops based on # of B stones
             {
                 System.out.print("o");
             }
             System.out.println();
         }
         else if(stoneA == 2) //if player A has 2 stones
         {
             System.out.print("      oo                         ");
             for(int x = 0; x< stoneB; x++) //loops based on # of B stones
             {
                 System.out.print("o");
             }
             System.out.println();
         }
         else if(stoneA == 3) //if player A has 3 stones
         {
             System.out.print("      ooo                        ");
             for(int x = 0; x< stoneB; x++) //loops based on # of B stones
             {
                 System.out.print("o");
             }
             System.out.println();
         }
         System.out.println();

    }
    

//Segment 2.5: Methods to easily print out images of scenarios
            
        //playerA gathers, playerB gathers
                public void bothGather()
                {
                    System.out.println("             O              O");
                    System.out.println("            /|\\            /|\\      ");
                    System.out.println("            / \\            / \\     ");
                }
            
        //playerA throw, playerB throw
                public void bothThrow()
                {
                    System.out.println("             O              O");
                    System.out.println("            /|—  ---oo---  —|\\");
                    System.out.println("            / \\            / \\");
                }
            
        //playerA block, playerB block
                public void bothBlock()
                {
                    System.out.println("             O  |        |  O");
                    System.out.println("            /|\\ |        | /|\\");
                    System.out.println("            / \\ |        | / \\");
                }
                
        //playerA gathers, player B block
                public void gatherBlock()
                {
                    System.out.println("             O           |  O");
                    System.out.println("            /|\\          | /|\\");
                    System.out.println("            / \\          | / \\");
                }        
                
        //player A blocks, player B gathers
                public void blockGather()
                {
                    System.out.println("             O  |           O");
                    System.out.println("            /|\\ |          /|\\");
                    System.out.println("            / \\ |          / \\");
                }        
      
        //player A throws, player B blocks
                public void throwBlock()
                {
                    System.out.println("             O           |  O");
                    System.out.println("            /|— ---o     | /|\\");
                    System.out.println("            / \\          | / \\");
                }

        //player A blocks, player B throws
                public void blockThrow()
                {
                    System.out.println("             O  |           O");
                    System.out.println("            /|\\ |     o--- —|\\");
                    System.out.println("            / \\ |          / \\");
                }
                
                public void printWin(String thePlayer)
                {
                    
        //playerA wins(A throws, B gathers)
                    if(thePlayer.equals(playerA)) 
                    {
                        System.out.println("            \\O/");
                        System.out.println("             | ");
                        System.out.println("            / \\");
                        System.out.println();
                    }
                    
        // playerB wins (B throws, A gathers)
                    if(thePlayer.equals(playerB))
                    {
                        System.out.println("                           \\O/");
                        System.out.println("                            |");
                        System.out.println("                           / \\");
                        System.out.println();
                    }
                }
                
}
