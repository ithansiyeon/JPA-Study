package hellojpa;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class Period {
    LocalDateTime startDate;
    LocalDateTime endDate;
}
