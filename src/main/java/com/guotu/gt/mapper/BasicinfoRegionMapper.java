package com.guotu.gt.mapper;

import com.guotu.gt.domain.BasicinfoRegion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicinfoRegionMapper {

    /**
     * 根据地区编码进行查询
     * @param code
     * @return
     */
    BasicinfoRegion findByCode(int code);

    /**
     * 根据地区等级查询
     * @param level
     * @return
     */
    List<BasicinfoRegion> findByLevel(int level);

    /**
     * 根据上级地区查询
     * @param parentId
     * @return
     */
    List<BasicinfoRegion> findByParent(int parentId);

    /**
     * 查询所有地区
     * @return
     */
    List<BasicinfoRegion> findAll();
}
