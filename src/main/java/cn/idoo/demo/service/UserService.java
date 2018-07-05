package cn.idoo.demo.service;

import cn.idoo.demo.dto.AddUserDto;
import cn.idoo.demo.dto.SearchUserDto;
import cn.idoo.demo.model.UserModel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    /**
     * 分页查询用户数据
     * @param dto 查询参数
     * @return 分页用户数据
     */
    PageInfo<UserModel> list(SearchUserDto dto);

    /**
     * 插入用户数据
     * @param dto 用户数据
     * @return 数据库受影响的记录数目
     */
    int add(AddUserDto dto);

    /**
     * 根据id删除用户数据
     * @param id 用户id号
     * @return 数据库受影响的记录数目
     */
    int deleteById(String id);

    /**
     * 根据id更新用户数据
     * @param userModel 用户数据
     * @return 数据库受影响的记录数目
     */
    int update(UserModel userModel);
}
