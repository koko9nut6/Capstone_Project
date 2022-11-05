package caps.testing.dto;

import caps.testing.domain.Address;
import caps.testing.domain.Administration;
import caps.testing.domain.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class MemberDTO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "MEMBER_EMAIL")
    private String email;

    @Column(name = "MEMBER_PWD")
    private String pwd;

//    @Embedded
//    @Column(name = "MEMBER_ADDRESS")
//    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_ADMIN")
    private Administration admin;

    @Column(name = "MEMBER_PHONE_NUMBER")
    private String phone;

    @Builder
    public MemberDTO(Long id, String name, String email, String pwd, Administration admin, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.admin = admin;
        this.phone = phone;
    }

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .name(name)
                .email(email)
                .pwd(new BCryptPasswordEncoder().encode(pwd))
                .admin(admin)
                .phone(phone)
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Administration getAdmin() {
        return admin;
    }

    public void setAdmin(Administration admin) {
        this.admin = admin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
