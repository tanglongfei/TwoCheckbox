package com.pineteree.twocheckboxlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/17.
 */

public class TwoCheckbox extends LinearLayout {
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private TextView mTextView;
    //必选模式
    public static final int MODE_MANDATORY = 0;
    //可选模式
    public static final int MODE_OPTIONAL = 1;
    //模式
    private int mode = 0;
    private int checkInt = 0;


    public TwoCheckbox(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.include_checkbox_two, this, true);
        mTextView = findViewById(R.id.tv_text);
        mCheckBox1 = findViewById(R.id.checkbox1);
        mCheckBox2 = findViewById(R.id.checkbox2);

        if (checkInt == 0) {
            mCheckBox1.setChecked(true);
            mCheckBox2.setChecked(false);
        } else if (checkInt == 1) {
            mCheckBox1.setChecked(false);
            mCheckBox2.setChecked(true);
        }

        mCheckBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mode == MODE_MANDATORY) {
                    if (isChecked) {
                        mCheckBox2.setChecked(false);
                        checkInt = 0;

                    } else {
                        mCheckBox2.setChecked(true);
                        checkInt = 1;
                    }

                } else if (mode == MODE_OPTIONAL) {
                    if (isChecked) {
                        mCheckBox2.setChecked(false);
                        checkInt = 0;
                    } else if (mCheckBox2.isChecked()) {
                        checkInt = 1;
                    } else if (!mCheckBox1.isChecked() && !mCheckBox2.isChecked()) {
                        checkInt = 2;
                    }

                }

                if (mOnCheckListener != null) {
                    mOnCheckListener.getCheckInt(checkInt);
                }
            }
        });

        mCheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mode == MODE_MANDATORY) {
                    if (isChecked) {
                        mCheckBox1.setChecked(false);
                        checkInt = 1;
                    } else {
                        mCheckBox1.setChecked(true);
                        checkInt = 0;
                    }

                } else if (mode == MODE_OPTIONAL) {
                    if (isChecked) {
                        mCheckBox1.setChecked(false);
                        checkInt = 1;
                    } else if (mCheckBox1.isChecked()) {
                        checkInt = 1;
                    } else if (!mCheckBox1.isChecked() && !mCheckBox2.isChecked()) {
                        checkInt = 2;
                    }

                }

                if (mOnCheckListener != null) {
                    mOnCheckListener.getCheckInt(checkInt);
                }
            }
        });

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TextTwoCheckBox);

        if (attributes != null) {
            //设置textview内容
            String string = attributes.getString(R.styleable.TextTwoCheckBox_textview_text);
            mTextView.setText(string);

            //设置textview字体颜色
            int textColor = attributes.getColor(R.styleable.TextTwoCheckBox_textview_text_color,
                    Color
                            .BLACK);
            mTextView.setTextColor(textColor);

            //设置textview字体大小
            float textviewSize = attributes.getDimension(R.styleable
                            .TextTwoCheckBox_textview_text_size,
                    LinearLayout.LayoutParams
                            .WRAP_CONTENT);
            mTextView.setTextSize(textviewSize);

            /**
             * 设置左边CheckBox
             */
            //设置标题
            String checkbox1_string = attributes.getString(R.styleable
                    .TextTwoCheckBox_checkbox1_text);
            mCheckBox1.setText(checkbox1_string);

            //设置标题颜色
            int checkbox1_textcolor = attributes.getColor(R.styleable
                            .TextTwoCheckBox_checkbox1_text_color,
                    Color.BLACK);
            mCheckBox1.setTextColor(checkbox1_textcolor);

            //设置标题大小
            float chechbox1_textsize = attributes.getDimension(R.styleable
                    .TextTwoCheckBox_checkbox1_text_size, LinearLayout.LayoutParams
                    .WRAP_CONTENT);
            mCheckBox1.setTextSize(chechbox1_textsize);


            /**
             * 设置右边CheckBox
             */

            //设置标题
            String checkbox2_string = attributes.getString(R.styleable
                    .TextTwoCheckBox_checkbox2_text);
            mCheckBox2.setText(checkbox2_string);

            //设置标题颜色
            int checkbox2_textcolor = attributes.getColor(R.styleable
                            .TextTwoCheckBox_checkbox2_text_color,
                    Color.BLACK);
            mCheckBox2.setTextColor(checkbox2_textcolor);

            //设置标题大小
            float chechbox2_textsize = attributes.getDimension(R.styleable
                    .TextTwoCheckBox_checkbox2_text_size, LinearLayout.LayoutParams
                    .WRAP_CONTENT);
            mCheckBox2.setTextSize(chechbox2_textsize);

            attributes.recycle();
        }


    }

    /**
     * 点击接口回调
     */
    public interface OnCheckListener {
        void getCheckInt(int checkInt);
    }

    OnCheckListener mOnCheckListener;

    public void setCheckBoxOnCheckListener(OnCheckListener onCheckListener) {
        this.mOnCheckListener = onCheckListener;
    }


    /**
     * 设置选中
     *
     * @param checkInt
     */
    public void setCheckInt(int checkInt) {
        if (checkInt == 0) {
            mCheckBox1.setChecked(true);
            mCheckBox2.setChecked(false);
        } else if (checkInt == 1) {
            mCheckBox1.setChecked(false);
            mCheckBox2.setChecked(true);
        } else if (checkInt == 2) {
            mCheckBox1.setChecked(false);
            mCheckBox2.setChecked(false);
        }
        this.checkInt = checkInt;
    }

    /**
     * 设置模式
     * 必选模式 MODE_MANDATORY = 0;
     * //可选模式
     * public static final int MODE_OPTIONAL = 1;
     *
     * @param mode
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * 获取选中的CheckBox
     * 1：左边CheckBox
     * 2：右边CheckBox
     *
     * @return
     */
    public int getCheckInt() {
        return checkInt;
    }

    public CheckBox getCheckBox1() {
        return mCheckBox1;
    }

    public CheckBox getCheckBox2() {
        return mCheckBox2;
    }

    public TextView getTextView() {
        return mTextView;
    }
}

