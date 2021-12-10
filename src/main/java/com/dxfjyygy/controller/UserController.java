package com.dxfjyygy.controller;

import com.dxfjyygy.common.result.Result;
import com.dxfjyygy.model.User;
import com.dxfjyygy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping ("/login")
    @ResponseBody
    public Result login(@RequestBody User user){
        User u = new User();
        u.setUsername("aa");
        u.setPassword("bb");
        return Result.ok(u);
    }

//    =======================================================================


    @GetMapping("/userById/{id}")
    @ResponseBody
    public User userById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    @GetMapping("/userList/{username}")
    @ResponseBody
    public List<User> userList(@PathVariable("username") String username){
        User user = new User();
        user.setUsername(username);
        return userService.getUserList(user);
    }

    @GetMapping("/a/{username}")
    @ResponseBody
    public void addUser(@PathVariable("username") String username){
        User user = new User();
        user.setUsername(username);
        userService.addUser(user);
    }

    @PutMapping("/u/{id}/{username}")
    @ResponseBody
    public void updateUser(@PathVariable("id") long id, @PathVariable("username") String username){
        User user = new User();
        user.setUsername(username);
        userService.addUser(user);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable("username") String username){
        User user = new User();
        user.setUsername(username);
        userService.deleteUser(user);
    }


}
