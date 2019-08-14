package com.guotu.gt.mapper;

import com.guotu.gt.dto.PermissionUserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionUserDTOMapper {

    /**
     * 增加一个用户信息
     * @param permissionUserDTO
     * @return
     */
    void add(PermissionUserDTO permissionUserDTO);

    /**
     * 更新一个用户信息
     * @param permissionUserDTO
     * @return
     */
    void update(PermissionUserDTO permissionUserDTO);

    /**
     * 根据code删除一个用户信息
     * @param code
     */
    void delete(int code);

    /**
     * 查询所有用户信息
     * @return
     */
    List<PermissionUserDTO> findAll();

    /**
     * 根据用户名查找用户信息DTO
     * @param name
     * @return
     */
    PermissionUserDTO findByName(String name);

    /**
     * 根据用户编码查找用户信息DTO
     * @param code
     * @return
     */
    PermissionUserDTO findByCode(int code);

    /**
     * 根据所属机构查找
     * @param departmentCode
     * @return
     */
    List<PermissionUserDTO> findByDepartment(int departmentCode);
}
