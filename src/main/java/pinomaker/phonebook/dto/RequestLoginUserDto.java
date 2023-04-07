package pinomaker.phonebook.dto;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class RequestLoginUserDto {
    private String id;
    private String password;
    public UsernamePasswordAuthenticationToken toAuthentication( ){
        return new UsernamePasswordAuthenticationToken(id, password);
    }
}
