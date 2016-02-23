package org.nut.bean.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by abing on 2016/1/11.
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValue = new ArrayList<PropertyValue>();

    public List<PropertyValue> getPropertyValue() {
        return propertyValue;
    }

    public void addPropertyValue(PropertyValue value) {
        propertyValue.add(value);
    }
}
