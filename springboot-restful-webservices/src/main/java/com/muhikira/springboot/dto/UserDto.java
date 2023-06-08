package com.muhikira.springboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Schema(
        description =" UserDTO Model Information "
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    //User firstname should not be empty or null
    @Schema(
            description = " User First Name"
    )
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    //User lastname should not be empty or null
    @Schema(
            description = " User Last Name"
    )
    @NotEmpty(message = "User last name should not be null or  empty")
    private String lastName;
    //User email should not be empty or null
    //Email address should be valid
    @Schema(
            description = " User Email"
    )
    @NotEmpty(message = "User email  should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;
}
