package com.yuji.testmybatis.servlet;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yuji.testmybatis.beans.sysPara.SysParameter;
import com.yuji.testmybatis.beans.sysPara.SysParameterType;
import com.yuji.testmybatis.service.IService;
import com.yuji.testmybatis.utility.RedisUtil;

//@Controller
//@RequestMapping("/test")
public class TestController {

   // @Resource(name = "ServiceImpl")
    private IService ser;

    @Resource(name = "RedisUtil")
   private RedisUtil redisUtil;
    
    @ResponseBody
    @RequestMapping(value = "/savetest1")
    public String testsave1(HttpServletRequest request) throws Exception {
    	SysParameterType t = new SysParameterType();
    	t.setTypeName("tname"+new Date().getTime());
    	t.setTypeDescribe("tdes"+new Date().getTime());
    	System.out.println("new id:"+ser.addOneNewType(t));
    	   
    	System.out.println("---------------------------------------------");
    	System.out.println("---------------------------------------------");
    	System.out.println("---------------------------------------------");
    	System.out.println("---------------------------------------------");
    	SysParameterType type = new SysParameterType();
    	type.setId(1);
    	List<SysParameter> re = ser.findByType(type);
    	System.out.println("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        for(int i=0;i<re.size();i++)
        {
        	//System.out.println(re.get(i).getPdescribe());
            System.out.println(re.get(i).getPdescribe()+"    "+re.get(i).getPaType().getTypeName());
            
            System.out.println(re.get(i).getPdescribe()+"    "+re.get(i).getPaType().getTypeDescribe());
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/savetest")
    public String testsave(HttpServletRequest request) throws Exception {

      // return  ser.save1(1111,"des","key","pname","ptype","pvaluee");

        List<SysParameter> re = ser.findAllpa();
        for(int i=0;i<re.size();i++)
        {
            System.out.println(re.get(i).getPdescribe());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        SysParameter s = ser.findOneById(4);
        System.out.println(s.getPdescribe()+s.getPname()+s.getId());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        List<SysParameter> ree = ser.findAllWithType();
        for(int i=0;i<ree.size();i++)
        {
            System.out.println(ree.get(i).getPdescribe()+ree.get(i).getPaType().getTypeName());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        SysParameter r = ser.checkPaIsExist(ree.get(1));
        if(r==null)
        {
        	System.out.println("checkPaIsExist==null");
        }
        else
        {
        	System.out.println("checkPaIsExist:true"+r.getId()+r.getPdescribe());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        List<SysParameter> ree1 = ser.findByPanme("er");
        for(int i=0;i<ree1.size();i++)
        {
            System.out.println(ree1.get(i).getPname()+"  "+ree1.get(i).getPdescribe()+ree1.get(i).getPaType().getTypeName());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        List<SysParameter> dr = ser.findByDynamic(ree1.get(1));
        for(int i=0;i<dr.size();i++)
        {
            System.out.println(dr.get(i).getPname());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        
        
       // redisUtil.set("haha", "hahahhahahahahahahah");
       //return  redisUtil.get("haha").toString();
        
        return "success";

 
    }
    
    @ResponseBody
    @RequestMapping(value = "/savetest3")
    public void savetest3(HttpServletRequest request) throws Exception {
    	
		
		/*
		 * List<SysParameter> re = ser.findAllpa(); for(int i=0;i<re.size();i++) {
		 * System.out.println(re.get(i).getPdescribe()); }
		 */
		 
		 
    	// -------------------------------------------------------------------------------------
		
		  List<SysParameterType> re = ser.findAllTypes(); 
		  for(int i=0;i<re.size();i++)
		  { 
		  		Gson g = new Gson(); 
		  		System.out.println(g.toJson(re.get(i))); 
		  }
		 
    }
}
