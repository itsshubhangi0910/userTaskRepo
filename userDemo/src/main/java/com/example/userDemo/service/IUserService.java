package com.example.userDemo.service;

import com.example.userDemo.model.request.UserRequest;

public interface IUserService {
    Object saveOrUpdateUser(UserRequest userRequest) throws Exception;

    Object getAllUser();

    Object getSearching(String email, String name, String zipCode);
}
