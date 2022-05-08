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
import org.singledog.dogmall.oms.entity.OrderOperateHistoryEntity;
import org.singledog.dogmall.oms.service.OrderOperateHistoryService;

/**
 * 订单操作历史记录
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:46:31
 */
@Api(tags = "订单操作历史记录 管理")
@RestController
@RequestMapping("oms/orderoperatehistory")
public class OrderOperateHistoryController {

    @Autowired
    private OrderOperateHistoryService orderOperateHistoryService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<OrderOperateHistoryEntity>> queryOrderOperateHistoryByPage(PageRequest request) {
        return orderOperateHistoryService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<OrderOperateHistoryEntity> queryOrderOperateHistoryById(@PathVariable("id") Long id) {
        OrderOperateHistoryEntity entity = orderOperateHistoryService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody OrderOperateHistoryEntity orderOperateHistory) {
        orderOperateHistoryService.save(orderOperateHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody OrderOperateHistoryEntity orderOperateHistory) {
        orderOperateHistoryService.updateById(orderOperateHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        orderOperateHistoryService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
