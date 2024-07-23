package com.murilobarbosa.java.springboot.essentials.application.controller.v1;

import com.murilobarbosa.java.springboot.essentials.application.dto.request.SearchUserAccountRequestDto;
import com.murilobarbosa.java.springboot.essentials.application.dto.request.UserAccountRequestDto;
import com.murilobarbosa.java.springboot.essentials.application.dto.response.SearchResultResponseDto;
import com.murilobarbosa.java.springboot.essentials.application.dto.response.UserAccountResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "User Account")
@RequestMapping(UserAccountController.BASE_URL)
public interface UserAccountController {

    String BASE_URL = "/v1/user-account";

    @PostMapping
    @Operation(summary = "Create user account", description = """
          # Create user account
          ---
          Create a new user account.
          """)
    @ApiResponse(responseCode = "201", description = "User account created")
    ResponseEntity<UserAccountResponseDto> create(
          @RequestBody @Valid UserAccountRequestDto userAccountRequestDto);

    @GetMapping
    @Operation(summary = "Get user accounts", description = """
          # Get user account.
          ---
          Get user account based on params
          """)
    @ApiResponse(responseCode = "200", description = "User account found")
    ResponseEntity<SearchResultResponseDto<UserAccountResponseDto>> get(
          @ParameterObject @Valid SearchUserAccountRequestDto searchUserAccountDto,
          @ParameterObject Pageable pageable);
}
