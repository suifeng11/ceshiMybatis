package com.yuji.testmybatis.dao.sysPara;

import org.apache.ibatis.annotations.Mapper;

import com.yuji.testmybatis.beans.sysPara.SysParameter;

import java.util.List;
 
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
