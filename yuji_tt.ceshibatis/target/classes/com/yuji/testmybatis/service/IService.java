package com.yuji.testmybatis.service;

import com.yuji.testmybatis.beans.SysParameter;
import com.yuji.testmybatis.beans.SysParameterType;

import java.util.List;

public interface IService {

    //public boolean save1(int id,  String pdescribe,String pkey,String pname,String ptype,String pvalue);

    public List<SysParameter> findAllpa();

    public SysParameter findOneById(int id);

    public List<SysParameter> findAllWithType();
    
    public SysParameter checkPaIsExist(SysParameter pa);
    
    public List<SysParameter> findByPanme(String paname);
    
    public List<SysParameter> findByDynamic(SysParameter pa);
    
    public List<SysParameter> findByType(SysParameterType type);
    
    public int addOneNewType(SysParameterType type);
    
    public List<SysParameterType> findAllTypes();
}
