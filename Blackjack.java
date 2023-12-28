package edu.nyu.cs;

import static org.mockito.ArgumentMatchers.eq;
import java.util.Random;
import java.util.Scanner;


public class Blackjack {

  /**
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    Random randomcard = new Random();
    int UserCard1 = randomcard.nextInt((11-2) + 1) + 2; 
    int UserCard2 = randomcard.nextInt((11-2) + 1) + 2;
    System.out.println("Welcome to Blackjack!");
    String UserHandOutput = ("Your cards are: " + UserCard1 + " and " + UserCard2);
    System.out.println(UserHandOutput);
    int UserHand = UserCard1 + UserCard2;
    Boolean ContinueHitOrStand = true;
    Boolean DidUserBust = false;

    //user hit/stand loop
    UserHandOutput = "Your cards are: " + UserCard1 + ", " + UserCard2;
    while (ContinueHitOrStand && !DidUserBust) {
      System.out.println("Would you like to hit or stand? ");
      String UserResponse = scan.nextLine();
      if (UserResponse.equals("stand") || UserResponse.equals("stop") || UserResponse.equals("pass")){ 
        ContinueHitOrStand = false;
      }
      else if (UserResponse.equals("hit")){
        int NewUserCard = randomcard.nextInt((11-2) + 1) + 2;
        UserHand += NewUserCard;
        UserHandOutput += ", and " + NewUserCard; 
        System.out.println(UserHandOutput);
        
        if (UserHand > 21){
          DidUserBust = true;
        }
      }
      else{
        ContinueHitOrStand = false;
      } 
    }
    if (DidUserBust) {
      System.out.println("You have bust!");
      System.out.println("Dealer wins!");
    }

    //dealer hit/stand loop
    int DealerCard1 = randomcard.nextInt((11-2) + 1) + 2; 
    int DealerCard2 = randomcard.nextInt((11-2) + 1) + 2;
    int DealerHand = DealerCard1 + DealerCard2;
    Boolean DidDealerBust = false;
    Boolean DealerContinue = true;
    String DealerHandOutput = "The dealer's cards are: " + DealerCard1 + ", " + DealerCard2;
    while (DealerContinue && !DidDealerBust && !DidUserBust) {
      int NewDealerCard = randomcard.nextInt((11-2) + 1) + 2;
      if (DealerHand < 17){
        DealerHand += NewDealerCard;
        DealerHandOutput += ", " + NewDealerCard;
        System.out.println("The dealer hits.");
      }
      else if (DealerHand < 21 && DealerHand >= 17){
        System.out.println("The dealer stands.");
        DealerContinue = false;
      }
      else if (DealerHand == 21){
        DealerContinue = false;
      }
      else{
        DidDealerBust = true;
      }
    }

    //print user cards again and dealer cards here
    if (! DidUserBust){
      if (DidDealerBust){
        System.out.println("The dealer has bust!");
      }
      System.out.println(UserHandOutput);
      System.out.println(DealerHandOutput);
    } 

    //winner decide if user has not bust
    if (! DidUserBust && ! DidDealerBust){
      if (UserHand > DealerHand){
        System.out.println("You win!");
      }
      else if (UserHand < DealerHand){
        System.out.println("Dealer wins!");
      }
      else if (UserHand == DealerHand){
        System.out.println("Tie!");
      }
    }
    else if (! DidUserBust && DidDealerBust){
      System.out.println("You win!");
    }
    else if (DidUserBust && DidDealerBust)


    scan.close();
  } 
}

