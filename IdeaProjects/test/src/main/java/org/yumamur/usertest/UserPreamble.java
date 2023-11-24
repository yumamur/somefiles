package org.yumamur.usertest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@interface UserPreamble {
    String name() default "none";
    String pwd() default "none";
    int age() default 0;
}

