package shop.menus;

import shop.utils.Utilities;

import java.util.Scanner;

public class MainMenu implements MenuInterface {
    public int inputData;

    public MainMenu(){
        Utilities.clearScreen();
        this.data();
        this.action();
    }

    public void data(){
        Scanner input = new Scanner(System.in);
        System.out.println("Shop Project in Java");
        System.out.println("-------------------------\n");
        System.out.println("1 - Enter as a Customer");
        System.out.println("2 - Enter as an Admin");
        System.out.println("0 - Quit");
        System.out.println("\nEnter choice: ");
        this.inputData = input.nextInt();
    }

    public void action(){
        switch (this.inputData){
            case 1: {
                new CustomerMenu();
            }
            case 2: {
                new AdminMenu();
            }
            case 0: {
                System.exit(0);
            }

            default:{
                new MainMenu();
            }
        }
    }
}
