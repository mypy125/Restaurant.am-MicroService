package com.mygitgor.userservice.service;

import com.mygitgor.userservice.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserByJwtToken(String jwt)throws Exception;
    User findUserByEmail(String email)throws Exception;

}
