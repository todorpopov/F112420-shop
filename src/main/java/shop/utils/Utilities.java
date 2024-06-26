package shop.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import shop.models.Category;

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

    public static String getStringInput(String message, Scanner input){
        System.out.println(message);
        String output = input.nextLine();
        return output;
    }

    public static double getDoubleInput(String message, Scanner input){
        System.out.println(message);
        double output = input.nextDouble();
        return output;
    }

    public static int getIntegerInput(String message, Scanner input){
        System.out.println(message);
        int output = input.nextInt();
        return output;
    }

    public static Category getCategoryInput(String message, Scanner input){
        System.out.println(message);
        String categoryString = input.next();
        if(categoryString == "Food"){
            return Category.Food;
        }
        if(categoryString != "NonFood"){
            return Category.NonFood;
        }
        else{
            return Category.None;
        }
    }

    public static LocalDate getDate(String message, Scanner input){
        System.out.println(message);
        String stringDate = input.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }
}
