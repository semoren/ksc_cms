package com.sermo.ksc.doman;

import org.apache.ibatis.annotations.*;

/**
 * @author sermo
 * @version 2016/12/15.
 */
@Mapper
public interface SystemSettingRepository {

    @Results(id = "systemSetting", value = {
        @Result(column = "business_start", property = "bStart"),
        @Result(column = "business_end", property = "bEnd"),
        @Result(column = "delivery_start", property = "dStart"),
        @Result(column = "delivery_end", property = "dEnd")
    })
    @Select("select id, business_start, business_end, delivery_start, delivery_end, state, agreement from k_system_setting")
    SystemSetting find();

    @Update("update k_system_setting set business_start=#{bStart}, business_end=#{bEnd}, delivery_start=#{dStart}, delivery_end=#{dEnd}, state=#{state}, agreement=#{agreement} where id=#{id}")
    int update(SystemSetting systemSetting) throws Exception;
}
