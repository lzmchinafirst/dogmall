package org.singledog.dogmail.pms;

import org.junit.jupiter.api.Test;
import org.singledog.dogmail.core.request.BaseRequest;
import org.singledog.dogmail.core.response.ResponseEntity;
import org.singledog.dogmail.pms.controller.BrandController;
import org.singledog.dogmail.pms.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DogmailPmsApplicationTests {

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
