package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionUser;
import com.guotu.gt.service.TestPermissionUserService;
import com.guotu.gt.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestPermissionUserController {
    @Autowired
    private TestPermissionUserService testService;

    // Test: Permission User
    @GetMapping("/puselect")
    public String puSelect(@RequestParam String code) {
        return testService.puSelect(code).toString();
    }
    @PutMapping("/puinsert")
    public void puInsert(@RequestParam String code,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String sex,
                         @RequestParam(required = false) String departmentCode,
                         @RequestParam(required = false) String password,
                         @RequestParam(required = false) String contact,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String description,
                         @RequestParam Byte enable) {
        testService.puInsert(new PermissionUser(code, name, sex, departmentCode, password,
                contact, email, description, enable));
    }
    @PostMapping("/puupdate")
    public void puUpdate(@RequestParam String code,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String sex,
                         @RequestParam(required = false) String departmentCode,
                         @RequestParam(required = false) String password,
                         @RequestParam(required = false) String contact,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String description,
                         @RequestParam Byte enable) {
        testService.puUpdate(new PermissionUser(code, name, sex, departmentCode, password,
                contact, email, description, enable));
    }
    @DeleteMapping("/pudelete")
    public void puDelete(@RequestParam String code) {
        testService.puDelete(code);
    }
    
}
