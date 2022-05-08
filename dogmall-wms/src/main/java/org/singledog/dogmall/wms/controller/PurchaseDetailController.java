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
import org.singledog.dogmall.wms.entity.PurchaseDetailEntity;
import org.singledog.dogmall.wms.service.PurchaseDetailService;

/**
 * 
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:54:47
 */
@Api(tags = " 管理")
@RestController
@RequestMapping("wms/purchasedetail")
public class PurchaseDetailController {

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<PurchaseDetailEntity>> queryPurchaseDetailByPage(PageRequest request) {
        return purchaseDetailService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<PurchaseDetailEntity> queryPurchaseDetailById(@PathVariable("id") Long id) {
        PurchaseDetailEntity entity = purchaseDetailService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody PurchaseDetailEntity purchaseDetail) {
        purchaseDetailService.save(purchaseDetail);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody PurchaseDetailEntity purchaseDetail) {
        purchaseDetailService.updateById(purchaseDetail);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        purchaseDetailService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
