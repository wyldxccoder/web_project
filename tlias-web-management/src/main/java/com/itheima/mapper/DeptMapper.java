package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    //查询全部部门数据
    @Select("select * from tlias.dept")
    List<Dept> list();

    //根据id删除部门
    @Delete("delete from tlias.dept where id =#{id}")
    void deletebyid(Integer id);

    //新增部门
    @Insert("insert into tlias.dept ( name, create_time, update_time)values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    //根据id查询部门数据
    @Select(" select * from tlias.dept where id=#{id}")
    List<Dept> selectbyid(Integer id);

    //根据id修改部门信息
    @Update("update tlias.dept set name=#{name},create_time=#{createTime},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
