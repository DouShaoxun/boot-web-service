package cn.cruder.bwb.service;

import cn.cruder.bwb.constant.SoapConstants;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

/**
 * @author dousx
 * @date 2022-05-26 10:15
 */
@WebService(name = TestWebService.NAME,
        targetNamespace = SoapConstants.NAME_SPACE)
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
public interface TestWebService {
    String NAME = "TestWebService";

    /**
     * 测试
     *
     * @param name name
     * @param msg  msg
     * @return String
     */
    @WebMethod(action = SoapConstants.NAME_SPACE + "#sayHello")
    String sayHello(String name, @WebParam(name = "msg") String msg);
}
