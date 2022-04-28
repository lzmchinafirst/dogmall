package org.singledog.dogmall.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.response.ResponseEntity;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.singledog.dogmall.pms.entity.SpuEntity;
import org.singledog.dogmall.pms.service.SpuService;

/**
 * spu信息
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "spu信息 管理")
@RestController
@RequestMapping("pms/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<SpuEntity>> querySpuByPage(BaseRequest request) {
        List<SpuEntity> spuEntities = spuService.queryPage(request);
        return ResponseFactory.getSuccessResponse(spuEntities);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<SpuEntity> querySpuById(@PathVariable("id") Long id) {
        SpuEntity spu = spuService.getById(id);
        return ResponseFactory.getSuccessResponse(spu);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Object> save(@RequestBody SpuEntity spu) {
        spuService.save(spu);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody SpuEntity spu) {
        spuService.updateById(spu);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids) {
        spuService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
