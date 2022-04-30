package com.marvin.tree.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author yinyin
 * @create 2022/04/30 下午 3:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@TableName("kss_course_category")
public class CourseCategory implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    // 上课标题
    private String title;
    // 分类描述
    private String descrciption;
    // 是否更新
    private Integer mark;
    // 发布状态1发布 0未发布
    private Integer status;
    // 类型 1文件夹 2文件
    private Integer type;
    // 父id =0 根集 其它全部都是子集
    private Integer pid;
    // 是否展开和收起
    private Boolean isexpand;
    // 这里一定加exist=false ,代表当前这个字段不在表中，不加就会报错
    @TableField(exist = false)
    private List<CourseCategory> childrenList;
    // 创建时间
    @TableField(fill = FieldFill.INSERT)//在新增的时候填充
    private Date createTime;
    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)//在新增的时候填充
    private Date updateTime;

}
