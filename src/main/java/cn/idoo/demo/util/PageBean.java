package cn.idoo.demo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel
public class PageBean implements Serializable {

    @ApiModelProperty("页码数")
    private Integer pageNum;

    @ApiModelProperty("每页记录数目")
    private Integer pageSize;

    public Integer getPageNum() {
        return (pageNum==null||pageNum<0)?1:pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return (pageSize==null||pageSize<0)?1:pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
