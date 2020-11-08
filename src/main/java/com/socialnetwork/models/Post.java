package com.socialnetwork.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

//@SqlResultSetMapping(
//        name = "findAllDataMapping",
//        classes = @ConstructorResult(
//                targetClass = com.steplabs.backend.vidtalk.dto.PostDto.class,
//                columns = {
//                        @ColumnResult(name = "id",type=Long.class),
//                        @ColumnResult(name = "title",type= String.class),
//                        @ColumnResult(name = "description",type=String.class),
//                        @ColumnResult(name = "content",type=String.class),
//                        @ColumnResult(name = "userId",type=Long.class),
//                        @ColumnResult(name = "profile_Pic_Url",type=String.class)
//                }
//        )
//)

@EqualsAndHashCode  // What is this one and what does it do?
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "posts")
public class Post extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, length = 50, unique = true)
    private String title;

    @NotNull
    @Lob
    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "comment_id")
    private List<Comment> comments;

}
