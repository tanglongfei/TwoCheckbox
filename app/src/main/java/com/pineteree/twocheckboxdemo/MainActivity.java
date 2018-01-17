package com.pineteree.twocheckboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.pineteree.twocheckboxlibrary.TwoCheckbox;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TwoCheckbox mTwoCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTwoCheckbox = findViewById(R.id.main_two_checkbox);
        /**
         * 设置选中哪一个
         * 0：左边CheckBox
         * 1：右边CheckBox
         */
        mTwoCheckbox.setCheckInt(1);

        /**
         *点击事件
         */
        mTwoCheckbox.setCheckBoxOnCheckListener(new TwoCheckbox.OnCheckListener() {
            @Override
            public void getCheckInt(int checkInt) {
                // checkInt：0  左边CheckBox
                // checkInt：1  右边CheckBox
                SmartToast.show(checkInt + "");
            }
        });
    }
}
