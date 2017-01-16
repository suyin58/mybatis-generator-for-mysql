package com.wjs.mybatis.demo.dao.access;

import com.wjs.mybatis.demo.domain.access.AccessIpControlConfig;
import com.wjs.mybatis.demo.domain.access.AccessIpControlConfigCriteria;
import com.wjs.mybatis.util.page.PageDataList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessIpControlConfigMapper {
    /**
     * access_ip_control_config数据表的操作方法: countByExample  
     * 
     */
    int countByExample(AccessIpControlConfigCriteria example);

    /**
     * access_ip_control_config数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(AccessIpControlConfigCriteria example);

    /**
     * access_ip_control_config数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * access_ip_control_config数据表的操作方法: insert  
     * 
     */
    int insert(AccessIpControlConfig record);

    /**
     * access_ip_control_config数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(AccessIpControlConfig record);

    /**
     * access_ip_control_config数据表的操作方法: selectByExample  
     * 
     */
    List<AccessIpControlConfig> selectByExample(AccessIpControlConfigCriteria example);

    /**
     * access_ip_control_config数据表的操作方法: selectByPrimaryKey  
     * 
     */
    AccessIpControlConfig selectByPrimaryKey(Long id);

    /**
     * access_ip_control_config数据表的操作方法: lockByPrimaryKey  
     * 
     */
    AccessIpControlConfig lockByPrimaryKey(Long id);

    /**
     * access_ip_control_config数据表的操作方法: lockByExample  
     * 
     */
    AccessIpControlConfig lockByExample(AccessIpControlConfigCriteria example);

    /**
     * access_ip_control_config数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<AccessIpControlConfig> pageByExample(AccessIpControlConfigCriteria example);

    /**
     * access_ip_control_config数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * access_ip_control_config数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") AccessIpControlConfig record, @Param("example") AccessIpControlConfigCriteria example);

    /**
     * access_ip_control_config数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") AccessIpControlConfig record, @Param("example") AccessIpControlConfigCriteria example);

    /**
     * access_ip_control_config数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(AccessIpControlConfig record);

    /**
     * access_ip_control_config数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(AccessIpControlConfig record);
}