package com.pan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pan.entry.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author qingxu.pan@tophant.com
 * @Date 2022/4/18
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 自己写的查询
     * @param id
     * @return
     */
    User mySelectUserById(Long id);
}
