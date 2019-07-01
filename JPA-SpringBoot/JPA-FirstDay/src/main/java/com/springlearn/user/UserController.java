package com.springlearn.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/users")
    public List<UserRecord> getAllUserRecord() {
        return service.getAllUserRecord();
    }

    @RequestMapping("/users/{id}")
    public UserRecord getUserRecordById(@PathVariable int id) {
        return service.getUserRecordById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUserRecord(@RequestBody UserRecord userRecord) {
        service.addUserRecord(userRecord);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUserRecord(@PathVariable(name = "id") int id) {
        service.deleteUserRecord(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUserRecord(@RequestBody UserRecord userRecord, @PathVariable int id) {
        service.updateUserRecord(userRecord, id);
    }
}
