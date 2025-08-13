package com.example.E_Note.DTO;

import com.example.E_Note.Entity.Role;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastname;
    private String emails;
    private String mobNo;
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmails() {
        return emails;
    }

    public String getMobNo() {
        return mobNo;
    }

    public List<Role> getRoles() {
        return roles;
    }

}
