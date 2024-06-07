package com.example.MiniProjectEmployeeManagementSystem.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "User First Name")
    @NotEmpty(message = "FirstName cannot be Empty")
    @Column(nullable = false, unique = true)
    private String name;
    @Schema(description = "User Last Name")
    @NotEmpty(message = "LastName cannot be Empty")
    @Column(nullable = false, unique = true)
    private String username;
    @Schema(description = "UserName")
    @NotEmpty(message = "UserName cannot be Empty")
    @Column(nullable = false, unique = true)
    private String email;
    @Schema(description = "User Email")
    @NotEmpty(message = "Email cannot be Empty")
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="users_roles",
   joinColumns  =@JoinColumn(name="user_id",referencedColumnName ="id"),
    inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName ="id"))


    private Set<Role> roles;
}