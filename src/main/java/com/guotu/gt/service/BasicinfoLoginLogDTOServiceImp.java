package com.guotu.gt.service;

import com.guotu.gt.dto.BasicinfoLoginLogDTO;
import com.guotu.gt.mapper.BasicinfoLoginLogDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BasicinfoLoginLogDTOServiceImp implements BasicinfoLoginLogDTOService {

    @Autowired
    private BasicinfoLoginLogDTOMapper basicinfoLoginLogDTOMapper;

    @Override
    public void delete(Byte code){
        basicinfoLoginLogDTOMapper.delete(code);
    }

    @Override
    public List<BasicinfoLoginLogDTO> search(Date start, Date end){
        return basicinfoLoginLogDTOMapper.search(start,end);
    }

    @Override
    public List<BasicinfoLoginLogDTO> open(){
        return basicinfoLoginLogDTOMapper.open();
    }
}
