package org.singledog.dogmall.pms.service.impl;

import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.pms.mapper.CommentMapper;
import org.singledog.dogmall.pms.entity.CommentEntity;
import org.singledog.dogmall.pms.service.CommentService;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentEntity> implements CommentService {

    @Autowired
    private CommentMapper mapper;

    @Override
    public Response<List<CommentEntity>> queryBase(BaseRequest request) {
        return request.query(mapper);
    }

    @Override
    public Response<List<CommentEntity>> queryPage(PageRequest request) {
        return request.query(mapper);
    }
}