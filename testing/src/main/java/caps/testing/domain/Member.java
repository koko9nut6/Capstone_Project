package caps.testing.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String name;

    @Column(name = "MEMBER_EMAIL")
    private String email;

    @Column(name = "MEMBER_PWD")
    private String pwd;

    @Embedded
    @Column(name = "MEMBER_ADDRESS")
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBER_ADMIN")
    private Administration admin;

    @Column(name = "MEMBER_PHONE_NUMBER")
    private String phone;

    @Builder
    public Member(Long id, String name, String email, String pwd, Address address, Administration admin, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.address = address;
        this.admin = admin;
        this.phone = phone;
    }
}
