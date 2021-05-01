package sit.int221.coolcream.models;

import javax.persistence.*;

@Entity
public class Product {
  @Id
  @Column(name="product_id")
  private long productId;
  @Column(name="product_name")
  private String productName;
  @Column(name="describe")
  private String describe;
  @Column(name="price")
  private double price;
  @Column(name="lastday")
  private java.sql.Date lastDay;
  @Column(name="brand_brand_id")
  private long brandId;
  @Column(name="size_size_id")
  private  long sizeId;


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
  public String getDescribe() {
    return describe;
  }
  public void setDescribe(String describe) {
    this.describe = describe;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public java.sql.Date getLastDay() {
    return lastDay;
  }
  public void setLastDay(java.sql.Date lastDay) {
    this.lastDay = lastDay;
  }
  public long getBrandId() {
    return brandId;
  }
  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }
  public long getSizeId() {
    return sizeId;
  }
  public void setSizeId(long sizeId) {
    this.sizeId = sizeId;
  }

}
