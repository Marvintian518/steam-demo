package com.marvin.tree.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marvin.tree.mapper.CourseCategoryMapper;
import com.marvin.tree.pojo.CourseCategory;
import com.marvin.tree.service.CourseCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yinyin
 * @create 2022/04/30 下午 3:40
 */
@Service
public class CourseCategoryServiceImpl extends ServiceImpl<CourseCategoryMapper, CourseCategory>
        implements CourseCategoryService {
    @Override
    public List getCourseCategoryTree() {
        //获取所有数据
        List<CourseCategory> allList = this.list();
        //筛选出一级菜单
        List<CourseCategory> rootList = allList.stream().filter(cate -> cate.getPid().equals(0)).collect(Collectors.toList());
        //筛选出非一级菜单
        List<CourseCategory> subList = allList.stream().filter(cate -> !cate.getPid().equals(0)).collect(Collectors.toList());
        //递归
        rootList.forEach(root->findChildren(root,subList));
        //根据一级菜单的id查找子级
        //rootList=rootList.stream().map(root->{
        //    List<CourseCategory> childList = subList.stream().filter(courseCategory -> courseCategory.getPid().equals(root.getId())).collect(Collectors.toList());
        //    //判断是否有子级,如果没有子级值设置为空数组
        //    if (CollectionUtils.isEmpty(childList)){
        //        childList=new ArrayList<>();
        //    }
        //    root.setChildrenList(childList);
        //    return  root;
        //}).collect(Collectors.toList());
        return allList;
    }
    private void findChildren(CourseCategory root, List<CourseCategory> subList ){
           //根据父节点的id查找子节点
            List<CourseCategory> childList = subList.stream().filter(courseCategory -> courseCategory.getPid().equals(root.getId())).collect(Collectors.toList());
            //判断是否有子级,如果没有子级值设置为空数组
            if (!CollectionUtils.isEmpty(childList)){
                root.setChildrenList(childList);
                childList.forEach(child->findChildren(child,subList));
            }else {
                root.setChildrenList( new ArrayList<>());
            }

    }
}

