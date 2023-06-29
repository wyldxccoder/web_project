package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
 @Select("select *from tlias.emp ")
   public List<Emp> list1 (String name, Short gender, LocalDate begin, LocalDate end);
//    @Select("select count(*) from tlias.emp")
//        public Long count();
//@Select("select *from tlias.emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);



}
