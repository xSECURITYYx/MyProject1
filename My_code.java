// Class to represent an item in the order
class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }
}

// Class to represent a discount
class Discount {
    private double discountPercentage;

    public Discount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double applyDiscount(double total) {
        return total - (total * discountPercentage / 100);
    }
}

// Class to represent an order
class Order {
    private Item[] items;
    private Discount discount;

    public Order(Item[] items, Discount discount) {
        if (items == null || items.length == 0) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }
        this.items = items;
        this.discount = discount;
    }

    // Calculate the total cost of the order, including the discount
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotalCost();
        }
        if (discount != null) {
            return discount.applyDiscount(total);
        } else {
            return total;
        }
    }
}

public class My_code {
    public static void main(String[] args) {
        // Create some items
        Item item1 = new Item("Laptop", 1000.0, 1);
        Item item2 = new Item("Mouse", 50.0, 2);

        // Create an array of items
        Item[] items = {item1, item2};

        // Create a discount (10% off)
        Discount discount = new Discount(10.0);

        // Create an order with items and discount
        Order order = new Order(items, discount);

        // Calculate and display the total cost
        System.out.println("Total cost after discount: $" + order.calculateTotal());
    }
}
