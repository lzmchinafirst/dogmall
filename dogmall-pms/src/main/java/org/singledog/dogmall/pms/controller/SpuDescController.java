package org.singledog.dogmall.pms.controller;

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
import org.singledog.dogmall.pms.entity.SpuDescEntity;
import org.singledog.dogmall.pms.service.SpuDescService;

/**
 * spu信息介绍
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:58
 */
@Api(tags = "spu信息介绍 管理")
@RestController
@RequestMapping("pms/spudesc")
public class SpuDescController {

    @Autowired
    private SpuDescService spuDescService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<SpuDescEntity>> querySpuDescByPage(PageRequest request) {
        return spuDescService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{spuId}")
    @ApiOperation("详情查询")
    public Response<SpuDescEntity> querySpuDescById(@PathVariable("spuId") Long spuId) {
        SpuDescEntity entity = spuDescService.getById(spuId);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody SpuDescEntity spuDesc) {
        spuDescService.save(spuDesc);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody SpuDescEntity spuDesc) {
        spuDescService.updateById(spuDesc);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> spuIds) {
        spuDescService.removeByIds(spuIds);
        return ResponseFactory.getSuccessResponse();
    }

}
