package pinomaker.phonebook.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "refresh_token")
@Entity
@ToString
@DynamicUpdate
@Setter
public class RefreshToken {

    @Id
    @Column(name = "auth_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "auth_key")
    private String authKey;
    @Column(name = "auth_value")
    private String authValue;
    private String type;

    public RefreshToken updateValue(String token) {
        this.authValue = token;
        return this;
    }

    @Builder(builderClassName = "refreshTokenBuilder", builderMethodName = "refreshTokenBuilder")
    public RefreshToken(String authKey, String authValue, String type) {
        this.authKey = authKey;
        this.authValue = authValue;
        this.type = type;
    }

    @Builder(builderClassName = "refreshTokenUpdate", builderMethodName = "refreshTokenUpdate")
    public RefreshToken(Long id, String authValue) {
        this.id = id;
        this.authValue = authValue;
    }
}
