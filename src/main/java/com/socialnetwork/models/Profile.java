package com.socialnetwork.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "profile_table")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String about;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 11)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private Boolean gender;

//    @ElementCollection(fetch = FetchType.EAGER)
////    @Column(nullable = false)
//    private Gender gender;

    @Column(nullable = false, length = 2)
    private Integer age;

    @Column(nullable = false, length = 300)
    private String profilePicUrl;

    @NotNull
    private String location;

    @NotNull
    private String interests;

    @NotNull
    private String languages;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
