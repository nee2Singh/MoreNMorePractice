package com.stringPractice.example;

import java.util.Arrays;
import java.util.Scanner;

public class StringAssignment 
{
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		/**Reverse a String**/
		String s1 = "iNeuron";
		String s2 = "";

		for(int i = (s1.length()-1); i >= 0; i--)
		{
			s2 = s2 + s1.charAt(i);
		}
		System.out.println("iNeuron is now ======= "+s2);
		System.out.println("\n***************************\n");

		/**Reversing String preserving position**/

		s1 = "Think Twice";
		s2 = "";
		String s3 = "";

		for(int i = (s1.length()-1); i >= 0; i--)
		{
			if(s1.charAt(i) >= 'A' && s1.charAt(i) <= 'Z')
				s2 = s2 + (char) (s1.charAt(i)+32);
			else
				s2 = s2 + s1.charAt(i);
		}

		String a[] = s2.split(" ");

		for(int i = (a.length-1); i >= 0; i--)
		{
			s3 = s3 + a[i]+" ";
		}
		System.out.println("Think Twice is now ======= "+s3);
		System.out.println("\n***************************\n");

		
		/**check the string is anagram**/
		checkAnagram();
		
		/**check the string is Pangram**/
		checkPangram();
		
		/**check duplicate characters**/
		checkDuplicateChars();
		
		/**Arrange alphabetically**/
		arrangeAlphabetic();
		
		/**count vowels and consonant in a string**/
		countVowelConsonant();
		
		/**count special characters in a string**/
		countSpecialChars();
	}
	
	
	/**check the string is anagram**/
	public static void checkAnagram()
	{
		System.out.println("Please enter the 1st String to check anagram = ");
		String anaString1 = scan.nextLine();

		System.out.println("Please enter the 2nd String to check anagram = ");
		String anaString2 = scan.nextLine();
		
		if(anaString1.length() == anaString2.length())
		{
			char arr1[] = anaString1.toCharArray();
			char arr2[] = anaString2.toCharArray();
			char temp;

			for(int i = 0; i < arr1.length; i++)
			{
				for(int j = i+1; j < arr1.length; j++)
				{
					if(arr1[i] > arr1[j])
					{
						temp = arr1[i];
						arr1[i] = arr1[j];
						arr1[j] = temp;
					}
					if(arr2[i] > arr2[j])
					{
						temp = arr2[i];
						arr2[i] = arr2[j];
						arr2[j] = temp;
					}
				}
			}
			
			if(Arrays.equals(arr1, arr2))
				System.out.println("Strings are anagram");
			else
				System.out.println("Strings are not anagram.");
		}
		else
			System.out.println("Strings are not anagram.");
		
		System.out.println("\n***************************\n");
	}
	
	/**check the string is Pangram**/
	public static void checkPangram()
	{
		System.out.println("Please enter the string to check pangram == ");
		String s1 = scan.nextLine();
		s1 = s1.replaceAll("\\s", "");
		s1 = s1.toLowerCase();
		
		boolean alpha[] = new boolean[26];
		
		boolean isPangram = true;
		
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z')
			{
				alpha[s1.charAt(i) - 'a'] = true;
			}
		}
		
		for(int i = 0; i < alpha.length; i++)
		{
			if(alpha[i])
				continue;
			else
			{
				isPangram = false;
				break;
			}
		}
		
		if(isPangram)
			System.out.println("String is Pangram");
		else
			System.out.println("String is not Pangram");
		
		System.out.println("\n***************************\n");
	}
	
	/**check duplicate characters**/
	public static void checkDuplicateChars()
	{
		System.out.println("Please enter a String to check duplicate characters - ");
		String s1 = scan.nextLine();
		
		s1 = s1.toLowerCase();
		s1 = s1.replaceAll("\\s", "");
		
		String s2 = "";
		
		for(int i = 0; i < s1.length(); i++)
		{
			for(int j = i+1; j < s1.length(); j++)
			{
				if(s1.charAt(i) == s1.charAt(j) && (s1.charAt(i) != ' ' || s1.charAt(i) != ' '))
				{
					s2 = s2 + s1.charAt(j)+", ";
				}
			}
		}
		
		System.out.println("The duplicate chars are - "+s2);
		System.out.println("\n***************************\n");
	}
	
	/**Arrange alphabetically**/
	public static void arrangeAlphabetic()
	{
		System.out.println("Please enter the string to sort alphabetically -- ");
		String s1 = scan.nextLine();
		
		char strArr[] = s1.toCharArray();
		char temp;
		
		for(int i = 0; i < strArr.length; i++)
		{
			for(int j = i + 1; j < strArr.length; j++)
			{
				if((strArr[i] > strArr[j]) && (strArr[i] !=' ' || strArr[j] != ' '))
				{
					temp = strArr[i];
					strArr[i] = strArr[j];
					strArr[j] = temp;
				}
			}
		}
		
		System.out.println("the sorted string is "+ String.valueOf(strArr));
		System.out.println("\n***************************\n");
	}
	
	/**count vowels and consonant in a string**/
	public static void countVowelConsonant()
	{
		System.out.println("Please enter the string to count vowels and consonants --- ");
		String s1 = scan.nextLine();
		s1 = s1.toLowerCase();
		
		int vowelCount = 0;
		int consoCount = 0;
		
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) >= 'a' &&  s1.charAt(i) <= 'z')
			{
				if(s1.charAt(i) == 'a' || s1.charAt(i) == 'e' || s1.charAt(i) == 'i' || s1.charAt(i) == 'o' || s1.charAt(i) == 'u')
				{
					vowelCount++;
				}
				else
				{
					consoCount++;
				}
			}
		}
		
		System.out.println("String has "+vowelCount+" vowels and "+consoCount+" consonents.");
		System.out.println("\n***************************\n");
	}

	
	/**count special characters in a string**/
	public static void countSpecialChars()
	{
		System.out.println("Please enter a string to count special characters ");
		String s1 = scan.nextLine();
		int spCharCount = 0;
		
		for(int i = 0; i < s1.length(); i++)
		{
			if((s1.charAt(i) >= 33 && s1.charAt(i) <= 47) || (s1.charAt(i) >= 58 && s1.charAt(i) <= 64) 
					|| (s1.charAt(i) >= 91 && s1.charAt(i) <= 96) || (s1.charAt(i) >= 123 && s1.charAt(i) <= 126))
			{
				spCharCount++;
			}
		}
		
		System.out.println("String has "+spCharCount+" special characters.");
		System.out.println("\n******************************\n");
	}
	
}
