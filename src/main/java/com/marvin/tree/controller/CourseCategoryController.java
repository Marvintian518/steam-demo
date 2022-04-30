package com.marvin.tree.controller;

import com.marvin.tree.pojo.CourseCategory;
import com.marvin.tree.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinyin
 * @create 2022/04/30 下午 3:42
 */
@Controller
public class CourseCategoryController {

    @Autowired
    private CourseCategoryService courseCategoryService;

    @GetMapping("tree")
    public String treeMenu(){
        return "tree";
    }
    @GetMapping("/api/category/tree")
    @ResponseBody
    public List<CourseCategory> tree(){
        return courseCategoryService.getCourseCategoryTree();
    }
}
