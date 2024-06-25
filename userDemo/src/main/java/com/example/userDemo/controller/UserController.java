package com.example.userDemo.controller;

import com.example.userDemo.model.request.UserRequest;
import com.example.userDemo.model.response.CustomResponse;
import com.example.userDemo.model.response.EntityResponse;
import com.example.userDemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/apiUser")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/saveOrUpdateUser")
    public ResponseEntity<?>saveOrUpdateUser(@Valid @RequestBody UserRequest userRequest){
        try{
            return new ResponseEntity(new EntityResponse(iUserService.saveOrUpdateUser(userRequest),0), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }
    @GetMapping("/getAllUser")
    private ResponseEntity<?>getAllUser(){
        try{
            return new ResponseEntity(new EntityResponse(iUserService.getAllUser(),0),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }

    @GetMapping("/getSeraching")
    private ResponseEntity<?>getSearching(@RequestParam(required = false)String email,
                                          @RequestParam(required = false)String name,
                                          @RequestParam(required = false)String zipCode){
        try{
            return new ResponseEntity(new EntityResponse(iUserService.getSearching(email,name,zipCode),0),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity(new CustomResponse(e.getMessage(),-1),HttpStatus.OK);
        }
    }

}
