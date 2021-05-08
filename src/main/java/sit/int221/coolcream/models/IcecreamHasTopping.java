package sit.int221.coolcream.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "icecream_has_topping")
public class IcecreamHasTopping {
  @Id
  @Column(name = "has_topping_id")
  private Long hasToppingId;

  @ManyToOne
  @JoinColumn(name="topping_id")
  private Topping topping;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name= "icecream_id")
  private Icecream icecream;

  public Long getHasToppingId() {
    return hasToppingId;
  }

  public void setHasToppingId(Long hasToppingId) {
    this.hasToppingId = hasToppingId;
  }

  public Topping getTopping() {
    return topping;
  }

  public void setTopping(Topping topping) {
    this.topping = topping;
  }

  public Icecream getIcecream() {
    return icecream;
  }

  public void setIcecream(Icecream icecream) {
    this.icecream = icecream;
  }
}
