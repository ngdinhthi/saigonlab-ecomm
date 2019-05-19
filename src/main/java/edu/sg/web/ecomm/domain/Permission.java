package edu.sg.web.ecomm.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "permission")
public class Permission implements Serializable {

  private static final long serialVersionUID = -751091275089074962L;

  @Id
  @GeneratedValue
  private int id;

  private String code;

  private String name;

  private String description;

}
