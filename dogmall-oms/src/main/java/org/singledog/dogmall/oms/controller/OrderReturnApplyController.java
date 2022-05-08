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
import org.singledog.dogmall.oms.entity.OrderReturnApplyEntity;
import org.singledog.dogmall.oms.service.OrderReturnApplyService;

/**
 * 订单退货申请
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:46:31
 */
@Api(tags = "订单退货申请 管理")
@RestController
@RequestMapping("oms/orderreturnapply")
public class OrderReturnApplyController {

    @Autowired
    private OrderReturnApplyService orderReturnApplyService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<OrderReturnApplyEntity>> queryOrderReturnApplyByPage(PageRequest request) {
        return orderReturnApplyService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<OrderReturnApplyEntity> queryOrderReturnApplyById(@PathVariable("id") Long id) {
        OrderReturnApplyEntity entity = orderReturnApplyService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody OrderReturnApplyEntity orderReturnApply) {
        orderReturnApplyService.save(orderReturnApply);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody OrderReturnApplyEntity orderReturnApply) {
        orderReturnApplyService.updateById(orderReturnApply);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        orderReturnApplyService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
