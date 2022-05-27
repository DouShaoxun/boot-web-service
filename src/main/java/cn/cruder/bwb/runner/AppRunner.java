package cn.cruder.bwb.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author dousx
 * @date 2022-05-27 22:45
 */
@Slf4j
@Component
public class AppRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("http://localhost:8085/services/wssoap/api?wsdl");
    }
}
