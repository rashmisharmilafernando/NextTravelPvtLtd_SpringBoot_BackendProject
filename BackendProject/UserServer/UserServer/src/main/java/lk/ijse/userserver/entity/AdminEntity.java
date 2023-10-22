package lk.ijse.userserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AdminEntity implements SuperEntity {
    @Id
    @GeneratedValue()
    private String userID;
    private String name;
    private String nic;
    private int age;
    private String gender;
    private String email;
    private String contactNumber;
    private String address;
}
