package com.yuji.testmybatis.servlet;

import com.yuji.testmybatis.beans.SysParameter;
import com.yuji.testmybatis.service.IService;
import com.yuji.testmybatis.utility.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestController {

    @Resource(name = "ServiceImpl")
    private IService ser;

    @Resource(name = "RedisUtil")
   private RedisUtil redisUtil;

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
        redisUtil.set("haha", "hahahhahahahahahahah");
       return  redisUtil.get("haha").toString();






    }
}
