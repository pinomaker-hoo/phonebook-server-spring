package pinomaker.phonebook.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pinomaker.phonebook.common.dto.RequestResponseDto;
import pinomaker.phonebook.dto.RequestSavePhoneDto;
import pinomaker.phonebook.service.PhoneService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/phone")
@Tag(name = "Phone Api", description = "전화번호부 관련 API")
public class PhoneController {
    private final PhoneService phoneService;

    @Operation(summary = "Save Phone", description = "전화번호 저장")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping
    public RequestResponseDto<?> save(@RequestBody RequestSavePhoneDto dto) {
        return phoneService.save(dto);
    }

    @Operation(summary = "Find All Phone list", description = "전화번호 전체 조회")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping
    public RequestResponseDto<?> findAll() {
        return phoneService.findAll();
    }

    @Operation(summary = "Find Phone By Idx", description = "전화번호 단일 조회")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/{idx}")
    public RequestResponseDto<?> findOne(@PathVariable(name = "idx") Long idx ) {
        return phoneService.findOne(idx);
    }

    @Operation(summary = "Delete Phone", description = "전화번호 삭제")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/{idx}")
    public RequestResponseDto<?> delete(@PathVariable(name = "idx") Long idx ) {
        return phoneService.delete(idx);
    }

    @Operation(summary = "Update Phone", description = "전화번호 수정")
    @ApiResponse(responseCode = "400", description = "Parameter type is incorrect")
    @ApiResponse(responseCode = "401", description = "Bad Credentials, JWT token expires")
    @ApiResponse(responseCode = "401", description = "Access denied")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PutMapping("/{idx}")
    public RequestResponseDto<?> update(@PathVariable(name = "idx") Long idx, @RequestBody RequestSavePhoneDto dto) {
        return phoneService.update(idx, dto);
    }
}
