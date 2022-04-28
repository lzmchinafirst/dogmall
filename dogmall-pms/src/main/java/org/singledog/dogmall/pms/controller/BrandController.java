package org.singledog.dogmall.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.response.ResponseEntity;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.singledog.dogmall.datasource.DataSource;
import org.singledog.dogmall.datasource.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.singledog.dogmall.pms.entity.BrandEntity;
import org.singledog.dogmall.pms.service.BrandService;

/**
 * 品牌
 *
 * @author Zheming Liu
 * @email dogmall@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "品牌 管理")
@RestController
@RequestMapping("pms/brand")
public class BrandController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    @DataSource(DataSourceType.MASTER)
    public ResponseEntity<List<BrandEntity>> queryBrandByPage(BaseRequest request) {
        List<BrandEntity> brandEntities = brandService.query(request);
        return ResponseFactory.getSuccessResponse(brandEntities);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<BrandEntity> queryBrandById(@PathVariable("id") Long id) {
        BrandEntity brand = brandService.getById(id);
        return ResponseFactory.getSuccessResponse(brand);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity save(@RequestBody BrandEntity brand) {
        brandService.save(brand);
        int a = 1 / 0;
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody BrandEntity brand) {
        brandService.updateById(brand);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids) {
        brandService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
