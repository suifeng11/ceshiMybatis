package com.yuji.testmybatis.dao;

import com.yuji.testmybatis.beans.SysParameter;
import com.yuji.testmybatis.beans.SysParameterType;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysParameterTypeDaoMapper {
 
    List<SysParameter> findByType(SysParameterType type);
    
    public SysParameterType findTypeById(int id);
    
    public int  addOneNewType(SysParameterType t);
    
    
 
}
