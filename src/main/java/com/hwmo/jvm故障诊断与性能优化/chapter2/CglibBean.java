package com.hwmo.jvm故障诊断与性能优化.chapter2;

import com.alibaba.fastjson.JSON;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

public class CglibBean {
    /**
     * 实体Object
     */
    private Object object = null;

    /**
     * 属性map
     */
    private BeanMap beanMap = null;

    public CglibBean() {
        super();
    }

    public CglibBean(Map<String, Class<?>> propertyMap) {
        this.object = generateBean(propertyMap);
        this.beanMap = BeanMap.create(this.object);
    }

    /**
     * 给bean属性赋值
     *
     * @param property 属性名
     * @param value    值
     */
    public void setValue(String property, Object value) {
        beanMap.put(property, value);
    }

    /**
     * 通过属性名得到属性值
     *
     * @param property 属性名
     * @return 值
     */
    public Object getValue(String property) {
        return beanMap.get(property);
    }

    /**
     * 得到该实体bean对象
     */
    public Object getObject() {
        return this.object;
    }

    private Object generateBean(Map<String, Class<?>> propertyMap) {
        if (propertyMap == null || propertyMap.isEmpty()) {
            return null;
        }
        BeanGenerator generator = new BeanGenerator();

        for (Map.Entry<String, Class<?>> entry : propertyMap.entrySet()) {
            generator.addProperty(entry.getKey(), entry.getValue());
        }
        return generator.create();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 设置类成员属性
        Map<String, Class<?>> propertyMap = new HashMap<String, Class<?>>();
        propertyMap.put("id", Class.forName("java.lang.Integer"));
        propertyMap.put("name", Class.forName("java.lang.String"));
        propertyMap.put("address", Class.forName("java.lang.String"));
        // 生成动态 Bean
        CglibBean bean = new CglibBean(propertyMap);
        // 给 Bean 设置值
        bean.setValue("id", 123);
        bean.setValue("name", "姓名");
        bean.setValue("address", "地址");
        System.out.println("获取对象必须getObject(),不然获取到的是包含在CglibBean里的object:" + JSON.toJSON(bean.getObject()));
        // 从 Bean 中获取值
        System.out.println("id      = " + bean.getValue("id"));
        System.out.println("name    = " + bean.getValue("name"));
        System.out.println("address = " + bean.getValue("address"));
    }

}
