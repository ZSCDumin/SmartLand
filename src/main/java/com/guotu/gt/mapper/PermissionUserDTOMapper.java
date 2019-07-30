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
    PermissionUserDTO add(PermissionUserDTO permissionUserDTO);

    /**
     * 更新一个用户信息
     * @param permissionUserDTO
     * @return
     */
    void update(PermissionUserDTO permissionUserDTO);

    /**
     * 根据name删除一个用户信息
     * @param name
     */
    void delete(String name);

    /**
     * 查询所有用户信息
     * @return
     */
    List<PermissionUserDTO> findAll();
}
