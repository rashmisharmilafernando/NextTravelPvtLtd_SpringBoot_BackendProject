package lk.ijse.userserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponese {
    private String ID;
    private String name;
    private String email;
    private String address;
    private String NIC;
    private String username;
    private String password;
    private byte[]   profilePic;

    public CustomerResponese(String ID, String name, String email, String address, String NIC, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.NIC = NIC;
        this.username = username;
        this.password = password;
    }
}
