package com.pineteree.twocheckboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
         * 必选模式
         * 0：左边CheckBox
         * 1：右边CheckBox
         */
        mTwoCheckbox.setMode(TwoCheckbox.MODE_MANDATORY);
        mTwoCheckbox.setCheckInt(1);

        /**
         * 设置选中哪一个
         * 可选模式
         * 0：左边CheckBox
         * 1：右边CheckBox
         * 2：都不选中
         */
        //        mTwoCheckbox.setMode(TwoCheckbox.MODE_OPTIONAL);
        //        mTwoCheckbox.setCheckInt(2);


        /**
         *获取选中哪一个
         * 0：左边CheckBox
         * 1：右边CheckBox
         */
        int checkInt = mTwoCheckbox.getCheckInt();
        Log.d("checkInt", checkInt + "");
        /**
         *点击事件
         */
        mTwoCheckbox.setCheckBoxOnCheckListener(new TwoCheckbox.OnCheckListener() {
            @Override
            public void getCheckInt(int checkInt) {
                // checkInt：0  左边CheckBox
                // checkInt：1  右边CheckBox
                Toast.makeText(getApplicationContext(), checkInt + "", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
