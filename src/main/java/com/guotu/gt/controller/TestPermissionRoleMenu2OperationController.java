package com.guotu.gt.controller;

import com.guotu.gt.domain.PermissionRoleMenu2Operation;
import com.guotu.gt.service.TestPermissionRoleMenu2OperationMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestPermissionRoleMenu2OperationController {

    // Test: PermissionRoleMenu2Operation
    @Autowired
    private TestPermissionRoleMenu2OperationMapperService testService;

    @GetMapping("/prmoselect")
    public String prmoSelect(@RequestParam Byte roleCode) {
        return testService.prmoSelect(roleCode).toString();
    }
    @PutMapping("/prmoinsert")
    public void prmoInsert(@RequestParam Byte roleCode,
                    @RequestParam Byte menu2Code,
                    @RequestParam Byte operationCode) {
        testService.prmoInsert(new PermissionRoleMenu2Operation(roleCode, menu2Code, operationCode));
    }
    @PostMapping("/prmoupdate")
    public void prmoUpdate(@RequestParam Byte roleCode,
                    @RequestParam Byte menu2Code,
                    @RequestParam Byte operationCode) {
        testService.prmoUpdate(new PermissionRoleMenu2Operation(roleCode, menu2Code, operationCode));
    }
    @DeleteMapping("/prmodelete")
    public void prmoDelete(@RequestParam Byte code) {
        testService.prmoDelete(code);
    }
}
