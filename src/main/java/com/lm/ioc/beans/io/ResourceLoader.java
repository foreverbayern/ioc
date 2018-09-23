package com.lm.ioc.beans.io;

import java.net.URL;

/**
 * @author:lucky date:2018/9/22
 * time:15:52
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
