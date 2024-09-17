package com.houser.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SQLInfo {
    private String username;
    private String url;
    private String password;
}
