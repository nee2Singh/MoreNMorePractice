package com.assignment.ineuron;

import java.util.Scanner;

//Take the lower and Upper number range
class TakeRange
{
	int rangeFrom;
	int rangeTo;
	
	Scanner scan = new Scanner(System.in);
	
	public int takeRangeFrom()
	{
		System.out.println("Please enter the Lower Number Range. ");
		rangeFrom = scan.nextInt();
		
		return rangeFrom;
	}
	
	public int takeRangeTo()
	{
		System.out.println("Please enter the Upper Number Range. ");
		rangeTo = scan.nextInt();
		
		return rangeTo;
	}
	
}

//Take the Number from guesser
class GiveNumber
{
	int numToGuess;
	
	public int numGuess(int rangeFrom, int rangeTo)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please give a number between "+rangeFrom+" and "+rangeTo+" for the game to guess. ");
		numToGuess = scan.nextInt();
		
		if(numToGuess >= rangeFrom && numToGuess <= rangeTo)
		{
			return numToGuess;
		}
		else
		{
			System.out.println("Number is not in range.");
			return numGuess(rangeFrom, rangeTo);
		}
	}
}

//Take the number from player
class PlayerGuess
{
	int playerNum;
	
	public int playerNum(int rangeFrom, int rangeTo)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Player - Please guess the number between "+rangeFrom+" and "+rangeTo+".");
		playerNum = scan.nextInt();
		
		if(playerNum >= rangeFrom && playerNum <= rangeTo)
		{
			return playerNum;
		}
		else
		{
			System.out.println("Number is not in range.");
			return playerNum(rangeFrom, rangeTo);
		}
		
	}
}

//Umpire will take inputs from guesser and player and announce the winner
class UmpireDescision
{
	int givenNumToGuess;
	int numFromP1;
	int numFromP2;
	int numFromP3;
	int rangeFrom;
	int rangeTo;
	
	public void takeRangeToGuess()
	{
		TakeRange rangeToGuess = new TakeRange();
		rangeFrom = rangeToGuess.takeRangeFrom();
		rangeTo = rangeToGuess.takeRangeTo();
		
		if(rangeFrom >= rangeTo)
		{
			System.out.println("Lower and Upper Number range are not correct. Please enter again.");
			takeRangeToGuess();
		}
	}
	
	public void takeNumForChallenge()
	{
		GiveNumber givenNum = new GiveNumber();
		givenNumToGuess = givenNum.numGuess(rangeFrom, rangeTo);
	}
	
	public void takeNumFromPlayers()
	{
		PlayerGuess p1 = new PlayerGuess();
		numFromP1 = p1.playerNum(rangeFrom, rangeTo);
		
		PlayerGuess p2 = new PlayerGuess();
		numFromP2 = p2.playerNum(rangeFrom, rangeTo);
		
		PlayerGuess p3 = new PlayerGuess();
		numFromP3 = p3.playerNum(rangeFrom, rangeTo);
	}
	
	public void compareNum()
	{
		if(givenNumToGuess == numFromP1)
		{
			if(givenNumToGuess == numFromP2 && givenNumToGuess == numFromP3)
				System.out.println("Game tied, All the players have guessed the right number.");
			
			else if(givenNumToGuess == numFromP2 && givenNumToGuess != numFromP3)
				System.out.println("Players 1 and 2 have guessed the right number.");
			
			else if(givenNumToGuess != numFromP2 && givenNumToGuess == numFromP3)
				System.out.println("Players 1 and 3 have guessed the right number.");
			
			else
				System.out.println("Players 1 has guessed the right number.");
		}
		
		else if(givenNumToGuess == numFromP2)
		{
			if(givenNumToGuess == numFromP3)
				System.out.println("Players 2 and 3 have guessed the right number.");
			
			else
				System.out.println("Players 2 has guessed the right number.");
		}
		
		else if(givenNumToGuess == numFromP3)
			System.out.println("Players 3 has guessed the right number.");
		
		else
			System.out.println("None of the Player has guessed the right number. Please try Again...!");
	}
}

public class GuessTheNumber 
{
	public static void main(String[] args) 
	{
		String playAgain = "yes";
		UmpireDescision uDesc = new UmpireDescision();

		while(playAgain.equalsIgnoreCase("yes"))
		{
			uDesc.takeRangeToGuess();
			uDesc.takeNumForChallenge();
			uDesc.takeNumFromPlayers();
			uDesc.compareNum();
			System.out.println("Wanna play again..! Yes or No...?");
			Scanner scan = new Scanner(System.in);
			playAgain = scan.next();
		}
		


	}
}
