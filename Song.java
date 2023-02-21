//*******************************************************************
    //
    //   File: Song.java          Assignment No.: 2
    //
    //   Author: bmn8         
    //
    //   Class: Song
    // 
    //   Time spent on this problem: .5hrs
    //   --------------------
    //   
    //   This program prints out a cumulative song. 
    //
    //*******************************************************************
    public class Song {
        public static void main(String[] args) {
            System.out.print("On the 1st day of \"Xmas\", my true love gave to me\n");
            FirstVerse();
            
            System.out.print("On the 2nd day of \"Xmas\", my true love gave to me\n");
            SecondVerse();

            System.out.print("On the 3rd day of \"Xmas\", my true love gave to me\n");
            ThirdVerse();

            System.out.print("On the 4th day of \"Xmas\", my true love gave to me\n");
            FourthVerse();
            
            System.out.print("On the 5th day of \"Xmas\", my true love gave to me\n");
            FifthVerse();

            System.out.print("On the 6th day of \"Xmas\", my true love gave to me\n");
            SixthVerse();

            System.out.print("On the 7th day of \"Xmas\", my true love gave to me\n");
            SeventhVerse();
        }
    
        public static void FirstVerse() {
            System.out.print("a partridge in a pear tree.\n");
            System.out.println("");
        }
    

        public static void SecondVerse() {
            System.out.print("two turtle doves, and\n");
            FirstVerse();
        }

        public static void ThirdVerse() {
            System.out.print("three French hens,\n");
            SecondVerse();
        }
        public static void FourthVerse() {
            System.out.print("four calling birds,\n");
            ThirdVerse();
        }
        public static void FifthVerse() {
            System.out.print("five golden rings,\n");
            FourthVerse();
        }
        public static void SixthVerse() {
            System.out.print("six geese a-laying,\n");
            FifthVerse();
        }
        public static void SeventhVerse() {
            System.out.print("seven missing toes\n");
            System.out.print("no explanation\n");
            SixthVerse();
        }
    }
