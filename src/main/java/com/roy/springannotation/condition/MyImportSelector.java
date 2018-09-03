package com.roy.springannotation.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    //返回值，就是导入到容器中的组件全类名
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        return new String[]{"com.roy.springannotation.bean.Blue"};
    }
}
