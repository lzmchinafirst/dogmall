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
import org.singledog.dogmall.ums.entity.GrowthHistoryEntity;
import org.singledog.dogmall.ums.service.GrowthHistoryService;

/**
 * 成长积分记录表
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:52:33
 */
@Api(tags = "成长积分记录表 管理")
@RestController
@RequestMapping("ums/growthhistory")
public class GrowthHistoryController {

    @Autowired
    private GrowthHistoryService growthHistoryService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<GrowthHistoryEntity>> queryGrowthHistoryByPage(PageRequest request) {
        return growthHistoryService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<GrowthHistoryEntity> queryGrowthHistoryById(@PathVariable("id") Long id) {
        GrowthHistoryEntity entity = growthHistoryService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody GrowthHistoryEntity growthHistory) {
        growthHistoryService.save(growthHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody GrowthHistoryEntity growthHistory) {
        growthHistoryService.updateById(growthHistory);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        growthHistoryService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
