package shop.menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        System.out.println("Enter name: ");
        String name = input.nextLine();

        System.out.println("Enter shop id: ");
        int shopId = input.nextInt();

        System.out.println("Enter delivery price: ");
        double deliveryPrice = input.nextDouble();

        System.out.println("Enter quantity: ");
        int quantity = input.nextInt();

        System.out.println("Food or Non-food (1/2): ");
        int categoryNum = input.nextInt();

        Category category = null;
        if(categoryNum == 1){
            category = Category.Food;
        }
        else{
            category = Category.NonFood;
        }

        System.out.println("Enter expiration date: ");
        String expiryString = input.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate expiry = LocalDate.parse(expiryString, formatter);
        
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
        System.out.println("Enter the item's id you want to delete: ");
        int id = input.nextInt();

        AccessItem.deleteOne(id);
    }
}
