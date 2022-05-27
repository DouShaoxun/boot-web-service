package cn.cruder.bwb;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ApplicationTests {

    @Test
    void testWb() {
        JaxWsDynamicClientFactory dcflient = JaxWsDynamicClientFactory.newInstance();
        Client client = dcflient.createClient("http://localhost:8085/services/wssoap/api?wsdl");
        try {
            Object[] objects = client.invoke("sayHello", "tom", "你好");
            log.info("sayHello 调用结果：" + objects[0].toString());
        } catch (Exception e) {
            log.error("JaxWs Error", e);
        }
    }

}
