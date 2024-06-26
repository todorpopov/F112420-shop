package shop.menus;

import java.util.List;
import java.util.Scanner;

import shop.db.access.AccessShop;
import shop.models.Shop;
import shop.utils.Utilities;

public class ManageShopsMenu implements MenuInterface {
    public int inputData;

    public ManageShopsMenu(){
        Utilities.clearScreen();
        this.data();
        this.action();
    }

    public void data(){
        Scanner input = new Scanner(System.in);
        System.out.println("Shop Project in Java");
        System.out.println("-------------------------\n");
        System.out.println("1 - Create new Shop");
        System.out.println("2 - List existing Shops");
        System.out.println("3 - Delete existing Shop");
        System.out.println("0 - Go back");
        System.out.println("\nEnter choice: ");
        this.inputData = input.nextInt();
    }

    public void action(){
        switch (this.inputData){
            case 1: {
                this.createShop();
                break;
            }
            case 2: {
                this.listExistingShops();
                break;
            }
            case 3: {
                this.deleteOneShop();
                break;
            }
            case 0: {
                new AdminMenu();
            }

            default:{
                new ManageShopsMenu();
            }
        }
    }

    private void createShop(){
        Utilities.clearScreen();

        Scanner input = new Scanner(System.in);
        String name = Utilities.getStringInput("Enter Shop name: ", input);
        double markupPercentage = Utilities.getDoubleInput("Enter markup percentage: ", input);

        Shop shop = new Shop(name, markupPercentage);
        AccessShop.saveOne(shop);
    }

    private void listExistingShops(){
        Utilities.clearScreen();
        List<Shop> shops = AccessShop.getAll();
        Utilities.clearScreen();

        shops.forEach(shop -> {
            System.out.println(shop.getStr());
        });

        Utilities.pressToContinue();
    }

    private void deleteOneShop(){
        Utilities.clearScreen();

        Scanner input = new Scanner(System.in);
        int id = Utilities.getIntegerInput("Enter shop's ID: ", input);

        AccessShop.deleteOne(id);
    }
}
