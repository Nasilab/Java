
//***********************************************************************
//
//   File: Animation.java        Assignment No.: 4
//
//   Author: bmn8            
//
//   Class: Cashier
// 
//   Time spent on this problem: 6 hour
//   --------------------
//      This pgroams reads in unitprice, quanittya nd sales tax and 
//      calculates amount owed and change. 
//
//***********************************************************************
import java.util.Scanner;

public class Cashier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        // use Scanner object to read in the user's values
            // ask for user to input Unit Price 
            // ask for user to input quantity
            // ask for user to input sales tax 

        System.out.print("Enter Unit Price:");
        double unitPrice = console.nextDouble();

         System.out.print("Enter Quantity:");
         double quantity = console.nextDouble();

         System.out.print("Enter Sales Tax Rate:");
         double taxRate = console.nextDouble();

         // calculate Total amount owed
          double amountOwed = unitPrice*quantity + (taxRate/100 * unitPrice * quantity);
          // Print out The total owed amount is ((unitPrice + (tax* unitPrice * quantity)) ((Unit Price) plus (Tax Rate) tax)
        //  System.out.print("Total Amount owed is %d?");
          System.out.printf(" The total owed amount is $%.2f ($%.2f plus %.2f%% tax) \n", amountOwed, unitPrice, taxRate);

        // ask for user to input amount paid

        System.out.print("Enter Amount Paid:");
        double amountPaid = console.nextDouble(); 
        
        //Check if amount paid < amount owed
        // if paid < amount owed, print out(You still owe (amount owed-pain)
       
        if (amountPaid < amountOwed ) {
            System.out.printf("You still owe $%f", amountOwed - amountPaid);
        }
        // / If paid = owed, print out(Thank you for paying the exact amount!)

        else if (amountPaid == amountOwed) {
            System.out.print("Thank you for paying the exact amount!");

        }
        // if paid > owed calculate the change and the type of bills.  
        else if (amountPaid > amountOwed) {
            String output = getChange(amountOwed, amountPaid); 
            System.out.print(output);
        }
        console.close();
    }

    static String getChange(double owed, double paid) {

        String output = "";

        double changeRemainder = paid - owed; 
        output += String.format("Your change of %.2f is given as: \n %d 50 dollar bills", changeRemainder, (int) changeRemainder/50);
        
        changeRemainder = changeRemainder % 50;
        output += String.format("Your change of %.2f is given as: \n %d 20 dollar bills", changeRemainder, (int) changeRemainder/20);

        changeRemainder = changeRemainder % 20;
        output += String.format("Your change of %.2f is given as: \n %d 10 dollar bills", changeRemainder, (int) changeRemainder/10);

        changeRemainder = changeRemainder % 10;
        output += String.format("Your change of %.2f is given as: \n %d 5 dollar bills", changeRemainder, (int) changeRemainder/5);

        changeRemainder = changeRemainder % 5;
        output += String.format("Your change of %.2f is given as: \n %d 1 dollar bills", changeRemainder, (int) changeRemainder/1);

        changeRemainder = changeRemainder % 1;
        output += String.format("Your change of %.2f is given as: \n %d quarters", changeRemainder, (int) (changeRemainder/.25));
        
        changeRemainder = changeRemainder % .25;
        output += String.format("Your change of %.2f is given as: \n %d dimes", changeRemainder, (int) (changeRemainder/.1));

        changeRemainder = changeRemainder % .1;
        output += String.format("Your change of %.2f is given as: \n %d nickels", changeRemainder, (int) (changeRemainder/.05));

        changeRemainder = changeRemainder % .05;
        output += String.format("Your change of %.2f is given as: \n %d nickels", changeRemainder, (int) (changeRemainder/.01));
        
         return output;
    }
    }



