package com.lm.ioc.beans.io;

import java.io.InputStream;

/**
 * @author:lucky date:2018/9/22
 * time:11:31
 *
 *
 * 是spring内部定位资源的接口
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
