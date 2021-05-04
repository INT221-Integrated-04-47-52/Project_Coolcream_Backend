package sit.int221.coolcream.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "product_has_topping")
public class ProductHasTopping {
  @Id
  @Column(name = "has_topping_id")
  private String hasToppingId;
  @ManyToOne
  @JoinColumn(name="topping_id")
  private Topping topping;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name="product_id")
  private Product product;


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

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

}
