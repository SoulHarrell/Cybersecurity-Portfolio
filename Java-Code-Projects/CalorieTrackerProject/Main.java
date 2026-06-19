import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FoodDatabase database = new FoodDatabase();

        CalorieTracker tracker = new CalorieTracker();

        UserInterface ui = new UserInterface(database, tracker, scanner);

        ui.start();

        scanner.close();
    }
}