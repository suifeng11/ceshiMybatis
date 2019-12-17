package com.yuji.testmybatis.dao;

import com.yuji.testmybatis.beans.SysParameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysParameterDaoMapper {

    SysParameter findPaById(int paid);

    List<SysParameter> findAll();

    List<SysParameter> findAll2(int i,String s);

    List<SysParameter> findAllWithType();
    
    SysParameter checkPaIsExist(SysParameter pa);
    
    List<SysParameter> findByPanme(String pname);
    
    List<SysParameter> findByDynamic(SysParameter pa);

    //暂未实现
    boolean insertPa(String pdescribe,String pkey,String pname,String ptype,String pvalue); 
}
