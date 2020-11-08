package com.socialnetwork.repository;

import com.socialnetwork.dto.PostDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<PostDto> findByUserProfileId(Long userProfId){

        List<PostDto> resultList= new ArrayList<>();
        Query query = entityManager.createNativeQuery("select p.id,p.title," +
                "p.description,p.content,u.id as userId,u.profile_Pic_Url " +
                "from posts p,userprofile u where p.user_prof_id=u.id and p.user_prof_id=?","findAllDataMapping");
        query.setParameter(1, userProfId );
        resultList=query.getResultList();
        return resultList;




    }

}
