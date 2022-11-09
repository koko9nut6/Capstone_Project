package caps.testing.domain;

import caps.testing.role.MemberRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity(name = "member")
@Data
@Getter @Setter
@NoArgsConstructor
public class Member extends BaseTimeEntity implements UserDetails {

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

//    @Enumerated(EnumType.STRING)
//    @Column(name = "MEMBER_ROLE")
//    private MemberRole memberRole;

    private String refreshToken;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Builder
    public Member(Long id, String name, String email, String pwd, Administration admin, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.admin = admin;
        this.phone = phone;
    }

    public void addWorkerAuthority(){
        this.admin = Administration.ROLE_WORKER;
    }

    public void addManagerAuthority(){
        this.admin = Administration.ROLE_MANAGER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority(admin.name()));
        return auth;
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.pwd = passwordEncoder.encode(pwd);
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}
