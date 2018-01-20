package proxy.own.com.androidproxydynamic;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import proxy.own.com.androidproxydynamic.annotation.ContentView;
import proxy.own.com.androidproxydynamic.annotation.InjectUtils;
import proxy.own.com.androidproxydynamic.annotation.ViewInject;

@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {
    @ViewInject(R.id.tv)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.inject(this);
    }
}
