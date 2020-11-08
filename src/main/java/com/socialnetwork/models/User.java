package com.socialnetwork.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String fcmId; // This is for mobile view users

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    @JsonIgnore
    private Profile profile;

}
