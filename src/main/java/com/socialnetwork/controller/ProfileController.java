package com.socialnetwork.controller;

import com.socialnetwork.models.Profile;
import com.socialnetwork.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/profile")
    Profile createProfile(@RequestBody Profile profile) throws URISyntaxException {
        Profile result = profileRepository.save(profile);
        return result;
    }

    @PutMapping("/update-profile")
    ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) throws URISyntaxException {
        Profile result = profileRepository.save(profile);
        return ResponseEntity.created(new URI("/api/profile" + result.getId())).body(result);
    }

//    @GetMapping("/myprofile")
//    Profile getProfile(){
//        List<Profile> profile = profileRepository.findAll();
//        return (Profile) profile;

    @GetMapping("/myprofile")
    Profile getProfile(){
        Profile profile = profileRepository.findByFirstName(getProfile().getFirstName());
        return profile;
    }

}
