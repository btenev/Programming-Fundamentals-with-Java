package P6_Vehicle_Catalogue;

public class Vehicle {
   private String type;
   private String model;
   private String color;
   private double horsePowers;

    public Vehicle(String type, String model, String color, double horsePowers) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePowers = horsePowers;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getHorsePowers() {
        return horsePowers;
    }
}
