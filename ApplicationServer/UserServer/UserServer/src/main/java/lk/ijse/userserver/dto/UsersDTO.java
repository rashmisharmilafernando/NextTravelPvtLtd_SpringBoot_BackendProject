package lk.ijse.userserver.dto;

import lk.ijse.userserver.util.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersDTO {
    private String userId;
    private String name;
    private String nic;
    private String age;
    private String gender;
    private String email;
    private String password;
    private RoleType roleType;
    private String contactNumber;
    private String address;
    private String  profilePic;



}
