package lk.ijse.userserver.dto;

import lk.ijse.userserver.util.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class UsersDTO {
    private String id;
    private RoleType roleType;
    private String username;
    private String password;
}
