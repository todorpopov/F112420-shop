package shop.menus;

import java.util.Scanner;

import shop.utils.Utilities;

public class ManageItemsMenu implements MenuInterface {
    public int inputData;

    public ManageItemsMenu(){
        Utilities.clearScreen();
        this.data();
        this.action();
    }

    public void data(){
        Scanner input = new Scanner(System.in);
        System.out.println("Shop Project in Java");
        System.out.println("-------------------------\n");
        System.out.println("1 - Create new Item");
        System.out.println("2 - List existing Items");
        System.out.println("3 - Delete existing Item");
        System.out.println("0 - Go back");
        System.out.println("\nEnter choice: ");
        this.inputData = input.nextInt();
    }

    public void action(){
        switch (this.inputData){
            case 1: {
            }
            case 2: {
            }
            case 3: {
            }
            case 0: {
                new AdminMenu();
            }

            default:{
                new ManageItemsMenu();
            }
        }
    }
}
