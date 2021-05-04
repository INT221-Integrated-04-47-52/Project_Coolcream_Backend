package sit.int221.coolcream.models;

import javax.persistence.*;

@Entity
@Table(name = "product_has_topping")
public class ProductHasTopping {
  @Id
  @Column(name = "has_topping_id")
  private String hasToppingId;
  @Column(name = "topping_id")
  private long toppingId;
  @Column(name = "product_id")
  private long productId;
//  @ManyToOne
//  private Product products;


  public String getHasToppingId() {
    return hasToppingId;
  }

  public void setHasToppingId(String hasToppingId) {
    this.hasToppingId = hasToppingId;
  }


  public long getToppingId() {
    return toppingId;
  }

  public void setToppingId(long toppingId) {
    this.toppingId = toppingId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

//  public Product getProducts() {
//    return products;
//  }
//
//  public void setProducts(Product products) {
//    this.products = products;
//  }
}
