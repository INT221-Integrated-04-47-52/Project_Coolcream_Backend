package sit.int221.coolcream.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductHasTopping {
  @Id
  private String hasToppingId;
  private long toppingId;
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
