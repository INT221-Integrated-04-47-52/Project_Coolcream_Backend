package sit.int221.coolcream.models;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topping")
public class Topping {
  @Id
  @Column(name="topping_id")
  private long toppingId;
  @Column(name="topping_name")
  private String toppingName;
  @Column(name="topping_image")
  private String toppingImage;
  @JsonBackReference
  @OneToMany(mappedBy = "topping")
  private List<IcecreamHasTopping> icecreamHasToppings;


  public long getToppingId() {
    return toppingId;
  }

  public void setToppingId(long toppingId) {
    this.toppingId = toppingId;
  }

  public String getToppingName() {
    return toppingName;
  }

  public void setToppingName(String toppingName) {
    this.toppingName = toppingName;
  }

  public String getToppingImage() {
    return toppingImage;
  }

  public void setToppingImage(String toppingImage) {
    this.toppingImage = toppingImage;
  }

}
