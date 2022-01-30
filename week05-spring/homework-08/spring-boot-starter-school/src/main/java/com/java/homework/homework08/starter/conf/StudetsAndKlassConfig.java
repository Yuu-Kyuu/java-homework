package com.java.homework.homework08.starter.conf;

import com.java.homework.homework08.starter.entity.Klass;
import com.java.homework.homework08.starter.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

/**
 * <bean id="student123"
 * class="io.kimmking.spring01.Student">
 * <property name="id" value="123" />
 * <property name="name" value="KK123" />
 * </bean>
 * <p>
 * <bean id="student100"
 * class="io.kimmking.spring01.Student">
 * <property name="id" value="100" />
 * <property name="name" value="KK100" />
 * </bean>
 *
 * <bean id="class1" class="io.kimmking.spring02.Klass">
 * <property name="students">
 * <list>
 * <ref bean="student100" />
 * <ref bean="student123" />
 * <!--                <bean class="io.kimmking.spring01.Student">-->
 * <!--                    <property name="name" value="qq" />-->
 * <!--                    <property name="id" value="001" /> -->
 * <!--                </bean>-->
 * </list>
 * </property>
 * </bean>
 *
 * @author qiuch
 */
@Configuration
public class StudetsAndKlassConfig {

    @Bean("student123")
    Student student123() {
        return new Student(123, "KK123", null, null);
    }

    @Bean("student100")
    Student student100() {
        return new Student(100, "KK100", null, null);
    }

    @Bean("class1")
    Klass klass() {
        Klass k = new Klass();
        k.setStudents(Arrays.asList(student123(), student100()));
        return k;
    }
}
