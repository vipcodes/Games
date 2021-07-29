
package games;

import java.util.*;
import java.util.Scanner;
public class BlackJack {
   
       Random r=new Random();
       int [] cards={11,2,3,4,5,6,7,8,9,10,10,10,10};
      
       public int deal()
       {
          int i=r.nextInt(cards.length);
           return cards[i];
       }
   //==============================================================================================    
       int calculateScore(ArrayList cards)
       {
           int sum=0;
           Integer arr[]=new Integer[cards.size()];
           arr=(Integer[]) cards.toArray(arr);
          
           for(int i=0;i<arr.length;i++)
           {
               sum+=arr[i];
           }  
           if(sum==21 && arr.length<2)
               return 0;
           for(int i=0;i<arr.length;i++)
           {
               if(arr[i].equals(11) && sum>21)
                {
                sum-=11;
                sum+=1;
                }
           }
          
           return sum;
       }
//===================================================================================================
       
       
       
       String compare(int userScore,int dealerScore)
       {
           if(userScore==dealerScore)
               return "It's a draw.";
           else if(userScore==0)
               return "It's a BlackJack. You Won.";
           else if(dealerScore==0)
               return "Dealer has a BlackJack. You Lose.";
           else if(userScore>21)
               return "You went over, You Lose.";
           else if(dealerScore>21)
               return "Dealer went over You won.";
           else if(userScore>dealerScore)
               return "You Won.";
           else
               return "You Lose";
           
       }
//===================================================================================================       
    public static void main(String[] args) {
     
        BlackJack b=new BlackJack();
        ArrayList userCards=new ArrayList();
        ArrayList dealerCards=new ArrayList();
        
        Scanner sc=new Scanner(System.in);
        boolean isGameOver=true;
        
         for(int i=0;i<2;i++)
            {
                userCards.add(b.deal());
                dealerCards.add(b.deal());
            }
        int userScore=0;
        int dealerScore=0;
        
        while(isGameOver)
        {
          
             userScore=b.calculateScore(userCards);
             dealerScore=b.calculateScore(dealerCards);



            System.out.println("Your Cards:"+userCards);
            System.out.println("Dealer's First Crad: "+dealerCards.get(0));
        
        
            String userShouldDeal="";
            System.out.println("Do you want another card ? Type 'y' for yes or type 'n' for pass.\n");
            userShouldDeal=sc.next();
            if(userShouldDeal.equalsIgnoreCase("y"))
            {
                userCards.add(b.deal());
                userScore=b.calculateScore(userCards);
            }
            else
                isGameOver=false;
            if(userScore==0 ||dealerScore==0 || userScore>21)
                isGameOver=false;

            while(dealerScore!=0&&dealerScore<17)
            {
                dealerCards.add(b.deal());
                dealerScore=b.calculateScore(dealerCards);
            }
            
        }
     System.out.println("Your Final Hand:"+userCards+" \tYour Score:"+userScore);
     System.out.println("Dealer's Final Hand:"+dealerCards+"\tDealer's Score: "+dealerScore);
     System.out.println("Result: "+b.compare(userScore,dealerScore));
    }
}
