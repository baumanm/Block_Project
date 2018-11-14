/**
* This program estimates the amount of cinder blocks 
* 9-10-18
* Block Counter
* @author Stephen Privette, Hillary Agbele, Marc Bauman
*/
package gp_02_0910_privette;

import java.util.Scanner;

public class GP_02_0910_Privette 
{
    public static void main(String[] args) 
    {
        // variables
        double numOfWalls;
        double totalSF = 0;
        double length;
        double height;
        double wallSF;
        String userName;
        
        Scanner keyboard = new Scanner(System.in);
        // constants
        double BLOCKPERSF = 1.125;
        double BLOCKSPERBAGOFMORTAR = 35;
        
        System.out.println("Welcome to the block estimator!\n");
        
        System.out.println("Please enter your name:");
        userName = keyboard.next();
        
        // capturing input from user
        System.out.println("Enter the number of walls:");
        numOfWalls = valNum(1,99999);
        
        // loop to capture user input and total sf
        for (int i = 1; i <= numOfWalls; i++)
        {
            System.out.println("Enter the length in feet"
                    + " of wall " + i + ":");
            length = valNum(1,9999999);
            System.out.println("Enter the height in feet"
                    + " of wall " + i + ":");
            height = valNum(1,9999999);           
            wallSF = length * height;
            
            System.out.println("Enter the square "
                    + "feet of doors and windows in wall " + i + ":");
            wallSF -= valNum(0,9999999);
            totalSF += wallSF;
        }
        
        // printing result
        System.out.println(userName + " you will need " + calculateBlock(totalSF, BLOCKPERSF) + " blocks.");
        System.out.println("You will also need " + calculateMortar(totalSF, BLOCKPERSF, BLOCKSPERBAGOFMORTAR) + " bags of mortar.");
    }
    
    // calculating bloks
    public static double calculateBlock(double sf, double rate)
    {
        // if the number of blocks is not an even int then truncate the
        // decimal amount and add 1
        
        if (sf * rate % 2 > 0)
        {
            return (int) (sf * rate) +1;
        }
        else
        {
            return (int) sf * rate;
        }
    }
    // calculating mortar
    public static double calculateMortar(double sf, double rate, double BLOCKSPERBAGOFMORTAR)
    {
        // if the number of bags is not an even int then truncate the
        // decimal amount and add 1
        
        if (sf * rate/BLOCKSPERBAGOFMORTAR % 2 > 0)
        {
            return (int) (sf * rate/BLOCKSPERBAGOFMORTAR) +1;
        }
        else
        {
            return (int) (sf * rate/BLOCKSPERBAGOFMORTAR);
        }
    }
    
    // captures number from user and validates it 
    // takes low and high parameters for range
    public static double valNum(double low, double high)
    {
        double num;
        
        Scanner keys = new Scanner(System.in);
        
        // breaks when number is in correct range
        do
        {
            // while entry is not a number try again
            while (!keys.hasNextDouble())
            {
                System.out.println("You must enter a number.");
                keys.next();
            }
        
            num = keys.nextDouble();
            
            if(num < low || num > high)
            {
              System.out.println("Your number must be between " + low
                    + " and " + high);
            }
            
        }while (num < low || num > high);
        return num;
    }
}
