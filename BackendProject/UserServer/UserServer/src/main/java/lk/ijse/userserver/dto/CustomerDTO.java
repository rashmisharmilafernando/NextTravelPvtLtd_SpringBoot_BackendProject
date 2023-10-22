package lk.ijse.userserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    private String ID;
    private String name;
    private String email;
    private String address;
    private String NIC;
    private String username;
    private String password;
    private String profilePic;

}
