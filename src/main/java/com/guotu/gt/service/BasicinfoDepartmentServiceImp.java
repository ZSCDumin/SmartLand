package com.guotu.gt.service;

import com.guotu.gt.domain.BasicinfoDepartment;
import com.guotu.gt.mapper.BasicinfoDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicinfoDepartmentServiceImp implements BasicinfoDepartmentService {
    @Autowired
    private BasicinfoDepartmentMapper basicinfoDepartmentMapper;

    @Override
    public BasicinfoDepartment add(BasicinfoDepartment basicinfoDepartment){
        return basicinfoDepartmentMapper.add(basicinfoDepartment);
    }

    @Override
    public BasicinfoDepartment update(BasicinfoDepartment basicinfoDepartment){
        return basicinfoDepartmentMapper.update(basicinfoDepartment);
    }

    @Override
    public void delete(String code){
        basicinfoDepartmentMapper.delete(code);
    }

    @Override
    public BasicinfoDepartment findByCode(String code){
        return basicinfoDepartmentMapper.findByCode(code);
    }

    @Override
    public List<BasicinfoDepartment> findAll(){
        return basicinfoDepartmentMapper.findAll();
    }
}
