package com.qualin.springselenium.qualinservice.customanno;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface QualInTakeScreenshot {
    String value() default "";
}
