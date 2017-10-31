package com.bjut.MB.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/10/31.
 */
@Mapper
public interface OrderDao {
    public int addOrder(String orderNum,String process);
}
