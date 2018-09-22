package com.lm.ioc.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author:lucky date:2018/9/22
 * time:11:32
 */
public class UrlResource implements Resource{

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection connection = url.openConnection();
        connection.connect();
        return connection.getInputStream();
    }
}
