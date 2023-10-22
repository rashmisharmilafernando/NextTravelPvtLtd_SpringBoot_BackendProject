package lk.ijse.userserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lk.ijse.userserver.util.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity implements SuperEntity {
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    private String username;
    private String password;

}
