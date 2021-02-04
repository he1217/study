package com.he.excise.spring;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/1/5 11:08
 */
public class ReadXMl {
    public static void main(String[] args) throws DocumentException {
        File file = new File( "E:\\工作\\1.项目需求\\北京电信安全管理\\test.xml");
        List<Map<String,String>> list =new ArrayList<>();
        if (file.exists()) {
            SAXReader reader = new SAXReader();
            Document document = null;
            document = reader.read(file);
            System.out.println("Root element :" + document.getRootElement().getName());
            Element classElement = document.getRootElement();
            for (Iterator host = classElement.elementIterator("host"); host.hasNext(); ) {
                Element element = (Element) host.next();
                Element address = element.element("address");
                String addr = address.attribute("addr").getValue();
                System.out.println(addr);
                Element ports = element.element("ports");
                for (Iterator port = ports.elementIterator("port"); port.hasNext(); ) {
                    HashMap<String,String> pd = new HashMap<>();
                    pd.put("ip_address", addr);
                    Element elementPortid = (Element) port.next();
                    String portid = elementPortid.attribute("portid").getValue();
                    pd.put("port", portid);
                    list.add(pd);
                }
            }
            System.out.println(list);
        }

    }
}
