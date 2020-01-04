package com.yuji.testmybatis.beans;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
public interface SysParameterMapper {

    @Select("select * from ez_sys_parameter where id = #{id}")
    SysParameter findPaById(int userId);


    @Select("select ez_sys_parameter.*, parameter_type.id tid,parameter_type.type_name " +
            " from ez_sys_parameter inner join parameter_type on ez_sys_parameter.ptype=parameter_type.id" +
            " where parameter_type.id=1 " +
            " and pname like #{pname}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "pkey", column = "pkey"),
            @Result(property = "pname", column = "pname"),
            @Result(property = "pvalue", column = "pvalue"),
            @Result(property = "paType.id", column = "tid"),
            @Result(property = "paType.typeName", column = "type_name")
    })
    List<SysParameter> findAll(String pname);

    @Insert("insert into ez_sys_parameter (pdescribe,pkey,pname,ptype,pvalue) values (#{pdescribe},#{pkey},#{pname},#{ptype},#{pvalue})")
    boolean insertPa(String pdescribe,String pkey,String pname,String ptype,String pvalue);

}
