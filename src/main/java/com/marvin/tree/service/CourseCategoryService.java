package com.marvin.tree.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.marvin.tree.pojo.CourseCategory;

import java.util.List;

/**
 * @author yinyin
 * @create 2022/04/30 下午 3:40
 */
public interface CourseCategoryService extends IService<CourseCategory> {

    List getCourseCategoryTree();
}
