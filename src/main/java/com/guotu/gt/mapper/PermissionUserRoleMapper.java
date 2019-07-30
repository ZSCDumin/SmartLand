package com.guotu.gt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 用户角色接口
 *
 * @author YalandHong
 */

@Mapper
@Component
public interface PermissionUserRoleMapper {

    /**
     * 将指定角色的用户替换为另一种用户编码
     * @param oldRoleCode 旧角色
     * @param newRoleCode 新角色
     */
    void updateRoleCodeToNew(@Param("oldRoleCode") Integer oldRoleCode, @Param("newRoleCode") Integer newRoleCode);
}
