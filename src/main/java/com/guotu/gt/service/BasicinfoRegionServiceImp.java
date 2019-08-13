package com.guotu.gt.service;

import com.guotu.gt.domain.BasicinfoRegion;
import com.guotu.gt.mapper.BasicinfoRegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicinfoRegionServiceImp implements BasicinfoRegionService {

    @Autowired
    BasicinfoRegionMapper basicinfoRegionMapper;

    @Override
    public BasicinfoRegion findByCode(int code){
        return basicinfoRegionMapper.findByCode(code);
    }

    @Override
    public List<BasicinfoRegion> findByLevel(int level){
        return basicinfoRegionMapper.findByLevel(level);
    }

    @Override
    public List<BasicinfoRegion> findByParent(int parentId){
        return basicinfoRegionMapper.findByParent(parentId);
    }

    @Override
    public List<BasicinfoRegion> findAll(){
        return basicinfoRegionMapper.findAll();
    }
}
