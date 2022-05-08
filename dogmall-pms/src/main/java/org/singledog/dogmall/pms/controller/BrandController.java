package org.singledog.dogmall.pms.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.BaseResponse;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.singledog.dogmall.sms.api.CouponSpuApi;
import org.singledog.dogmall.sms.entity.CouponSpuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.singledog.dogmall.pms.entity.BrandEntity;
import org.singledog.dogmall.pms.service.BrandService;

/**
 * 品牌
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:58
 */
@Api(tags = "品牌 管理")
@RestController
@RequestMapping("pms/brand")
@Slf4j
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    CouponSpuApi couponSpuApi;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<BrandEntity>> queryBrandByPage(PageRequest request) {
        return brandService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<BrandEntity> queryBrandById(@PathVariable("id") Long id) {
        BrandEntity entity = brandService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody BrandEntity brand) {
        brandService.save(brand);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody BrandEntity brand) {
        brandService.updateById(brand);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        brandService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
