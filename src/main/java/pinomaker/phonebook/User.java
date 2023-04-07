package pinomaker.phonebook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pinomaker.phonebook.common.entity.BaseTimeEntity;
import pinomaker.phonebook.common.enums.UserAuthority;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_idx")
    private Long idx;

    @Column(name ="user_id")
    private String id;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_name")
    private String name;

    @Column(nullable = false)
    private UserAuthority authority;
}
