package com.example.userDemo.service.impl;

import com.example.userDemo.model.User;
import com.example.userDemo.model.request.UserRequest;
import com.example.userDemo.repository.UserRepository;
import com.example.userDemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object saveOrUpdateUser(UserRequest userRequest) throws Exception {
        if (userRepository.existsById(userRequest.getUserId())) {
            User user = userRepository.findById(userRequest.getUserId()).get();
            user.setName(userRequest.getName());
            List<Long> userIds=new ArrayList<>();
            userIds.add(userRequest.getUserId());
            if (userRepository.existsByEmailAndUserIdNotIn(userRequest.getEmail(),userIds)) {
                throw new Exception("email already exists");
            } else {
                user.setEmail(userRequest.getEmail());
            }

            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            user.setPassword(userRequest.getPassword());
            user.setState(userRequest.getState());
            user.setZipCode(userRequest.getZipCode());
            userRepository.save(user);
            return "updated";

        }else {
            User user = new User();
            user.setName(userRequest.getName());
            if (userRepository.existsByEmail(userRequest.getEmail())){
                throw new Exception("Email already exist");
            }else {
                user.setEmail(userRequest.getEmail());
            }
            user.setCity(userRequest.getCity());
            user.setCountry(userRequest.getCountry());
            user.setPassword(userRequest.getPassword());
            user.setState(userRequest.getState());
            user.setZipCode(userRequest.getZipCode());
            userRepository.save(user);
            return "save Data";

        }
    }

    @Override
    public Object getAllUser() {
        List<User>users=userRepository.findAll();
        return users;
    }

    @Override
    public Object getSearching(String email, String name, String zipCode) {
        List<User>users;
        if (email!=null){
            users=userRepository.getEmail(email);
        }else if (name!=null){
            users=userRepository.getName(name);
        }else if (zipCode!=null){
            users=userRepository.getZipCode(zipCode);
        }else if (email!=null && name!=null && zipCode!=null) {
            users = userRepository.getAllEmailAndNameAndZipCode(email, name, zipCode);
        }else {

            users=userRepository.findAll();
        }
        return users;

    }
}
