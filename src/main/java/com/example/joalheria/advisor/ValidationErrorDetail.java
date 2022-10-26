package com.example.joalheria.advisor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidationErrorDetail {
    private String field;
    private String message;
    private String rejectedValue;
}

