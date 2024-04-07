package cn.csu.ykf.inkin.console.mapper;

import org.apache.ibatis.annotations.Select;

import cn.csu.ykf.inkin.common.model.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    @Select("select 1 from user where name = #{name} AND password = #{password} LIMIT 1")
    int login(String name, String password);
}
