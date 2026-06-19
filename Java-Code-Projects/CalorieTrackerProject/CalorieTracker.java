import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CalorieTracker {

    private int totalCalories;

    public CalorieTracker() {
        totalCalories = loadTotal();
    }

    private int loadTotal() {

        try {

            File file = new File(System.getProperty("user.home"), "total.txt");

            if (!file.exists()) {
                return 0;
            }

            Scanner scanner = new Scanner(file);

            int total = Integer.parseInt(scanner.nextLine());

            scanner.close();

            return total;

        } catch (Exception e) {
            return 0;
        }
    }

    public void saveTotal() {

        try {

            File file = new File(System.getProperty("user.home"), "total.txt");

            FileWriter writer = new FileWriter(file);

            writer.write(String.valueOf(totalCalories));

            writer.close();

        } catch (Exception e) {
            System.out.println("Error saving total");
        }
    }

    public void addCalories(int calories) {
        totalCalories += calories;
        saveTotal();
    }

    public void burnCalories(int calories) {
        totalCalories -= calories;
        saveTotal();
    }

    public int getTotalCalories() {
        return totalCalories;
    }
    public void resetCalories() {
        totalCalories = 0;
        saveTotal();
    }
}