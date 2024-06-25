package shop.menus;

import java.util.Scanner;

import java.util.List;

import shop.db.access.AccessCashier;
import shop.models.Cashier;
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
                this.createCashier();
                break;
            }
            case 2: {
                this.listExistingCashiers();
                break;
            }
            case 3: {
                this.deleteOneCashier();
                break;
            }
            case 0: {
                new AdminMenu();
            }

            default:{
                new ManageCashiersMenu();
            }
        }
    }

    private void createCashier(){
        Utilities.clearScreen();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = input.nextLine();
        System.out.println("Enter salary: ");
        float salary = input.nextFloat();

        Cashier cashier = new Cashier(name, salary);
        AccessCashier.saveOne(cashier);
    }

    private void listExistingCashiers(){
        Utilities.clearScreen();
        List<Cashier> cashiers = AccessCashier.getAll();
        Utilities.clearScreen();

        cashiers.forEach(cashier -> {
            System.out.println(cashier.getId() + " " + cashier.getName() + " " + cashier.getSalary());
        });

        Utilities.pressToContinue();
    }

    private void deleteOneCashier(){
        Utilities.clearScreen();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the cashier's id you want to delete: ");
        int id = input.nextInt();

        AccessCashier.deleteOne(id);
    }
}
