import hsa.Stdin;
import java.util.Random;
public class RockPaperScissors
{
    public static void main (String[] args)
    {
        System.out.println ("A Game of Rock, Paper, Scissors to 5 points");
        System.out.println();
    
        //Player Name not needed overall
        String player, cpu;
        System.out.println ("enter your name: ");
        player = Stdin.readString ();

        int playerScore = 0;
        int cpuScore = 0;



       

        //determines winner
        while ((playerScore != 5) && (cpuScore != 5))
        {
            //sets computer answer
            Random randomNum = new Random ();
            int cpuChoice = randomNum.nextInt (3) + 1;
            //System.out.print (cpuChoice);
            
            System.out.println (player + " choose 1 for rock, 2 for paper, or 3 for scissors: ");
            int playerChoice = Stdin.readInt ();
            while ((playerChoice != 1) && (playerChoice != 2) && (playerChoice != 3))
            {

                System.out.println (" invalid choice you muct pick between 1 2 or 3");
                System.out.println (player + " choose 1 for rock, 2 for paper, or 3 for scissors: ");
                playerChoice = Stdin.readInt ();

            }

            if (playerChoice == cpuChoice)
            {
                System.out.println ("its a tie no points awarded");
                System.out.println ();
            }

            if ((playerChoice == 1) && (cpuChoice == 2))
            {
                System.out.println (player + " chose rock, CPU chose paper\n CPU's point");
                cpuScore++;
                System.out.println ();
            }
            else if ((playerChoice == 2) && (cpuChoice == 1))
            {
                System.out.println (player + " chose paper, CPU chose rock\n" + player + " gets the point");
                playerScore++;
                System.out.println ();
            }
            else if ((playerChoice == 1) && (cpuChoice == 3))
            {
                System.out.println (player + " chose rock, CPU chose scissors\n" + player + " gets the point");
                playerScore++;
                System.out.println ();
            }
            else if ((playerChoice == 3) && (cpuChoice == 1))
            {
                System.out.println (player + " chose scissors, CPU chose rock\nCPU gets the point");
                System.out.println ();
                cpuScore++;
                //break;
            }
            else if ((playerChoice == 3) && (cpuChoice == 2))
            {
                System.out.println (player + " chose scissors, CPU chose paper\n" + player + " gets the point");
                playerScore++;
                System.out.println ();
            }
            else if ((playerChoice == 2) && (cpuChoice == 3))
            {
                System.out.println (player + " chose paper, CPU chose scissors\nCPU gets the point");
                cpuScore++;
                System.out.println ();
            }
            if (playerScore == 4)
            {
                System.out.println (player + " only needs one point to win");
            }
            if (cpuScore == 4)
            {
            System.out.println ("CPU only needs one point to win");
            }
             
        }
            if (playerScore == 5)
            {
            System.out.println ("Game over " + player +" has won");
            System.out.println ("FINAL SCORE");
            System.out.println (player +" had " + playerScore + " points");
            System.out.println ("CPU had " + cpuScore + " points");
            
            }
            if (cpuScore == 5)
            {
            System.out.println ("Game over CPU has won");
            System.out.println ("FINAL SCORE");
            System.out.println ("CPU had " + cpuScore + " points");
            System.out.println (player +" had " + playerScore + " points");
            
            
            }
            

    } // main method
}
// RockPaperScissors class
