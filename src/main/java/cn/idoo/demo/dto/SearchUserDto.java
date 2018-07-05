package cn.idoo.demo.dto;

import cn.idoo.demo.util.PageBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class SearchUserDto extends PageBean implements Serializable {

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户名")
    private String userName;

    private Long birthday;

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
