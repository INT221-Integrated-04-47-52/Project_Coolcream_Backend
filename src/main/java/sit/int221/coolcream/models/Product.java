package sit.int221.coolcream.models;

import javax.persistence.*;

@Entity
public class Product {
  @Id
  @Column(name="product_code")
  private long productCode;
  @Column(name="product_name")
  private String productName;
  private String description;
  private double price;
  @Column(name="last_sale")
  private java.sql.Date lastSale;
  @Column(name="brand_id")
  private long brandId;

  public long getProductCode() {
    return productCode;
  }
  public void setProductCode(long productCode) {
    this.productCode = productCode;
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
  public java.sql.Date getLastSale() {
    return lastSale;
  }
  public void setLastSale(java.sql.Date lastSale) {
    this.lastSale = lastSale;
  }
  public long getBrandId() {
    return brandId;
  }
  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }

}
