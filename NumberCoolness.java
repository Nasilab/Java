//*******************************************************************
//
//   File: NumberCoolness.java          Assignment No.: 3
//
//   Author:bmn8
//
//   Class: NumberCoolness
// 
//   Time spent on this problem: 3hrs 
//   --------------------
//    This code prints out printNumberCoolness pattern.  
//
//*******************************************************************
public class NumberCoolness 
{
    // main
    public static void main(String[] args) 
    {
        // Main calls the method printNumberCoolness and passes different arguments
        printNumberCoolness(3);
        printNumberCoolness(9);
    }
    // this method defines how many spaces each line has 
    public static void printSpaces(int nSpaces) 
    {
        for (int i = 1; i <= nSpaces; i++)
        {
            System.out.print(" ");
        }
    }

    // this method defines print number coolness 
    public static void printNumberCoolness(int height) 
    {
   
        int m = 0;

        for (int row = 1; row <= height; row++)
        {
            printSpaces(height - row);
            m= m * 10 + row; 
            System.out.println(m + " x 8 +" + row + " = "+ (m * 8 + row));

           


        }
    }
}