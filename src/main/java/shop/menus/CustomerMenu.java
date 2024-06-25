package shop.menus;

import java.util.Scanner;

import shop.utils.Utilities;

public class CustomerMenu implements MenuInterface {
    public int inputData;

    public CustomerMenu(){
        Utilities.clearScreen();
        this.data();
        this.action();
    }

    public void data(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Enter Shop");
        System.out.println("0 - Go back");
        this.inputData = input.nextInt();
    }

    public void action(){
        switch (this.inputData){
            case 1: {
                new ShopMenu();
            }
            case 0: {
                new MainMenu();
            }

            default:{
                new CustomerMenu();
            }
        }
    }
}
