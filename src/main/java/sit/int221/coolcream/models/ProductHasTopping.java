package sit.int221.coolcream.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "product_has_topping")
public class ProductHasTopping {
  @Id
  @Column(name = "has_topping_id")
  private String hasToppingId;
  @ManyToOne
  @JoinColumn(name="topping_id")
  private Topping topping;
//  @ManyToOne
//  @JoinColumn(name="product_id")
//  private Product products;
  private long product_id;


  public String getHasToppingId() {
    return hasToppingId;
  }

  public void setHasToppingId(String hasToppingId) {
    this.hasToppingId = hasToppingId;
  }


  public Topping getTopping() {
    return topping;
  }

  public void setTopping(Topping topping) {
    this.topping = topping;
  }

//  public Product getProducts() {
//    return products;
//  }
//
//  public void setProducts(Product products) {
//    this.products = products;
//  }


  public long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(long product_id) {
    this.product_id = product_id;
  }
}
