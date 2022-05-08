package org.singledog.dogmall.oms.controller;

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
import org.singledog.dogmall.oms.entity.RefundInfoEntity;
import org.singledog.dogmall.oms.service.RefundInfoService;

/**
 * 退款信息
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:46:31
 */
@Api(tags = "退款信息 管理")
@RestController
@RequestMapping("oms/refundinfo")
public class RefundInfoController {

    @Autowired
    private RefundInfoService refundInfoService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<RefundInfoEntity>> queryRefundInfoByPage(PageRequest request) {
        return refundInfoService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<RefundInfoEntity> queryRefundInfoById(@PathVariable("id") Long id) {
        RefundInfoEntity entity = refundInfoService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody RefundInfoEntity refundInfo) {
        refundInfoService.save(refundInfo);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody RefundInfoEntity refundInfo) {
        refundInfoService.updateById(refundInfo);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        refundInfoService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
