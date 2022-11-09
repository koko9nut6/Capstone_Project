package caps.testing.dto;

import caps.testing.domain.Administration;
import caps.testing.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSignUpRequestDto {

    private String email;
    private String name;
    private String pwd;
    private Administration admin;
    private String phone;

    public Member toMember(){
        return Member.builder()
                .email(email)
                .name(name)
                .pwd(pwd)
                .admin(admin)
                .phone(phone)
                .build();
    }
}
