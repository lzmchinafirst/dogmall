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
import org.singledog.dogmall.sms.entity.HomeSubjectSpuEntity;
import org.singledog.dogmall.sms.service.HomeSubjectSpuService;

/**
 * 专题商品
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
@Api(tags = "专题商品 管理")
@RestController
@RequestMapping("sms/homesubjectspu")
public class HomeSubjectSpuController {

    @Autowired
    private HomeSubjectSpuService homeSubjectSpuService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<HomeSubjectSpuEntity>> queryHomeSubjectSpuByPage(PageRequest request) {
        return homeSubjectSpuService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<HomeSubjectSpuEntity> queryHomeSubjectSpuById(@PathVariable("id") Long id) {
        HomeSubjectSpuEntity entity = homeSubjectSpuService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody HomeSubjectSpuEntity homeSubjectSpu) {
        homeSubjectSpuService.save(homeSubjectSpu);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody HomeSubjectSpuEntity homeSubjectSpu) {
        homeSubjectSpuService.updateById(homeSubjectSpu);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        homeSubjectSpuService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
