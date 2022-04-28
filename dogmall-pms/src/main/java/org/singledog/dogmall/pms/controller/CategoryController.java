package org.singledog.dogmall.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.response.ResponseEntity;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.singledog.dogmall.pms.entity.CategoryEntity;
import org.singledog.dogmall.pms.service.CategoryService;

/**
 * 商品三级分类
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "商品三级分类 管理")
@RestController
@RequestMapping("pms/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<CategoryEntity>> queryCategoryByPage(BaseRequest request) {
        List<CategoryEntity> categoryEntities = categoryService.query(request);
        return ResponseFactory.getSuccessResponse(categoryEntities);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<CategoryEntity> queryCategoryById(@PathVariable("id") Long id) {
        CategoryEntity category = categoryService.getById(id);
        return ResponseFactory.getSuccessResponse(category);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Object> save(@RequestBody CategoryEntity category) {
        categoryService.save(category);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids) {
        categoryService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
