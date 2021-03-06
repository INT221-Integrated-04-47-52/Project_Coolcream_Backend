package sit.int221.coolcream.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name= "icecream")
public class Icecream {

  @Id
  @Column(name= "icecream_id")
  private long icecreamId;
  @Column(name= "icecream_name")
  private String icecreamName;
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
  @OneToMany(mappedBy = "icecream")
  private List<IcecreamHasTopping> icecreamHasToppings;

  public Icecream() {
  }

  public Icecream(long icecreamId, String icecreamName, String description, double price, Date lastday, String image, Brand brand, Size size) {
    this.icecreamId = icecreamId;
    this.icecreamName = icecreamName;
    this.description = description;
    this.price = price;
    this.lastday = lastday;
    this.image = image;
    this.brand = brand;
    this.size = size;
  }

  public long getIcecreamId() {
    return icecreamId;
  }

  public void setIcecreamId(long icecreamId) {
    this.icecreamId = icecreamId;
  }

  public String getIcecreamName() {
    return icecreamName;
  }

  public void setIcecreamName(String icecreamName) {
    this.icecreamName = icecreamName;
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

  public Date getLastday() {
    return lastday;
  }

  public void setLastday(Date lastday) {
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

  public List<IcecreamHasTopping> getIcecreamHasToppings() {
    return icecreamHasToppings;
  }

  public void setIcecreamHasToppings(List<IcecreamHasTopping> icecreamHasToppings) {
    this.icecreamHasToppings = icecreamHasToppings;
  }
}
