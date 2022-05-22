package com.qualin.springselenium.qualinservice.customanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Lazy
@Autowired
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface QualInPageObject {
}
