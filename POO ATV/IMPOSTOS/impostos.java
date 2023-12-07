import java.text.DecimalFormat;

public class TaxCalculationApp {
    public static void main(String[] args) {
        Item item1 = new Item("Widget X", 150.0);
        Item item2 = new Item("Professional Service Y", 300.0);

        Tax[] taxes = {new ServiceTax(), new SalesTax(), new ProductTax()};

        for (Tax tax : taxes) {
            double item1TaxValue = tax.calculateTax(item1);
            double item2TaxValue = tax.calculateTax(item2);

            DecimalFormat df = new DecimalFormat("#.##");

            System.out.println("Tax: " + tax.getName());
            System.out.println("Item: " + item1.getName() + ", Tax Value: $ " + df.format(item1TaxValue));
            System.out.println("Item: " + item2.getName() + ", Tax Value: $ " + df.format(item2TaxValue));
        }
    }
}

class Item {
    private String name;
    private double value;

    public Item(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}

interface Tax {
    double calculateTax(Item item);
    String getName();
}

class ServiceTax implements Tax {
    private final double rate = 0.046;

    @Override
    public double calculateTax(Item item) {
        return item.getName().toLowerCase().contains("service") ? item.getValue() * rate : 0;
    }

    @Override
    public String getName() {
        return "Service Tax";
    }
}

class SalesTax implements Tax {
    private final double rate = 0.17;

    @Override
    public double calculateTax(Item item) {
        return item.getValue() * rate;
    }

    @Override
    public String getName() {
        return "Sales Tax";
    }
}

class ProductTax implements Tax {
    private final double rate = 0.25;

    @Override
    public double calculateTax(Item item) {
        return item.getName().toLowerCase().contains("product") ? item.getValue() * rate : 0;
    }

    @Override
    public String getName() {
        return "Product Tax";
    }
}
