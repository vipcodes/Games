/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author VIPIN KUMAR
 */
public class GuessTheNumber {
    int hardLevel=5;
    int easyLevel=10;
    
    Scanner scanner=new Scanner(System.in);
    Random random=new Random();
    
    int setDifficulty()
    {
        System.out.println("Choose the difficulty level.. Type 'hard' or 'easy' : ");
        String level=scanner.next().toLowerCase();
        if(level.equalsIgnoreCase("hard"))
            return hardLevel;
        if(level.equalsIgnoreCase("easy"))
            return easyLevel;
        return 0;
    }
    
    int checkAnswer(int guess, int answer, int turns)
    {
        if(guess>answer)
        {
            System.out.println("Too High");
            return turns-1;
        }
        else if(guess<answer)
        {
            System.out.println("Too Low");
            return turns-1;
        }
        else
            System.out.println("You got it. The answer is : "+answer+"\nYou Wins.");
            return turns;
       
    }

    
    void playGame()
    {
        
        int answer=random.nextInt(100);
        int guess=0;
        int turns=new GuessTheNumber().setDifficulty();
        System.out.println("I'm thinking a number between 1 and 100.\nGuess the number I'm thinking of:");
        while(guess!=answer&&turns!=0)
        {
           
            guess=scanner.nextInt();
            turns=new GuessTheNumber().checkAnswer(guess,answer,turns);
            System.out.println();
            if(turns==0)
            {
                System.out.println("You ran out of chances. You Lose");
                
            }   
            else if(guess!=answer)
                System.out.println("You have " +turns+" chances left. Try again:");
        }
        
        System.out.println("Do you want to play again.. Type 'yes' or 'no'.");
        String playAgain=scanner.next();
        if(playAgain.equalsIgnoreCase("yes"))
        {
            playGame();
        }
        return;
    }
    
    public static void main(String[] args)
    {
        new GuessTheNumber().playGame();
        
    }
}
