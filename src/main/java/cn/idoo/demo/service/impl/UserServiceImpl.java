package cn.idoo.demo.service.impl;

import cn.idoo.demo.dao.UserModelMapper;
import cn.idoo.demo.dto.AddUserDto;
import cn.idoo.demo.dto.SearchUserDto;
import cn.idoo.demo.model.UserModel;
import cn.idoo.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public PageInfo<UserModel> list(SearchUserDto dto) {
        Example example=Example.builder(UserModel.class).build();
        Example.Criteria criteria=example.createCriteria();
//        String email=dto.getEmail();
//        if(!StringUtils.isEmpty(email)){
//            criteria.andLike("email","%"+dto.getEmail()+"%");
            criteria.andEqualTo(dto);
//        }

        example.selectProperties("id","email");
        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
        List<UserModel> list=userModelMapper.selectByExample(example);
        PageInfo<UserModel> result=new PageInfo<>(list);
        return result;
    }

    @Override
    public int add(AddUserDto dto) {
        UserModel userModel=new UserModel();
        BeanUtils.copyProperties(dto,userModel);
        return userModelMapper.insertSelective(userModel);
    }

    @Override
    public int deleteById(String id) {
        return userModelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(UserModel userModel) {
        return userModelMapper.updateByPrimaryKeySelective(userModel);
    }

//    @Override
//    public int deleteBatch(List<String> ids) {
//        int result=userModelMapper.deleteBatch(ids);
//        return result;
//    }
}
