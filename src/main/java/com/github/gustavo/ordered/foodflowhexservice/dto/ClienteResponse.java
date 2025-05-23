package com.github.gustavo.ordered.foodflowhexservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

}
