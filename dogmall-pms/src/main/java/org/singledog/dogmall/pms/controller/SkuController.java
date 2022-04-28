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

import org.singledog.dogmall.pms.entity.SkuEntity;
import org.singledog.dogmall.pms.service.SkuService;

/**
 * sku信息
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "sku信息 管理")
@RestController
@RequestMapping("pms/sku")
public class SkuController {

    @Autowired
    private SkuService skuService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<SkuEntity>> querySkuByPage(BaseRequest request){
        List<SkuEntity> skus = skuService.query(request);
        return ResponseFactory.getSuccessResponse(skus);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<SkuEntity> querySkuById(@PathVariable("id") Long id){
		SkuEntity sku = skuService.getById(id);
        return ResponseFactory.getSuccessResponse(sku);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity save(@RequestBody SkuEntity sku){
		skuService.save(sku);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody SkuEntity sku){
		skuService.updateById(sku);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids){
		skuService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
