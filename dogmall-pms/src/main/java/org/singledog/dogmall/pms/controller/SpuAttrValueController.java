package org.singledog.dogmall.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.singledog.dogmall.core.response.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.singledog.dogmall.pms.entity.SpuAttrValueEntity;
import org.singledog.dogmall.pms.service.SpuAttrValueService;

/**
 * spu属性值
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "spu属性值 管理")
@RestController
@RequestMapping("pms/spuattrvalue")
public class SpuAttrValueController {

    @Autowired
    private SpuAttrValueService spuAttrValueService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<SpuAttrValueEntity>> querySpuAttrValueByPage(BaseRequest request) {
        List<SpuAttrValueEntity> spuAttrValueEntities = spuAttrValueService.queryPage(request);
        return ResponseFactory.getSuccessResponse(spuAttrValueEntities);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<SpuAttrValueEntity> querySpuAttrValueById(@PathVariable("id") Long id) {
        SpuAttrValueEntity spuAttrValue = spuAttrValueService.getById(id);
        return ResponseFactory.getSuccessResponse(spuAttrValue);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity save(@RequestBody SpuAttrValueEntity spuAttrValue) {
        spuAttrValueService.save(spuAttrValue);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody SpuAttrValueEntity spuAttrValue) {
        spuAttrValueService.updateById(spuAttrValue);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids) {
        spuAttrValueService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }
}
