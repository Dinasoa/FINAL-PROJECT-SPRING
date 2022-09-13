package com.example.project.model;


import com.example.project.security.model.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false , unique = true)
    private String username;

    @Column(nullable = false)
    private String password ;

    @Column(columnDefinition = "boolean default true")
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Role role;
}
