package com.herbalmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tavis
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAllinfo {
    private String username;
    private String password;
    private Integer age;
    private String email;
    private String phoneNumber;
}
