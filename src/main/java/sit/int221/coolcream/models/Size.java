package sit.int221.coolcream.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Size {
  @Id
  @Column(name="size_id")
  private long sizeId;
  @Column(name="size_type")
  private String sizeType;


  public long getSizeId() {
    return sizeId;
  }

  public void setSizeId(long sizeId) {
    this.sizeId = sizeId;
  }


  public String getSizeType() {
    return sizeType;
  }

  public void setSizeType(String sizeType) {
    this.sizeType = sizeType;
  }

}
