package com.skillnext;

/**
 * Hello world!
 *
 */
public class Palindrome 
{
    public static void main( String[] args )
    {
        int num = 123;
        int palindromeNumber = 0;
        while(num > 0){
            int digit = num % 10;
            palindromeNumber = palindromeNumber * 10 + digit;
            num = num / 10;
        }
        System.out.println(palindromeNumber);
    }
}
