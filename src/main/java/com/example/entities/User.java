package com.example.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, columnDefinition = "TEXT" )
    private String userName;

    @Column(name = "encrypted_password", nullable = false, columnDefinition = "TEXT")
    private String encryptedPassword;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    //private List<Long> userBlog;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + encryptedPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
