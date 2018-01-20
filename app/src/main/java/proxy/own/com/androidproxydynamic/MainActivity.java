package proxy.own.com.androidproxydynamic;

import android.app.Activity;
import android.os.Bundle;

import proxy.own.com.androidproxydynamic.annotation.ContentView;
import proxy.own.com.androidproxydynamic.annotation.InjectUtils;

@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.inject(this);
    }
}
