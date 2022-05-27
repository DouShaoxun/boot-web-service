package cn.cruder.bwb.config;

import cn.cruder.bwb.service.TestWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import javax.xml.ws.Endpoint;

/**
 * @author dousx
 * @date 2022-05-27 22:27
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * <a href="http://localhost:8085/services/wssoap/api?wsdl">http://localhost:8085/services/wssoap/api?wsdl</a>
     */
    @Bean
    @ConditionalOnClass(value = {TestWebService.class})
    public Endpoint endpoint(TestWebService testWebService) {
        EndpointImpl endpoint = new EndpointImpl(springBus(), testWebService);
        endpoint.publish("/wssoap/api");
        return endpoint;
    }
}
