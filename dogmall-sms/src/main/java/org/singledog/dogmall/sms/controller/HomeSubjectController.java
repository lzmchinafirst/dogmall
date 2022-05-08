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
import org.singledog.dogmall.sms.entity.HomeSubjectEntity;
import org.singledog.dogmall.sms.service.HomeSubjectService;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:55
 */
@Api(tags = "首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】 管理")
@RestController
@RequestMapping("sms/homesubject")
public class HomeSubjectController {

    @Autowired
    private HomeSubjectService homeSubjectService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<HomeSubjectEntity>> queryHomeSubjectByPage(PageRequest request) {
        return homeSubjectService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<HomeSubjectEntity> queryHomeSubjectById(@PathVariable("id") Long id) {
        HomeSubjectEntity entity = homeSubjectService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody HomeSubjectEntity homeSubject) {
        homeSubjectService.save(homeSubject);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody HomeSubjectEntity homeSubject) {
        homeSubjectService.updateById(homeSubject);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        homeSubjectService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
