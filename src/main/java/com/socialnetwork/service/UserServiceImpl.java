package com.socialnetwork.service;

import com.socialnetwork.exception.ResourceNotFoundException;
import com.socialnetwork.models.User;
import com.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String insertUser(User user) throws Exception {
        boolean flag;

        flag=alreadyRegistered(user.getEmail());
        if(flag!=true) {
            user.getProfile().setUser(user);
            userRepository.save(user);
//            return jwtTokenProvider.createToken(user.getEmail(), user.getRoles());
            return String.format("%s ", user);
        }
        else
        {
            throw new Exception("User is already registered");
//            throw new CustomException("User is already registered", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @Override
    public String fetchUserToken(String email) throws ResourceNotFoundException {
        User user;
        boolean flag;
        flag=alreadyRegistered(email);
        if(flag) {
            user=getUser(email);
//            return jwtTokenProvider.createToken(user.getEmail(), user.getRoles());
            return String.format("%s", user);
        }
        else{
            throw new ResourceNotFoundException("User is not registered");
        }


    }

    public User getUser(String email) {

        User user;
        user= userRepository.findByEmail(email);
        return user;
    }

    @Override
    public boolean alreadyRegistered(String email){
        return userRepository.existsByEmail(email);
    }
}
