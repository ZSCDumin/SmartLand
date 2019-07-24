package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionRole;
import com.guotu.gt.service.TestPermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestPermissionRoleController {
    @Autowired
    private TestPermissionRoleService testService;

    // Test Permission Role
    @GetMapping("/prselect")
    public String prSelect(@RequestParam Byte code) {
        return testService.prSelect(code).toString();
    }
    @PutMapping("/prinsert")
    public void prInsert(@RequestParam Byte code,
                         @RequestParam String name,
                         @RequestParam(required = false) String description,
                         @RequestParam Byte flag) {
        testService.prInsert(new PermissionRole(code, name, description, flag));
    }
    @PostMapping("/prupdate")
    public void prUpdate(@RequestParam Byte code,
                         @RequestParam String name,
                         @RequestParam(required = false) String description,
                         @RequestParam Byte flag) {
        testService.prUpdate(new PermissionRole(code, name, description, flag));
    }
    @DeleteMapping("/prdelete")
    public void prDelete(@RequestParam Byte code) {
        testService.prDelete(code);
    }
}
