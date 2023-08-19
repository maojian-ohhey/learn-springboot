package com.github.maojian.anno;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JudgeMethod {

    String methodName() default "handle";
}
