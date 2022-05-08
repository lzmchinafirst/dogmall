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
import org.singledog.dogmall.pms.entity.SkuAttrValueEntity;
import org.singledog.dogmall.pms.service.SkuAttrValueService;

/**
 * sku销售属性&值
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:57
 */
@Api(tags = "sku销售属性&值 管理")
@RestController
@RequestMapping("pms/skuattrvalue")
public class SkuAttrValueController {

    @Autowired
    private SkuAttrValueService skuAttrValueService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<SkuAttrValueEntity>> querySkuAttrValueByPage(PageRequest request) {
        return skuAttrValueService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<SkuAttrValueEntity> querySkuAttrValueById(@PathVariable("id") Long id) {
        SkuAttrValueEntity entity = skuAttrValueService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody SkuAttrValueEntity skuAttrValue) {
        skuAttrValueService.save(skuAttrValue);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody SkuAttrValueEntity skuAttrValue) {
        skuAttrValueService.updateById(skuAttrValue);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        skuAttrValueService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
