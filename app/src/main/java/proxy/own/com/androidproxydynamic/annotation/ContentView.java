package proxy.own.com.androidproxydynamic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target:作用范围
 * ElementType.TYPE：该注解作用在类身上
 *
 * @Retention:注解生命周期(这个注解什么时候运行加载)
 * RetentionPolicy.RUNTIME：虚拟机运行的时候加载运行
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentView {
    int value();//布局文件的id
}
