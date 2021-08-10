package com.dpanda.stickynotes.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false, unique = true)

    private String email;

    @Column(nullable = false)
    private Date created;

    @OneToMany(targetEntity=Note.class, mappedBy="user",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @Getter(AccessLevel.NONE)
    private List<Note> notes = new ArrayList<Note>();

    public User(String firstName, String lastName, Date dob, String email, Date created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.created = created;
    }

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }
}
