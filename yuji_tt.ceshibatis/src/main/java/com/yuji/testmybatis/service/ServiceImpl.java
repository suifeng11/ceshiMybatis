package com.yuji.testmybatis.service;

import com.yuji.testmybatis.beans.SysParameter;
import com.yuji.testmybatis.dao.SysParameterDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceImpl")
public class ServiceImpl implements IService{

    @Autowired
    private SysParameterDaoMapper smapper;

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
    
    
}
