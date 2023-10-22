package lk.ijse.userserver.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userID;
    private String name;
    private String nic;
    private int age;
    private String gender;
    private String email;
    private String contactNumber;
    private String address;
    private String role;
}
