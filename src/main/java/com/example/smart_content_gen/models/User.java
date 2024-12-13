package com.example.smart_content_gen.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    private int id;
    private String username;
    private String password;
}
