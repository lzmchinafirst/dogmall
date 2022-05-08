package org.singledog.dogmall.ums.controller;

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
import org.singledog.dogmall.ums.entity.IntegrationHistoryEntity;
import org.singledog.dogmall.ums.service.IntegrationHistoryService;

/**
 * 购物积分记录表
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:52:33
 */
@Api(tags = "购物积分记录表 管理")
@RestController
@RequestMapping("ums/integrationhistory")
public class IntegrationHistoryController {

    @Autowired
    private IntegrationHistoryService integrationHistoryService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<IntegrationHistoryEntity>> queryIntegrationHistoryByPage(PageRequest request) {
        return integrationHistoryService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<IntegrationHistoryEntity> queryIntegrationHistoryById(@PathVariable("id") Long id) {
        IntegrationHistoryEntity entity = integrationHistoryService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody IntegrationHistoryEntity integrationHistory) {
        integrationHistoryService.save(integrationHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody IntegrationHistoryEntity integrationHistory) {
        integrationHistoryService.updateById(integrationHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        integrationHistoryService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
