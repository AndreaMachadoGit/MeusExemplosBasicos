package com.challenge.controller;

import com.challenge.entity.User;
import com.challenge.exceptions.ResourceNotFoundException;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<User>(this.userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User")),HttpStatus.OK);
    }

    @GetMapping(params = "companyId")
    public List<User> findByCompanyId(@RequestParam Long companyId) {
        return this.userService.findByCompanyId(companyId);
    }

    @GetMapping(params="accelerationName")
    public List<User> findByAccelerationName(@RequestParam String accelerationName) {
        return this.userService.findByAccelerationName(accelerationName);
    }

    @GetMapping
    public Iterable<User> findAll(@PathParam("nickname") String nickname, Pageable pageable) {
        if (nickname != null) {
            return this.userService.findByNome(nickname.toString(), pageable);
        }
        return this.userService.findAll(pageable);
    }

}
