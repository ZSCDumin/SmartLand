package com.guotu.gt.service;

import com.guotu.gt.domain.BasicinfoDepartment;
import com.guotu.gt.dto.BasicinfoDepartmentDTO;
import com.guotu.gt.mapper.BasicinfoDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicinfoDepartmentServiceImp implements BasicinfoDepartmentService {
    @Autowired
    private BasicinfoDepartmentMapper basicinfoDepartmentMapper;

    @Override
    public void add(BasicinfoDepartment basicinfoDepartment){
        basicinfoDepartmentMapper.add(basicinfoDepartment);
    }

    @Override
    public void update(BasicinfoDepartment basicinfoDepartment){
        basicinfoDepartmentMapper.update(basicinfoDepartment);
    }

    @Override
    public void delete(int code){
        basicinfoDepartmentMapper.delete(code);
    }

    @Override
    public BasicinfoDepartmentDTO findByCode(int code){
        return basicinfoDepartmentMapper.findByCode(code);
    }

    @Override
    public List<BasicinfoDepartmentDTO> findAll(){
        return basicinfoDepartmentMapper.findAll();
    }

    @Override
    public List<BasicinfoDepartment> findByParent(int parentCode){
        return basicinfoDepartmentMapper.findByParent(parentCode);
    }
}
