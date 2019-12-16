package com.yuji.testmybatis.service;

import com.yuji.testmybatis.beans.SysParameter;

import java.util.List;

public interface IService {

    //public boolean save1(int id,  String pdescribe,String pkey,String pname,String ptype,String pvalue);

    public List<SysParameter> findAllpa();

    public SysParameter findOneById(int id);

    public List<SysParameter> findAllWithType();
    
    public SysParameter checkPaIsExist(SysParameter pa);
    
    public List<SysParameter> findByPanme(String paname);
}
