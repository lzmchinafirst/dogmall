package org.singledog.dogmail.pms.service.impl;

import org.singledog.dogmail.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmail.pms.mapper.CommentMapper;
import org.singledog.dogmail.pms.entity.CommentEntity;
import org.singledog.dogmail.pms.service.CommentService;

import java.util.List;


@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentEntity> implements CommentService {

    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentEntity> query(BaseRequest request) {
        return request.query(commentMapper);
    }
}