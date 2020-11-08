package com.socialnetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PostDto {

    Long postId;
    String title;
    String description;
    String content;
    Long userProfID;
    String profilePicUrl;

}
