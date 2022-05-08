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
import org.singledog.dogmall.ums.entity.UserLevelEntity;
import org.singledog.dogmall.ums.service.UserLevelService;

/**
 * 会员等级表
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:52:33
 */
@Api(tags = "会员等级表 管理")
@RestController
@RequestMapping("ums/userlevel")
public class UserLevelController {

    @Autowired
    private UserLevelService userLevelService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<UserLevelEntity>> queryUserLevelByPage(PageRequest request) {
        return userLevelService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<UserLevelEntity> queryUserLevelById(@PathVariable("id") Long id) {
        UserLevelEntity entity = userLevelService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody UserLevelEntity userLevel) {
        userLevelService.save(userLevel);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody UserLevelEntity userLevel) {
        userLevelService.updateById(userLevel);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        userLevelService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
