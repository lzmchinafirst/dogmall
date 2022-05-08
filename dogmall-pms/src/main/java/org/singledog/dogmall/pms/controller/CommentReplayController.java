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
import org.singledog.dogmall.pms.entity.CommentReplayEntity;
import org.singledog.dogmall.pms.service.CommentReplayService;

/**
 * 商品评价回复关系
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:58
 */
@Api(tags = "商品评价回复关系 管理")
@RestController
@RequestMapping("pms/commentreplay")
public class CommentReplayController {

    @Autowired
    private CommentReplayService commentReplayService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<CommentReplayEntity>> queryCommentReplayByPage(PageRequest request) {
        return commentReplayService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<CommentReplayEntity> queryCommentReplayById(@PathVariable("id") Long id) {
        CommentReplayEntity entity = commentReplayService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody CommentReplayEntity commentReplay) {
        commentReplayService.save(commentReplay);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody CommentReplayEntity commentReplay) {
        commentReplayService.updateById(commentReplay);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        commentReplayService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
