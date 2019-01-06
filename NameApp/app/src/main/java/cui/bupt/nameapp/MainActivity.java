package cui.bupt.nameapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showView = null;
    private EditText edit = null;
    private Button but = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.but = (Button)super.findViewById(R.id.button);
        this.showView = (TextView)super.findViewById(R.id.textView);
        this.edit = (EditText)super.findViewById(R.id.editText);
        this.edit.setOnClickListener(new OnClickListenerImpl());
        this.edit.setOnFocusChangeListener(new OnFocusChangeListenerImpl());
        but.setOnClickListener(new ShowLIstener());

    }

    private class OnFocusChangeListenerImpl implements View.OnFocusChangeListener{
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(v.getId()==MainActivity.this.edit.getId()){
                if(hasFocus){
                    MainActivity.this.showView.setText("文本输入");
                }else{
                    if(MainActivity.this.edit.getText().length()>0){

                    }else{
                        MainActivity.this.showView.setText("输入内容不能为空");
                    }
                }
            }
        }
    }

    private class OnClickListenerImpl implements View.OnClickListener{
        public void onClick(View v) {
            MainActivity.this.edit.setText("");
        }
    }

    private class ShowLIstener implements View.OnClickListener{
        public  void onClick(View view){
            String info = edit.getText().toString();
            showView.setText("输入的信息是:"+info);
        }
    }
}

