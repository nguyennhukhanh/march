package march.dto;

import lombok.Data;
import march.model.User;

@Data
public class UserDTO {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;

    public UserDTO(User user) {
        this.fullName=user.getFullName();
        this.email=user.getEmail();
        this.phoneNumber=user.getPhoneNumber();
        this.address=user.getAddress();
    }
}
