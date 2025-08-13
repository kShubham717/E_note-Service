package com.example.E_Note.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastname;
    private String emails;
    private String mobNo;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Role> roles;
}
