package com.guotu.gt.service;

import com.guotu.gt.domain.PermissionMenu2Operation;
import com.guotu.gt.mapper.PermissionMenu2OperationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionMenu2OperationServiceImp implements PermissionMenu2OperationService {
    @Autowired
    PermissionMenu2OperationMapper permissionMenu2OperationMapper;

    @Override
    public PermissionMenu2Operation add(PermissionMenu2Operation permissionMenu2Operation){
        return permissionMenu2OperationMapper.add(permissionMenu2Operation);
    }

    @Override
    public PermissionMenu2Operation update(PermissionMenu2Operation permissionMeu2){
        return permissionMenu2OperationMapper.update(permissionMeu2);
    }

    @Override
    public void delete(int code){
        permissionMenu2OperationMapper.delete(code);
    }

    @Override
    public PermissionMenu2Operation findByCode(int code){
        return permissionMenu2OperationMapper.findByCode(code);
    }

    @Override
    public List<PermissionMenu2Operation> findAll(){
        return permissionMenu2OperationMapper.findAll();
    }

    /**
     * 判断指定的菜单和操作是否存在
     * @param menu2Code 二级菜单编码
     * @param operationCode 操作编码
     * @return 是否存在
     */
    @Override
    public boolean checkExists(int menu2Code, int operationCode) {
        Integer exists = permissionMenu2OperationMapper.checkExists(
                new PermissionMenu2Operation(menu2Code, operationCode));
        return exists.equals(1);
    }
}
