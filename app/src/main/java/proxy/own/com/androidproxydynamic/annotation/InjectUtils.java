package proxy.own.com.androidproxydynamic.annotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by tianyejun on 2018/1/20.
 */

public class InjectUtils {
    /**
     * 注入布局
     *
     * @param activity
     */
    public static void inject(Activity activity) {
        injectLayout(activity);
    }

    /**
     * 注入布局
     *
     * @param activity
     */
    public static void injectLayout(Activity activity) {
        //获取activity类对象
        Class<? extends Activity> activityClass = activity.getClass();
        //获取activity类上的指定的注解contentView
        ContentView contentView = activityClass.getAnnotation(ContentView.class);

        if (contentView != null) {
            //加载布局,获取activity身上的setContentView方法，然后执行
            try {
                Method method = activityClass.getMethod("setContentView", int.class);
                //执行acitivty上的方法
                method.invoke(activity,contentView.value());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void injectView(Activity activity){
        Class<? extends Activity> aClass = activity.getClass();
        //获取当前activity身上所有的属性
        Field[] fields = aClass.getDeclaredFields();

        for(Field field:fields){
            //获取注入视图的注解
            ViewInject viewInject = field.getAnnotation(ViewInject.class);
            if(viewInject != null){
                int viewId = viewInject.value();
                View view = activity.findViewById(viewId);
                //绑定
                field.setAccessible(true);
                try {
                    field.set(activity,view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
