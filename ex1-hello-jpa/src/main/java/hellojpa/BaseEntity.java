package hellojpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "INSERT_MEMBER")
    private String createBy;
    private LocalDateTime createDate;
    private String lastmodifiedBy;
    private LocalDateTime lastModifiedDate;
}
