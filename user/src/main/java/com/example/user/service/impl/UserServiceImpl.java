package com.example.user.service.impl;

import com.example.user.config.JwtProvider;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
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
