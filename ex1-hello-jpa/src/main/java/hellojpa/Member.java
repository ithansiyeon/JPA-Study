package hellojpa;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Team team;

}

