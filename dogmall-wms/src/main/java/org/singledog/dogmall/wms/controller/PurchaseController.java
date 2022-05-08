package org.singledog.dogmall.wms.controller;

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
import org.singledog.dogmall.wms.entity.PurchaseEntity;
import org.singledog.dogmall.wms.service.PurchaseService;

/**
 * 采购信息
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:54:47
 */
@Api(tags = "采购信息 管理")
@RestController
@RequestMapping("wms/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<PurchaseEntity>> queryPurchaseByPage(PageRequest request) {
        return purchaseService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<PurchaseEntity> queryPurchaseById(@PathVariable("id") Long id) {
        PurchaseEntity entity = purchaseService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody PurchaseEntity purchase) {
        purchaseService.save(purchase);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody PurchaseEntity purchase) {
        purchaseService.updateById(purchase);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        purchaseService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
