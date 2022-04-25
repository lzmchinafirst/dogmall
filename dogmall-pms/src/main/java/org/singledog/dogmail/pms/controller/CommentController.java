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

import org.singledog.dogmail.pms.entity.CommentEntity;
import org.singledog.dogmail.pms.service.CommentService;

/**
 * 商品评价
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "商品评价 管理")
@RestController
@RequestMapping("pms/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<CommentEntity>> queryCommentByPage(BaseRequest request){
        List<CommentEntity> commentEntities = commentService.query(request);
        return ResponseFactory.getSuccessResponse(commentEntities);
    }

    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<CommentEntity> queryCommentById(@PathVariable("id") Long id){
		CommentEntity comment = commentService.getById(id);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity save(@RequestBody CommentEntity comment){
		commentService.save(comment);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody CommentEntity comment){
		commentService.updateById(comment);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids){
		commentService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
