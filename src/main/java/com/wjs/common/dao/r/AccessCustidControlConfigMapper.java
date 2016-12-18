package com.wjs.common.dao.r;

import com.wjs.common.dao.PageDataList;
import com.wjs.common.dao.o.AccessCustidControlConfig;
import com.wjs.common.dao.o.AccessCustidControlConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessCustidControlConfigMapper {
    /**
     * access_custid_control_config数据表的操作方法: countByExample  
     * 
     */
    int countByExample(AccessCustidControlConfigCriteria example);

    /**
     * access_custid_control_config数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(AccessCustidControlConfigCriteria example);

    /**
     * access_custid_control_config数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * access_custid_control_config数据表的操作方法: insert  
     * 
     */
    int insert(AccessCustidControlConfig record);

    /**
     * access_custid_control_config数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(AccessCustidControlConfig record);

    /**
     * access_custid_control_config数据表的操作方法: selectByExample  
     * 
     */
    List<AccessCustidControlConfig> selectByExample(AccessCustidControlConfigCriteria example);

    /**
     * access_custid_control_config数据表的操作方法: selectByPrimaryKey  
     * 
     */
    AccessCustidControlConfig selectByPrimaryKey(Long id);

    /**
     * access_custid_control_config数据表的操作方法: lockByPrimaryKey  
     * 
     */
    AccessCustidControlConfig lockByPrimaryKey(Long id);

    /**
     * access_custid_control_config数据表的操作方法: lockByExample  
     * 
     */
    AccessCustidControlConfig lockByExample(AccessCustidControlConfigCriteria example);

    /**
     * access_custid_control_config数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<AccessCustidControlConfig> pageByExample(AccessCustidControlConfigCriteria example);

    /**
     * access_custid_control_config数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * access_custid_control_config数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") AccessCustidControlConfig record, @Param("example") AccessCustidControlConfigCriteria example);

    /**
     * access_custid_control_config数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") AccessCustidControlConfig record, @Param("example") AccessCustidControlConfigCriteria example);

    /**
     * access_custid_control_config数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(AccessCustidControlConfig record);

    /**
     * access_custid_control_config数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(AccessCustidControlConfig record);
}