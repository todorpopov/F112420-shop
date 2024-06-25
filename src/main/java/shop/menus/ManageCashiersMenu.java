package shop.menus;

import java.util.Scanner;

import shop.utils.Utilities;

public class ManageCashiersMenu implements MenuInterface {
    public int inputData;

    public ManageCashiersMenu(){
        Utilities.clearScreen();
        this.data();
        this.action();
    }

    public void data(){
        Scanner input = new Scanner(System.in);
        System.out.println("Shop Project in Java");
        System.out.println("-------------------------\n");
        System.out.println("1 - Create new Cashier");
        System.out.println("2 - List existing Cashiers");
        System.out.println("3 - Delete existing Cashier");
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
                new ManageCashiersMenu();
            }
        }
    }
}
