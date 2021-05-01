package sit.int221.coolcream.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
  @Id
  @Column(name="brand_id")
  private long brandId;
  @Column(name="brand_name")
  private  String brandName;



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
