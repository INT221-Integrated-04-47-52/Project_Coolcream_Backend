package sit.int221.coolcream.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand {
  @Id
  @Column(name="brand_id")
  private long brandId;
  @Column(name="brand_name")
  private  String brandName;
  @JsonBackReference
  @OneToMany(mappedBy = "brand")
  private List<Icecream> icecreams;



  public long getBrandId() {
    return brandId;
  }

  public void setBrandId(long brandId) {
    this.brandId = brandId;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }
  public String getBrandName() {
    return brandName;
  }



}
