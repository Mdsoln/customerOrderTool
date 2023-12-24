package com.customerordersystem.exc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalExceptionFields {
    private String message;
    private Throwable cause;
    private HttpStatus httpStatus;
}
