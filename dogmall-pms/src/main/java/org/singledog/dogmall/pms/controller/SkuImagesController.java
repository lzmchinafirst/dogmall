package org.singledog.dogmall.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.singledog.dogmall.pms.entity.SkuImagesEntity;
import org.singledog.dogmall.pms.service.SkuImagesService;

/**
 * sku图片
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:58
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
    public Response<List<SkuImagesEntity>> querySkuImagesByPage(PageRequest request) {
        return skuImagesService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<SkuImagesEntity> querySkuImagesById(@PathVariable("id") Long id) {
        SkuImagesEntity entity = skuImagesService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.save(skuImages);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody SkuImagesEntity skuImages) {
        skuImagesService.updateById(skuImages);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        skuImagesService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
