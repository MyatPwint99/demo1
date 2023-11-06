package com.ojt.demo1.web.form;

import lombok.Data;

@Data
public class RegistrationUserForm {
    private String userName;
    private Integer phoneNumber;
//    private int gender;
    private String gender;
//    private boolean married;
    private String married;
    private String city;
}
