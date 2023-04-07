package pinomaker.phonebook.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pinomaker.phonebook.common.dto.RequestResponseDto;
import pinomaker.phonebook.dto.RequestLoginUserDto;
import pinomaker.phonebook.dto.RequestSaveUserDto;
import pinomaker.phonebook.dto.RequestTokenDto;
import pinomaker.phonebook.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name="User Api", description = "유저 관련 API")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Save Usere", description = "유저 생성하기")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping
    public RequestResponseDto<?> saveUser(@RequestBody RequestSaveUserDto dto) {
        return userService.save(dto);
    }

    @Operation(summary = "Login User", description = "유저 로그인")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/login")
    public RequestResponseDto<?> login(@RequestBody RequestLoginUserDto dto) {
        return userService.login(dto);
    }

    @Operation(summary = "Get Token", description = "Access Token 재발급")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/token")
    public RequestResponseDto<?> token(@RequestBody RequestTokenDto dto) {
        return userService.getTokenByRefreshToken(dto);
    }
}
