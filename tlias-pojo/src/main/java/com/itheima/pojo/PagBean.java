package com.itheima.pojo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//分页查询结果封装类
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagBean {
    private Long total;//总记录数
    private List rwos;//数据列表
}
