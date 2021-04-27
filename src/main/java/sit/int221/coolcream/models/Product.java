package sit.int221.coolcream.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_code;
    private String product_name;
    private String description;
    private double price;
    private String last_sale;

    public Product() {
    }

    public Product(int product_code, String product_name, String description, double price, String last_sale) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
        this.last_sale = last_sale;
    }

    public int getProduct_code() {
        return product_code;
    }

    public void setProduct_code(int product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLast_sale() {
        return last_sale;
    }

    public void setLast_sale(String last_sale) {
        this.last_sale = last_sale;
    }
}
