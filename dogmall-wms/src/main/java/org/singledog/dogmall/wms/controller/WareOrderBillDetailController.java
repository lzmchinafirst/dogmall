package org.singledog.dogmall.wms.controller;

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
import org.singledog.dogmall.wms.entity.WareOrderBillDetailEntity;
import org.singledog.dogmall.wms.service.WareOrderBillDetailService;

/**
 * 库存工作单
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:54:47
 */
@Api(tags = "库存工作单 管理")
@RestController
@RequestMapping("wms/wareorderbilldetail")
public class WareOrderBillDetailController {

    @Autowired
    private WareOrderBillDetailService wareOrderBillDetailService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<WareOrderBillDetailEntity>> queryWareOrderBillDetailByPage(PageRequest request) {
        return wareOrderBillDetailService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<WareOrderBillDetailEntity> queryWareOrderBillDetailById(@PathVariable("id") Long id) {
        WareOrderBillDetailEntity entity = wareOrderBillDetailService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody WareOrderBillDetailEntity wareOrderBillDetail) {
        wareOrderBillDetailService.save(wareOrderBillDetail);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody WareOrderBillDetailEntity wareOrderBillDetail) {
        wareOrderBillDetailService.updateById(wareOrderBillDetail);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        wareOrderBillDetailService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
