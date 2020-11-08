package com.socialnetwork.repository;

import com.socialnetwork.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findByFirstName(String firstName);

    @Override
    Optional<Profile> findById(Long userId);
}