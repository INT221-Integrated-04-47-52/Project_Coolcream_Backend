package sit.int221.coolcream.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "size")
public class Size {
  @Id
  @Column(name="size_id")
  private long sizeId;
  @Column(name="size_type")
  private String sizeType;
  @JsonBackReference
  @OneToMany(mappedBy = "size")
  private List<Product> products;


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
