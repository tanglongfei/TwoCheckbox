# TwoCheckbox    
很常用的双选一单选框，使用TextView+CheckBox   
很简单的一个自定义组合控件，很多属性不是很全，可参考进行拓展    

![image](https://github.com/tanglongfei/TwoCheckbox/blob/master/image/2018-01-18_09-49-36.gif)  
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
	  implementation 'com.github.tanglongfei:TwoCheckbox:V1.0'
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
