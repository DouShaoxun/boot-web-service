package cn.cruder.bwb.service.impl;

import cn.cruder.bwb.constant.SoapConstants;
import cn.cruder.bwb.service.TestWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @author dousx
 * @date 2022-05-26 14:53
 */
@Service
@Slf4j
@WebService(targetNamespace = SoapConstants.NAME_SPACE,
        serviceName = TestWebService.NAME,
        name = TestWebService.NAME,
        endpointInterface = "cn.cruder.bwb.service.TestWebService")
public class TestWebServiceImpl implements TestWebService {
    @Override
    public String sayHello(String name, String msg) {
        log.info("name:{} ,msg:{}", name, msg);
        return "hello," + name;
    }
}
