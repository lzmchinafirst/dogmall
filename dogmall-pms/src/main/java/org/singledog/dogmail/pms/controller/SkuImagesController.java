package org.singledog.dogmail.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmail.core.request.BaseRequest;
import org.singledog.dogmail.core.response.ResponseEntity;
import org.singledog.dogmail.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.singledog.dogmail.pms.entity.SkuImagesEntity;
import org.singledog.dogmail.pms.service.SkuImagesService;

/**
 * sku图片
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "sku图片 管理")
@RestController
@RequestMapping("pms/skuimages")
public class SkuImagesController {

    @Autowired
    private SkuImagesService skuImagesService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<SkuImagesEntity>> querySkuImagesByPage(BaseRequest request) {
        List<SkuImagesEntity> skuImagesEntities = skuImagesService.query(request);
        return ResponseFactory.getSuccessResponse(skuImagesEntities);
    }

    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<SkuImagesEntity> querySkuImagesById(@PathVariable("id") Long id) {
        SkuImagesEntity skuImages = skuImagesService.getById(id);
        return ResponseFactory.getSuccessResponse(skuImages);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity save(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.save(skuImages);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.updateById(skuImages);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids) {
        skuImagesService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
