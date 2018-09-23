package com.lm.ioc.xml;

import com.lm.ioc.beans.BeanDefinition;
import com.lm.ioc.beans.xml.XmlBeanDefinitionReader;
import com.lm.ioc.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author:lucky date:2018/9/22
 * time:18:07
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("ioc.xml");
        Map<String, BeanDefinition> map = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(map.size()>0);
    }
}
