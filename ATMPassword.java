//*******************************************************************
    //
    //   File: ATMPassword.java          Assignment No.: 2
    //
    //   Author: bmn8         
    //
    //   Class: ATMPassword
    // 
    //   Time spent on this problem: .5
    //   --------------------
    //   
    //   The original program prints out: 1817374
    //
    //*******************************************************************
    public class ATMPassword {
        public static void main(String[] args) {
            System.out.println("Dear thieves, please don't steal my ATM card.");
            System.out.println("But if you do, here's my password:");
            firstpart();
            secondpart();
            System.out.println("");
        }
    
        public static void firstpart() {
            System.out.print("1");
            lastbit();
        }
    
        public static void secondpart() {
            System.out.print("8");
            firstpart();
            lucky();
            lastbit();
        }
    
        public static void lucky() {
            System.out.print("7");
        }
    
        public static void lastbit() {
            System.out.print("3");
            lucky();
            System.out.print("4");
        }
    }
    