package com.guotu.gt.mapper;

import com.guotu.gt.domain.PermissionUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PermissionUserMapper {

    /**
     * 根据编码更新
     * @param code 编码
     * @return 用户信息
     */
    PermissionUser selectByCode(String code);

    /**
     * 插入用户信息
     * @param permissionUser 用户信息
     */
    void insert(PermissionUser permissionUser);

    /**
     * 根据编码更新
     * @param permissionUser 用户信息
     */
    void updateByCode(PermissionUser permissionUser);

    /**
     * 根据编码删除
     * @param code 编码
     */
    void deleteByCode(String code);

}
