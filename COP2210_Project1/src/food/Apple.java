package food;

public class Apple {
    private String type;
    private double weight;
    private double pricePreUnitWeight;

    //---------------------------------------------------------

    public Apple(String type, double pricePreUnitWeight, double weightInGrams) {
        this.type = type;
        this.pricePreUnitWeight = pricePreUnitWeight;
        weight = 0.00220 * weightInGrams;
    }

    //---------------------------------------------------------

    public String getType() {
        return type;
    }
    public double getWeight() {
        return weight;
    }
    public double getPricePerUnitWeight() {
        return pricePreUnitWeight;
    }
    public void setPricePerUnitWeight(double pricePreUnitWeight, String personnel) {
        this.pricePreUnitWeight = pricePreUnitWeight;
        this.type = personnel;
    }

    //------------------------------------------------------------

    public void displayInfo() {
        System.out.println("==========================================");
        System.out.println("Apple Info");
        System.out.println("==========================================");
        System.out.printf("Type:\t\t\t\t %-15s\n", type);
        System.out.printf("Weight:\t\t\t\t %-6.4f lbs\n", weight);
        System.out.printf("Price Pre Unit:\t\t %-10.2f\n", pricePreUnitWeight);
    }
    public double price(){
        double price = weight * pricePreUnitWeight;
        return price;
    }
}
