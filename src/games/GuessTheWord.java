/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

/**
 *
 * @author VIPIN KUMAR
 */

class PlayGame
{
     void guessTheWord()
    {
       Scanner scanner=new Scanner(System.in);
       String word;
       ArrayList display=new ArrayList();
       boolean endOfGame=false;
       int lives=5;
        
        word=new GuessTheWord().choseRandomWord();
        String arr[]=new String[word.length()];
        
        for(int i=0;i<word.length();i++)
        {
            display.add("_");
            
        }
        System.out.println("Hint: The word could be a fruit name or animal name or vegitable name.\nWord have "+word.length()+ "letters");
        System.out.println(display);
        while(!endOfGame)
        {
            int i=0;
            
            System.out.println("Enter the letters of the word : ");
            char guess=scanner.next().charAt(i);
            char letter='\u0000';
            if(display.contains(guess))
               {
                  System.out.println("You have already guessed this letter try another...");
               }
            
            for(int position=0;position<word.length();position++)
            {
               letter=word.charAt(position);
               if(letter==guess)
                    display.set(position, letter);
              
            }
             
            Iterator itr=display.iterator();//Returns an iterator
            while(itr.hasNext())
            {
                System.out.print(itr.next());
            }
            System.out.println();
            /*for(Object x:display)
                {
                System.out.print(x);

                }
                System.out.println();*/
                
            
            if(!display.contains(guess))
               {
                    lives-=1;
                   System.out.println("You guessed the wrong letter.\nYou have only "+lives+ " chances remaining..");
                   
               }
            
            if(lives==0)
            {
                System.out.println("You ran out of lives. You Lose...");
                endOfGame=true;
            
            }
            
            if(!display.contains("_"))
                  {
                      System.out.println("You guess the write word. You wins...");
                      endOfGame=true;
                  }
            
                
                if(i<word.length())
                i++;
        }
        
        System.out.println("\nDo you want to play again.. Type 'yes' or 'no' ");
        String playAgain=scanner.next();
        while(playAgain.equalsIgnoreCase("yes"))
        {
            guessTheWord();
        }
      
    }
    
    
}


public class GuessTheWord {
    String[] words={"apple","banana","peach","guavava","pineapple","dog","cat","lion","tiger","crocodile","wolf","potato","tomato","carrot"};
    
    Random random=new Random();
    
    int i;
    
    String choseRandomWord()
    {
       
        i=random.nextInt(words.length);
        return words[i];
        
    }
    
   
    
    
    public static void main(String[] args)
    {
        PlayGame pg=new PlayGame();
        pg.guessTheWord();
        
        
        
        
    }
    
}
