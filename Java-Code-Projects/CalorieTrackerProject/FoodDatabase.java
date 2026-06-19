import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FoodDatabase {

    private ArrayList<Food> foods;

    public FoodDatabase() {
        foods = new ArrayList<>();
    }

    public void loadDatabase() {

        try {
            File file = new File(System.getProperty("user.home"), "foods.txt");

            if (!file.exists()) {
                return;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] parts = line.split("=");

                if (parts.length == 2) {

                    String name = parts[0];
                    int calories = Integer.parseInt(parts[1]);

                    foods.add(new Food(name, calories));
                }
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Error loading database");
        }
    }

    public void saveDatabase() {

        try {

            File file = new File(System.getProperty("user.home"), "foods.txt");
            FileWriter writer = new FileWriter(file);

            for (Food food : foods) {
                writer.write(food.getName() + "=" + food.getCaloriesPerServing() + "\n");
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving database");
        }
    }

    public void addFood(String name, int calories) {
        foods.add(new Food(name, calories));
    }

    public boolean containsFood(String name) {

        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public int getCalories(String name) {

        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return food.getCaloriesPerServing();
            }
        }

        return 0;
    }
}