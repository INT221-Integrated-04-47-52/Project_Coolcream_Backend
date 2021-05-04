package sit.int221.coolcream.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class Product {

  @Id
  @Column(name="product_id")
  private long productId;
  @Column(name="product_name")
  private String productName;
  private String description;
  private double price;
  private java.sql.Date lastday;
  private String image;
  @ManyToOne
  @JoinColumn(name="brand_brand_id")
  private Brand brand;
  @ManyToOne
  @JoinColumn(name="size_size_id")
  private Size size;
//  @JsonBackReference
//  @OneToMany(mappedBy = "product")
//  private List<ProductHasTopping> productHasToppings;


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
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


  public java.sql.Date getLastday() {
    return lastday;
  }

  public void setLastday(java.sql.Date lastday) {
    this.lastday = lastday;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }

//  public List<ProductHasTopping> getProductHasToppings() {
//    return productHasToppings;
//  }
//
//  public void setProductHasToppings(List<ProductHasTopping> productHasToppings) {
//    this.productHasToppings = productHasToppings;
//  }
}
