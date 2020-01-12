package com.yuji.testmybatis.dao.sysPara;

import org.apache.ibatis.annotations.Mapper;

import com.yuji.testmybatis.beans.sysPara.SysParameter;
import com.yuji.testmybatis.beans.sysPara.SysParameterType;

import java.util.List;
 
public interface SysParameterTypeDaoMapper {
 
    List<SysParameter> findByType(SysParameterType type);
    
    public SysParameterType findTypeById(int id);
    
    public int  addOneNewType(SysParameterType t);
    
    public List<SysParameterType> findAllTypes();
 
}
