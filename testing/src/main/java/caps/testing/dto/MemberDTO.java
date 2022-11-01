package caps.testing.dto;

import caps.testing.domain.Address;
import caps.testing.domain.Administration;
import caps.testing.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@NoArgsConstructor
public class MemberDTO {

    private Long id;
    private String name;
    private String email;
    private String pwd;
    private Address address;
    private Administration admin;
    private String phone;

    @Builder
    public MemberDTO(Long id, String name, String email, String pwd, Address address, Administration admin, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.address = address;
        this.admin = admin;
        this.phone = phone;
    }

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .name(name)
                .email(email)
                .pwd(new BCryptPasswordEncoder().encode(pwd))
                .address(address)
                .admin(admin)
                .phone(phone)
                .build();
    }
}
