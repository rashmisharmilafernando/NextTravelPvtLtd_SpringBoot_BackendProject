package lk.ijse.userserver.entity;

import jakarta.persistence.*;
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
@Table(name = "User")
public class UserEntity implements SuperEntity {
    @Id
    private String userId;
    private String name;
    private String nic;
    private String age;
    private String gender;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    private String contactNumber;
    private String address;
    @Column(columnDefinition = "LONGTEXT")
    private String  profilePic;

}
