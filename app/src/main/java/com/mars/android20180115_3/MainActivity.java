package com.mars.android20180115_3;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/*
SharedPreferences是一個簡單又好用的類別，可以將資料儲存到手機之中，
透過Key Value的形式來儲存，如果你的資料不太複雜，懶得使用資料庫的話，
可以試著使用SharedPreferences來儲存內容。

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v)
    {
        //取得SharedPreferences ， 丟入的參數為("名稱" , 存取權限)
        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);
        //由 SharedPreferences 中取出 Editor 物件，透過 Editor 物件將資料存入
        SharedPreferences.Editor editor = sp.edit();
        EditText ed = (EditText) findViewById(R.id.editText);
        //存入資料，丟入的參數為(key , value)
        editor.putString("data1", ed.getText().toString());
        editor.commit();
    }
    public void click2(View v)
    {
        //取得SharedPreferences ， 丟入的參數為("名稱" , 存取權限)
        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);
        String str = sp.getString("data1", "");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(str);

        /*
       //透過 KEY_BOOL key 取出 boolean 型態的資料，若資料不存在則回傳 true
        boolean booValue = spref.getBoolean("KEY_BOOL", true);

        //透過 KEY_FLOAT key 取出 float 型態的資料，若資料不存在則回傳 0
        float floatValue = spref.getFloat("KEY_FLOAT", 0);

        //透過 KEY_LONG key 取出 long 型態的資料，若資料不存在則回傳 0
        long longValue = spref.getLong("KEY_LONG", 0);

        //透過 KEY_STRING key 取出字串型態的資料，若資料不存在則回傳 null
        String strValue = spref.getString("KEY_STRING", null);
             */
    }
}
