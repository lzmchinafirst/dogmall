package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.BaseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.pms.mapper.CommentReplayMapper;
import org.singledog.dogmall.pms.entity.CommentReplayEntity;
import org.singledog.dogmall.pms.service.CommentReplayService;

import java.util.List;


@Service("commentReplayService")
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayMapper, CommentReplayEntity> implements CommentReplayService {

    private CommentReplayMapper commentReplayMapper;

    @Autowired
    public CommentReplayServiceImpl(CommentReplayMapper commentReplayMapper) {
        this.commentReplayMapper = commentReplayMapper;
    }

    @Override
    public List<CommentReplayEntity> query(BaseRequest request) {
        return request.query(commentReplayMapper);
    }
}