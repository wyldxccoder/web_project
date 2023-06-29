package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Mapper
public interface EmpMapper {
    //#{}预编译 更高效,更安全  控制台返回?
    //删除数据
    @Delete("delete from emp where id=#{id}")
    public void delete(Integer id);

    //插入数据
    @Options(keyProperty = "id",useGeneratedKeys = true)//获取返回的主键
    @Insert("insert into emp ( username, name, gender, image, job, entrydate, dept_id, create_time, update_time)\n" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    //更新数据
//    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id =#{id} ")
//    public void update(Emp emp);

    //查询数据 实体类属性名和数据库查询返回的字段名一致,mabatis会自动封装
    //实体类属性名和数据库查询返回的字段名不一致,mabatis不会自动封装
    //方案三 #开启mybatis的驼峰命名自动映射开关
    @Select("select * from emp where id=#{id}")
    default Emp getbyid() {
        return getbyid(null);
    }

    //查询数据 实体类属性名和数据库查询返回的字段名一致,mabatis会自动封装
    //实体类属性名和数据库查询返回的字段名不一致,mabatis不会自动封装
    //方案三 #开启mybatis的驼峰命名自动映射开关
    @Select("select * from emp where id=#{id}")
    public Emp getbyid(Integer id);

    //解决方案一  给字段起别名 让别名与实体类保持一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createIime,update_time updateTime from emp where id=#{id}")
//    public Emp getbyid(Integer id);

    //解决方案二 通过@Result注解手动映射封装
//    @Results({
//            @Result(column = "dept_id",property ="deptId"),
//            @Result(column = "create_time",property ="createIime"),
//            @Result(column = "update_time",property ="updateTime")
//    })
//        @Select("select * from emp where id=#{id}")
//    public Emp getbyid(Integer id);

    //条件查询员工   模糊查询需要用${}    使用${}性能低,不安全 存在sql注入问题
//    @Select("select *from emp where name like '%${name}%' and gender=#{gender} " +
//            "and  entrydate between #{begin} and  #{end}  order by update_time desc")
//    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

//注解映射
//    @Select("select *from emp where name like concat('%',#{name},'%') and gender=#{gender} " +
//            "and  entrydate between #{begin} and  #{end}  order by update_time desc")
    //xml映射   动态查询员工  什么条件都没有时候不会什么都查询不到而是 全查询出来
   public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);



    //动态更新数据  没有修改的数据不会是null而是原来数据
    public void update(Emp emp);

    //批量删除员工
    public void deleteByIds(List<Integer> ids);

}
