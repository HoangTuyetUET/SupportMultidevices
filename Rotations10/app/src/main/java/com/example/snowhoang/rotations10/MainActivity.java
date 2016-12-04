package com.example.snowhoang.rotations10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        ll = (LinearLayout) findViewById(R.id.mainlayout);

        btn.setOnClickListener(new onClickListener());
        // add a TextView to the bottom of a vertical LinearLayout
        tv=new TextView(this);
        this.ll.addView(tv);

    }
    private class onClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view){
            tv.setText(et.getText().toString());
        }
    }
    //When you rotate the app, make sure that the TextView text is preserved
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv.setText(savedInstanceState.getString(et.getText().toString()));
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(et.getText().toString(),tv.getText().toString());
    }

    private EditText et;
    private Button btn;
    private LinearLayout ll;
    private TextView tv;
}
