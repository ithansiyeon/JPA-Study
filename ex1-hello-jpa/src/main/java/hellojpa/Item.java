package hellojpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@DiscriminatorColumn(name="DIS_TYPE")
public abstract class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
