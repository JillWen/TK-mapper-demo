package cn.idoo.demo.controller;

import cn.idoo.demo.dto.AddUserDto;
import cn.idoo.demo.dto.SearchUserDto;
import cn.idoo.demo.model.UserModel;
import cn.idoo.demo.service.UserService;
import cn.idoo.demo.util.ErrorCode;
import cn.idoo.demo.util.ResponseResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation(value = "分页获取用户列表", notes = "获取数据成功返回0")
    @ResponseBody
    public ResponseResult<PageInfo<UserModel>> list(@RequestBody SearchUserDto dto){
        PageInfo<UserModel> result=userService.list(dto);
        return new ResponseResult<PageInfo<UserModel>>().success(ErrorCode.SUCCESS,"查询成功",result);
    }

    @PostMapping("/add")
    @ApiOperation(value = "插入用户数据", notes = "插入成功返回0")
    @ResponseBody
    public ResponseResult<Integer> list(@RequestBody AddUserDto dto){
        int result=userService.add(dto);
        return new ResponseResult<Integer>().success(ErrorCode.SUCCESS,"插入成功",result);
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "根据用户id删除用户数据", notes = "删除成功返回0")
    @ResponseBody
    public ResponseResult<Integer> deleteById(@RequestParam String id){
        int result=userService.deleteById(id);
        return new ResponseResult<Integer>().success(ErrorCode.SUCCESS,"删除成功",result);
    }

    /*@PostMapping("/deleteBatch")
    @ApiOperation(value = "根据用户id批量删除用户数据", notes = "删除成功返回0")
    @ResponseBody
    public ResponseResult<Integer> deleteBatch(@RequestBody List<String> ids){
        int result=userService.deleteBatch(ids);
        return new ResponseResult<Integer>().success(ErrorCode.SUCCESS,"成功删除【"+"】条数据",result);
    }

    @PostMapping("/update")
    @ApiOperation(value = "根据用户id更新用户数据", notes = "更新成功返回0")
    @ResponseBody
    public ResponseResult<Integer> update(@RequestBody  UserModel userModel){
        int result=userService.update(userModel);
        return new ResponseResult<Integer>().success(ErrorCode.SUCCESS,"更新成功6666",result);
    }*/
}
