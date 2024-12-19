package com.auto.demo.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private String companyName;
    private String city;
    private String address;

}
