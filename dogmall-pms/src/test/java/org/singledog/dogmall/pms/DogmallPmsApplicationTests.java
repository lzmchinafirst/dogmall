package org.singledog.dogmall.pms;

import org.junit.jupiter.api.Test;
import org.singledog.dogmall.core.request.BaseRequest;
import org.singledog.dogmall.core.response.ResponseEntity;
import org.singledog.dogmall.pms.controller.BrandController;
import org.singledog.dogmall.pms.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DogmallPmsApplicationTests {

    @Autowired
    private BrandController brandController;

    @Test
    void contextLoads() {
        BaseRequest request = new BaseRequest();
        request.setPageNum(1);
        request.setPageSize(10);
        ResponseEntity<List<BrandEntity>> listResponseEntity = brandController.queryBrandByPage(request);
        System.out.println(listResponseEntity.getData());
    }

}
