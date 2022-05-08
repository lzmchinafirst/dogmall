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
import org.singledog.dogmall.ums.entity.UserCollectSubjectEntity;
import org.singledog.dogmall.ums.service.UserCollectSubjectService;

/**
 * 关注活动表
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:52:33
 */
@Api(tags = "关注活动表 管理")
@RestController
@RequestMapping("ums/usercollectsubject")
public class UserCollectSubjectController {

    @Autowired
    private UserCollectSubjectService userCollectSubjectService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<UserCollectSubjectEntity>> queryUserCollectSubjectByPage(PageRequest request) {
        return userCollectSubjectService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<UserCollectSubjectEntity> queryUserCollectSubjectById(@PathVariable("id") Long id) {
        UserCollectSubjectEntity entity = userCollectSubjectService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody UserCollectSubjectEntity userCollectSubject) {
        userCollectSubjectService.save(userCollectSubject);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody UserCollectSubjectEntity userCollectSubject) {
        userCollectSubjectService.updateById(userCollectSubject);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        userCollectSubjectService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
