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
import org.singledog.dogmall.sms.entity.CouponHistoryEntity;
import org.singledog.dogmall.sms.service.CouponHistoryService;

/**
 * 优惠券领取历史记录
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
@Api(tags = "优惠券领取历史记录 管理")
@RestController
@RequestMapping("sms/couponhistory")
public class CouponHistoryController {

    @Autowired
    private CouponHistoryService couponHistoryService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<CouponHistoryEntity>> queryCouponHistoryByPage(PageRequest request) {
        return couponHistoryService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<CouponHistoryEntity> queryCouponHistoryById(@PathVariable("id") Long id) {
        CouponHistoryEntity entity = couponHistoryService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody CouponHistoryEntity couponHistory) {
        couponHistoryService.save(couponHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody CouponHistoryEntity couponHistory) {
        couponHistoryService.updateById(couponHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        couponHistoryService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
