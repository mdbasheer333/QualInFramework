package com.qualin.springselenium.qualinservice.customanno;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface QualInWindow {
    String value() default "";
}
