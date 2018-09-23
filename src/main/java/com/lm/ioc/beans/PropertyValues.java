package com.lm.ioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:lucky date:2018/9/21
 * time:15:31
 *
 *
 * 包装一个对象所有的PropertyValue
 * 为什么不直接使用List，因为可以封装一些操作
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue value) {
        this.propertyValueList.add(value);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
