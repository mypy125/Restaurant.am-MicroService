package com.mygitgor.userservice.service.impl;

import com.mygitgor.userservice.config.JwtProvider;
import com.mygitgor.userservice.entity.User;
import com.mygitgor.userservice.repository.UserRepository;
import com.mygitgor.userservice.service.UserService;
import com.example.util.execution_time.TrackExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;


    @Override
    @TrackExecutionTime
    public User findUserByJwtToken(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        return findUserByEmail(email);
    }

    @Override
    @TrackExecutionTime
    public User findUserByEmail(String email) throws Exception {
       User user = userRepository.findByEmail(email);
       if(user == null){
           throw new UserPrincipalNotFoundException("user not found");
       }
       return user;
    }
}
