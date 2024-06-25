package shop.menus;

import shop.utils.Utilities;

import java.util.Scanner;

public class AdminMenu implements MenuInterface{
    public int inputData;

    public AdminMenu(){
        Utilities.clearScreen();
        this.data();
        this.action();
    }

    public void data(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Manage Shops");
        System.out.println("2 - Manage Items");
        System.out.println("3 - Manage Cashiers");
        System.out.println("0 - Go back");
        this.inputData = input.nextInt();
    }

    public void action(){
        switch (this.inputData){
            case 1: {
                new ManageShopsMenu();
            }
            case 2: {
                new ManageItemsMenu();
            }
            case 3: {
                new ManageCashiersMenu();
            }
            case 0: {
                new MainMenu();
            }

            default:{
                new AdminMenu();
            }
        }
    }
}
