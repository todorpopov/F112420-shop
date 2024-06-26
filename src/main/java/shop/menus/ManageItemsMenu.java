package shop.menus;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import shop.db.access.AccessItem;
import shop.db.access.AccessShop;
import shop.models.Category;
import shop.models.Item;
import shop.models.Shop;
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
                this.createItem();
                break;
            }
            case 2: {
                this.listExistingItems();
                break;
            }
            case 3: {
                this.deleteOneItem();
                break;
            }
            case 0: {
                new AdminMenu();
            }

            default:{
                new ManageItemsMenu();
            }
        }
    }

    private void createItem(){
        Utilities.clearScreen();

        Scanner input = new Scanner(System.in);
        String name = Utilities.getStringInput("Enter item name: ", input);
        int shopId = Utilities.getIntegerInput("Enter shop id: ", input);
        double deliveryPrice = Utilities.getDoubleInput("Enter delivery price: ", input);
        int quantity = Utilities.getIntegerInput("Enter delivery quantity: ", input);
        Category category = Utilities.getCategoryInput("Enter category (Food/NonFood): ", input);
        LocalDate expiry = Utilities.getDate("Enter expiration date (yyyy-MM-dd): ", input);
        
        Shop shop = AccessShop.getOne(shopId);

        Item item = new Item(shop, name, deliveryPrice, quantity, category, expiry);
        AccessItem.saveOne(item);
    }

    private void listExistingItems(){
        Utilities.clearScreen();
        List<Item> items = AccessItem.getAll();
        Utilities.clearScreen();

        items.forEach(item -> {
            System.out.println(item.getStr());
        });

        Utilities.pressToContinue();
    }

    private void deleteOneItem(){
        Utilities.clearScreen();

        Scanner input = new Scanner(System.in);
        int id = Utilities.getIntegerInput("Enter cashier's ID: ", input);

        AccessItem.deleteOne(id);
    }
}
