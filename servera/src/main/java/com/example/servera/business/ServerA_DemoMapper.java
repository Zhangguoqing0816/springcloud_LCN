package com.example.servera.business;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * Date: 2018/12/25
 *
 * @author ujued
 */
@Mapper
@Repository
public interface ServerA_DemoMapper {

    @Insert("insert into t_demo(kid, demo_field, group_id, create_time,app_name) values(#{kid}, #{demoField}, #{groupId}, #{createTime},#{appName})")
    void save(ServerA_Demo demo);

    @Delete("delete from t_demo where id=#{id}")
    void deleteByKId(Long id);
}
