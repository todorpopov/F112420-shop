package shop.utils;

import java.util.Scanner;

public class Utilities {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressToContinue(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key to continue: ");
        if(input.nextLine() != ""){
            return;
        }
    }
}
