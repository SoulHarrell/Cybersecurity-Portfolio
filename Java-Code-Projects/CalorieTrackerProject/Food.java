public class Food {

    private String name;
    private int caloriesPerServing;

    public Food(String name, int caloriesPerServing) {
        this.name = name;
        this.caloriesPerServing = caloriesPerServing;
    }

    public String getName() {
        return name;
    }

    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }

    @Override
    public String toString() {
        return name + " - " + caloriesPerServing + " calories per serving";
    }
}