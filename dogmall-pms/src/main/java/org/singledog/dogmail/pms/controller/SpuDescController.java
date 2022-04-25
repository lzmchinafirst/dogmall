package org.singledog.dogmail.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmail.core.request.BaseRequest;
import org.singledog.dogmail.core.response.ResponseEntity;
import org.singledog.dogmail.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.singledog.dogmail.pms.entity.SpuDescEntity;
import org.singledog.dogmail.pms.service.SpuDescService;

/**
 * spu信息介绍
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
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
    public ResponseEntity<List<SpuDescEntity>> querySpuDescByPage(BaseRequest baseRequest) {
        List<SpuDescEntity> spuDescEntities = spuDescService.queryPage(baseRequest);
        return ResponseFactory.getSuccessResponse(spuDescEntities);
    }


    /**
     * 信息
     */
    @GetMapping("{spuId}")
    @ApiOperation("详情查询")
    public ResponseEntity<SpuDescEntity> querySpuDescById(@PathVariable("spuId") Long spuId) {
        SpuDescEntity spuDesc = spuDescService.getById(spuId);
        return ResponseFactory.getSuccessResponse(spuDesc);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Object> save(@RequestBody SpuDescEntity spuDesc) {
        spuDescService.save(spuDesc);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody SpuDescEntity spuDesc) {
        spuDescService.updateById(spuDesc);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> spuIds) {
        spuDescService.removeByIds(spuIds);
        return ResponseFactory.getSuccessResponse();
    }

}
