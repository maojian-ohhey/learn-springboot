package com.github.maojian;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class SimulateImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        ServiceLoader<WebServiceAutoConfiguration> serviceLoader =
                ServiceLoader.load(WebServiceAutoConfiguration.class);
        List<String> list = new ArrayList<>();
        for (WebServiceAutoConfiguration autoConfiguration : serviceLoader) {
            list.add(autoConfiguration.getClass().getName());

        }
        return list.toArray(new String[0]);
    }
}
