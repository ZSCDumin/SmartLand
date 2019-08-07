package com.guotu.gt.dto;


import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 分页类
 * 对PageInfo进行封装，加上Swagger Api注解，并去掉不需要的数据
 *
 * @param <T> 泛型类、用来表示查询出来的数据类型
 *
 * @author YalandHong
 *
 */
@ApiModel("分页返回数据")
public class PageBean<T> {

    @ApiModelProperty(value = "当前页码，默认值为1", required = true)
    @Getter @Setter
    private Integer pageNum;

    @ApiModelProperty(value = "每页大小，必须是正整数，默认值为10", required = true)
    @Getter @Setter
    private Integer pageSize;

    @ApiModelProperty(value = "当前页实际所包含的条目数", required = true)
    @Getter @Setter
    private Integer realPageSize;

    @ApiModelProperty(value = "数据体", required = true)
    @Getter @Setter
    private List<T> list;

    @ApiModelProperty(value = "所有页面的数据条目总数", required = true)
    @Getter @Setter
    private Long total;

    // PageHelper开启reasonable参数
    @ApiModelProperty(value = "总页数。当页码小于1时，视作等于1；当页码大于总页数时，视作总页数", required = true)
    @Getter @Setter
    private Integer totalPages;

    /**
     * 将List包装成一个PageInfo，再获取分页信息
     * 注意： 这个List必须是PageHelper分页查询的结果
     * @param list 数据集
     */
    public PageBean(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.list = list;
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        Assert.isTrue(this.pageSize > 0, "页码必须是正整数");
        this.realPageSize = pageInfo.getSize();
        this.total = pageInfo.getTotal();
        this.totalPages = pageInfo.getPages();
    }
}