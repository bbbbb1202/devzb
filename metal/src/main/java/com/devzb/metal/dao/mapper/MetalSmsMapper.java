package com.devzb.metal.dao.mapper;

import com.devzb.metal.dao.model.MetalSms;
import com.devzb.metal.dao.model.MetalSmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MetalSmsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    int countByExample(MetalSmsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    int deleteByExample(MetalSmsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    int insertSelective(MetalSms record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    List<MetalSms> selectByExample(MetalSmsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    MetalSms selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    int updateByExampleSelective(@Param("record") MetalSms record, @Param("example") MetalSmsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    int updateByExample(@Param("record") MetalSms record, @Param("example") MetalSmsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table metal_sms
     *
     * @mbggenerated Tue Dec 06 13:47:51 GMT+08:00 2016
     */
    int updateByPrimaryKeySelective(MetalSms record);
}