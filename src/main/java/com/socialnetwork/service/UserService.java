package com.socialnetwork.service;

import com.socialnetwork.exception.ResourceNotFoundException;
import com.socialnetwork.models.User;
//import java.util.Optional;

public interface UserService {

    String insertUser(User user) throws Exception;
    String fetchUserToken(String user) throws ResourceNotFoundException;
    boolean alreadyRegistered(String email);
}
