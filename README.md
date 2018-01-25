# TwoCheckbox    
很常用的双选一单选框，使用TextView+CheckBox   
很简单的一个自定义组合控件，两种模式的设置，属性不是很全，可参考进行拓展   

可选模式```mTwoCheckbox.setMode(TwoCheckbox.MODE_OPTIONAL);```  
![image](https://github.com/tanglongfei/TwoCheckbox/blob/master/image/2018-01-19_16-34-16.gif) 

必选模式```mTwoCheckbox.setMode(TwoCheckbox.MODE_MANDATORY);```  
![image](https://github.com/tanglongfei/TwoCheckbox/blob/master/image/2018-01-19_16-36-06.gif)  

## 布局中使用  
```
<com.pineteree.twocheckboxlibrary.TwoCheckbox
        android:id="@+id/main_two_checkbox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:checkbox1_text="是"
        app:checkbox1_text_color="#ed1010"
        app:checkbox2_text="否"
        app:checkbox2_text_color="#2edc17"
        app:textview_text="是否完成："/>
```
## 代码中  
```
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
                SmartToast.show(checkInt + "");
            }
        });
```
## How to include    
Step 1. Add it in your root build.gradle at the end of repositories: 
```
allprojects {
        repositories {
		...
	maven { url 'https://jitpack.io' }
	             }
        }
```
Step 2. Add the dependency (Android studio3.0以下使用compile添加依赖)  
```
dependencies {
	  implementation 'com.github.tanglongfei:TwoCheckbox:v1.2'
	}
```

## 属性 
```
//标题颜色
textview_text_color" 

//标题字体大小
textview_text_size" 

//标题内容
textview_text" 

//左边CheckBox标题
checkbox1_text" 

//左边CheckBox字体颜色
checkbox1_text_color"

//左边CheckBox字体大小
checkbox1_text_size"

//右边CheckBox标题
checkbox2_text" 

//右边CheckBox字体颜色
checkbox2_text_color"

//右边CheckBox字体大小
checkbox2_text_size" 
```
