import java.util.Scanner;
import java.util.Random;

public class Rock
{
	public static void main(String[] args)
	{
 Scanner scan= new Scanner (system.in);
 String personPlay;	//User's play -- "R", "P", or "S"
 String computerPlay;  //Computer's play -- "R", "P", or "S"
 int computerInt;	  //Randomly generated number used to determine
					   //computer's play

System.out.print ("Enter your play: r, p, or s");
   personPlay = scan.nextLine();
   personPlay = personPlay.toUpperCase();
 
Random generator = new Random();
computerPlay = generator.nextInt (3) +1;
System.out.println ("From 1 to 3: " + computerPlay);

int computerPlay = computerInt;
int 1=R,2=P,3=S;
System.outprintln ("computerPlay:" + computerPlay);

if (personPlay.equals(computerPlay));
   System.out.println ("It's a tie!);
else if (personPlay.equals("R"))
	 if (computerPlay.equals("S"))
	 System.out.println ("Rock crushes scissors. You win!");
		else if (computerPlay.equals("P"));
		System.out.println ("Paper beats rock. Computer wins!);
else if (personPlay.equals("P")
	 if (computerPlay.equals("R")
	 System.out.println ("Paper beats rock. You win!");
		else if (computerPlay.equals("S");
		System.out.println ("Scissors cut paper. Computer wins!");
else if (personPlay.equals("S")
	 if (computerPlay.equals("R")
	 System.out.println ("Rock crushes scissors. Computer wins!");
		 else if (computerPlay.equals("P");
		 System.out.println ("Scissors cut paper. You win!");



	}
}
