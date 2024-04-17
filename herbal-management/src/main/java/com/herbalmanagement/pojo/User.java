package com.herbalmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}