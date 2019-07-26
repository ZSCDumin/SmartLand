package com.guotu.gt.service;

import com.guotu.gt.dto.PermissionRoleDTO;
import com.guotu.gt.mapper.PermissionRoleMapper;
import com.guotu.gt.mapper.PermissionUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 角色管理界面 - 服务层实现
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

    /**
     * 根据角色编码更新角色信息
     * @param permissionRoleDTO 新的角色信息
     *
     *
     */
    @Override
    public void updateByCode(PermissionRoleDTO permissionRoleDTO) {

        //判断名字是否为空  okay
        Assert.notNull(permissionRoleDTO.getName(), "角色名不能为空");
        Assert.isTrue(!permissionRoleDTO.getName().trim().isEmpty(), "角色名不能为空白");

        //判断角色编码是否存在  okay
        Assert.notNull(permissionRoleMapper.selectByCode(permissionRoleDTO.getCode()),
                String.format("编码为%d的角色不存在", permissionRoleDTO.getCode()));

        //重名判断：要求 不存在同名角色 或者 同名角色是自己  okay
        PermissionRoleDTO checkRole = permissionRoleMapper.selectByName(permissionRoleDTO.getName());
        Assert.isTrue((checkRole == null) || (checkRole.getCode().equals(permissionRoleDTO.getCode())),
                "已存在一个名为\"" + permissionRoleDTO.getName() + "\"的角色已存在");

        //系统角色判断  okay
        Assert.isTrue(!permissionRoleMapper.selectFlagByCode(permissionRoleDTO.getCode()).equals(SYSTEM_ROLE_FLAG),
                "不能修改系统角色");

        permissionRoleMapper.updateByCode(permissionRoleDTO);
    }

    /**
     * 新增角色信息
     * @param name 角色名
     * @param description 角色描述
     */
    @Override
    public PermissionRoleDTO insert(String name, String description) {

        // 判断名字是否为空  okay：controller使用RequestParam，保证了角色名不能为空白
        //Assert.notNull(name, "角色名不能为空");
        //Assert.isTrue(!name.trim().isEmpty(), "角色名不能为空白");

        // 判断是否重名  okay
        Assert.isNull(permissionRoleMapper.selectByName(name), "已存在一个名为\"" + name + "\"的角色");

        // TODO 生成编码
        Byte code = 123;



        PermissionRoleDTO permissionRoleDTO = new PermissionRoleDTO(code, name, description);
        permissionRoleMapper.insert(permissionRoleDTO);
        return permissionRoleDTO;
    }

    @Override
    public void deleteByCode(Byte code) {
        Byte flag = permissionRoleMapper.selectFlagByCode(code);

        // 判断角色编码是否存在  okay
        Assert.notNull(flag, String.format("编码为%d的角色不存在", code));

        // 判断是否为系统角色 okay
        Assert.isTrue(!flag.equals(SYSTEM_ROLE_FLAG), "不能删除系统角色");

        // 清除关联用户角色  okay
        permissionUserRoleMapper.updateRoleCodeToNew(code, SYSTEM_ROLE_NORMAL_USER_CODE);

        permissionRoleMapper.deleteByCode(code);
    }


    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    @Autowired
    PermissionUserRoleMapper permissionUserRoleMapper;

    // 定义： 系统角色 标志位为0
    private static final Byte SYSTEM_ROLE_FLAG = 0;

    // 定义：系统管理员 编码为0
    private static final Byte SYSTEM_ROLE_SYSTEM_MANAGER_CODE = 0;

    // 定义：普通用户 编码为1
    private static final Byte SYSTEM_ROLE_NORMAL_USER_CODE = 1;
}
