package com.socialnetwork.repository;

import com.socialnetwork.dto.PostDto;

import java.util.List;

public interface PostRepositoryCustom {

    List<PostDto> findByUserProfileId(Long UserProdId);
}
