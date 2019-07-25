package com.guotu.gt.service;

import com.guotu.gt.dto.PermissionRoleDTO;
import com.guotu.gt.mapper.PermissionRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色管理界面 - 服务实现
 *
 * @author YalandHong
 */

@Service
public class PermissionRoleServiceImp implements PermissionRoleService {

    /**
     * 查询所有角色
     * @return 角色信息列表
     */
    @Override
    public List<PermissionRoleDTO> selectAll() {
        return permissionRoleMapper.selectAll();
    }




    @Autowired
    PermissionRoleMapper permissionRoleMapper;
}
