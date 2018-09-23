package com.lm.ioc.io;

import com.lm.ioc.beans.io.Resource;
import com.lm.ioc.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author:lucky date:2018/9/22
 * time:18:05
 */
public class ResourceLoaderTest {

    @Test
    public void test() throws Exception {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("ioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
