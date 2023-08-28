package pinomaker.phonebook.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class RequestLoginUserDto {
    @Schema(example = "admin")
    private String id;

    @Schema(example = "1234")
    private String password;
    public UsernamePasswordAuthenticationToken toAuthentication( ){
        return new UsernamePasswordAuthenticationToken(id, password);
    }
}
