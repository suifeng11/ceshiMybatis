package com.yuji.testmybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuji.testmybatis.beans.sysPara.SysParameter;
import com.yuji.testmybatis.beans.sysPara.SysParameterType;
import com.yuji.testmybatis.dao.sysPara.SysParameterDaoMapper;
import com.yuji.testmybatis.dao.sysPara.SysParameterTypeDaoMapper;

//@Service("ServiceImpl")
public class ServiceImpl implements IService{

    @Autowired
    private SysParameterDaoMapper smapper;
    
    @Autowired
    private SysParameterTypeDaoMapper tmapper;

    /*@Override
    public boolean save1(int id,  String pdescribe,String pkey,String pname,String ptype,String pvalue)
    {

        *//*if(smapper.findPaById(id)==null)
        {
            smapper.insertPa(pdescribe, pkey, pname, ptype, pvalue);
            return true;
        }
        else {
            System.out.println("findPaById:"+smapper.findPaById(id).getPkey());
            return false;
        }*//*
        return true;
    }*/

    @Override
    public List<SysParameter> findAllpa() {

        return smapper.findAll2(1,"ss");

    }

    @Override
    public SysParameter findOneById(int id) {
        return smapper.findPaById(id);
    }

    @Override
    public List<SysParameter> findAllWithType() {
        return smapper.findAllWithType();
    }

	@Override
	public SysParameter checkPaIsExist(SysParameter pa) {
		// TODO Auto-generated method stub
		return smapper.checkPaIsExist(pa);
	}

	@Override
	public List<SysParameter> findByPanme(String paname) {
		// TODO Auto-generated method stub
		return smapper.findByPanme(paname);
	}

	@Override
	public List<SysParameter> findByDynamic(SysParameter pa) {
		// TODO Auto-generated method stub
		return smapper.findByDynamic(pa);
	}

	@Override
	public List<SysParameter> findByType(SysParameterType type) {
		// TODO Auto-generated method stub
		return tmapper.findByType(type);
	}

	@Override
	public int addOneNewType(SysParameterType type) {
		// TODO Auto-generated method stub
		 tmapper.addOneNewType(type);
		 /*double i = 1/0;
		 tmapper.addOneNewType(type);*/
		 return type.getId();
	}

	@Override
	public List<SysParameterType> findAllTypes() {
		// TODO Auto-generated method stub
		return tmapper.findAllTypes();
	}
    
    
}
