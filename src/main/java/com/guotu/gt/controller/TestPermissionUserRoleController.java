package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionUserRole;
import com.guotu.gt.service.TestPermissionUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestPermissionUserRoleController {
    @Autowired
    private TestPermissionUserRoleService testService;

    // Test: Permission User
    @GetMapping("/purselect")
    public String puSelect(@RequestParam String code) {
        return testService.purSelect(code).toString();
    }
    @PutMapping("/purinsert")
    void purInsert(@RequestParam String userCode,
                   @RequestParam Byte roleCode) {
        testService.purInsert(new PermissionUserRole(userCode, roleCode));
    }
    @PostMapping("/purupdate")
    void purUpdate(@RequestParam String userCode,
                   @RequestParam Byte roleCode) {
        testService.purUpdate(new PermissionUserRole(userCode, roleCode));
    }
    @DeleteMapping("/purdelete")
    void purDelete(@RequestParam String userCode) {
        testService.purDelete(userCode);
    }
}
