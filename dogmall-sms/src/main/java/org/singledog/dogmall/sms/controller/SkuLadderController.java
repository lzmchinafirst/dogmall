package org.singledog.dogmall.sms.controller;

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
import org.singledog.dogmall.sms.entity.SkuLadderEntity;
import org.singledog.dogmall.sms.service.SkuLadderService;

/**
 * 商品阶梯价格
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
@Api(tags = "商品阶梯价格 管理")
@RestController
@RequestMapping("sms/skuladder")
public class SkuLadderController {

    @Autowired
    private SkuLadderService skuLadderService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<SkuLadderEntity>> querySkuLadderByPage(PageRequest request) {
        return skuLadderService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<SkuLadderEntity> querySkuLadderById(@PathVariable("id") Long id) {
        SkuLadderEntity entity = skuLadderService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody SkuLadderEntity skuLadder) {
        skuLadderService.save(skuLadder);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody SkuLadderEntity skuLadder) {
        skuLadderService.updateById(skuLadder);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        skuLadderService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
