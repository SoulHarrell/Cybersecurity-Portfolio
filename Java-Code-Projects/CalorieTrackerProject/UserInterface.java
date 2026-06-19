import java.util.Scanner;

public class UserInterface {

    private FoodDatabase database;
    private CalorieTracker tracker;
    private Scanner scanner;

    public UserInterface(FoodDatabase database, CalorieTracker tracker, Scanner scanner) {

        this.database = database;
        this.tracker = tracker;
        this.scanner = scanner;
    }

    public void start() {

        database.loadDatabase();

        while (true) {

            System.out.println();
            System.out.println("Enter command:");
            System.out.println("ate <food>");
            System.out.println("exercise <calories>");
            System.out.println("total");
            System.out.println("reset");
            System.out.println("exit");

            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                database.saveDatabase();
                break;
            }

            if (input.equals("total")) {
                System.out.println("Total calories: " + tracker.getTotalCalories());
                continue;
            }

            if (input.startsWith("exercise")) {

                String[] parts = input.split(" ", 2);

                if (parts.length < 2) {
                    System.out.println("Usage: exercise 200");
                    continue;
                }
                
            try {
                int burned = Integer.parseInt(parts[1]);
                tracker.burnCalories(burned);
                System.out.println("Logged exercise: -" + burned);
                
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
            
                continue;
            }
            
            if (input.startsWith("ate")) {               

                String foodName = input.substring(4).trim();               

            if (!database.containsFood(foodName)) {
              
                System.out.println("Unknown food. Calories per serving? ");
                
            try {
                int calories = Integer.parseInt(scanner.nextLine());

                database.addFood(foodName, calories);
                database.saveDatabase();
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid Calorie amount! Returning to main menu.");
                continue;
            }
        }
           
            System.out.println("How many servings? ");
            
        try {
            double servings = Double.parseDouble(scanner.nextLine());           

            int calories = database.getCalories(foodName);
            tracker.addCalories((int) (calories * servings));

            System.out.println("Logged " + foodName);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Returning to main menu.");
        }
            continue;
        }
            if (input.equals("reset")) {
                tracker.resetCalories();
                System.out.println("Calories reset to 0.");
                continue;
            }
            
            System.out.println("Unknown command.");
        }
    }
}
