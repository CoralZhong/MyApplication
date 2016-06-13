package com.example.administrator.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.TtsMode;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Speaker extends BaseActivity {
    EditText et;
    SpeechSynthesizer ss;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.spraker);
        et = (EditText) findViewById(R.id.whattobespeak);
        ss = SpeechSynthesizer.getInstance();
        ss.setContext(this);
        ss.setAppId("7934301");
        ss.setApiKey("mF30Ge9lZS6q1ClMrYMczr3tVnOxP7P1", "Ci0K4l51f9trzM5Ku2shpLf2MriiaWq7");
        ss.initTts(TtsMode.ONLINE);

    }
    public void speak(View view){
        ss.speak(et.getText().toString());
    }
}
