package cui.bupt.callapp;

import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;
import android.view.View.OnClickListener;



public class MainActivity extends AppCompatActivity {
    private Button makeCall;
    private Button makeMessage;
    private EditText mobileText;
    private EditText messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileText = (EditText) this.findViewById(R.id.editText);
        makeCall = (Button) this.findViewById(R.id.button2);
        makeMessage = (Button) this.findViewById(R.id.button3);
        messageText = (EditText) this.findViewById(R.id.editText3);
        makeCall.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                makeC();
            }
        });
        makeMessage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                makeM();
            }
        });
    }

/*    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.makeCall:
                makeC();
                break;
            case R.id.makeMessage:
                makeM();
                break;
            default:
                break;
        }
    }*/

    private void makeM() {
        String number = mobileText.getText().toString().trim();
        String content = messageText.getText().toString().trim();
        if (TextUtils.isEmpty(number) || TextUtils.isEmpty(content)) {
            Toast.makeText(this, "电话号码或内容不能为空...", Toast.LENGTH_SHORT).show();
            return;
        } else {
            SmsManager smsManager = SmsManager.getDefault();
            List<String> contents = smsManager.divideMessage(content);
            for (String str : contents) {
                smsManager.sendTextMessage(number, null, str, null, null);
            }
        }
    }

    private void makeC() {
        String number = mobileText.getText().toString().trim();
        if (TextUtils.isEmpty(number)) {
            Toast.makeText(MainActivity.this, "号码不能为空...", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }
}
//                String mobile=mobileText.getText().toString();
//                Intent intent=new Intent();
//                intent.setAction(Intent.ACTION_CALL);
//                intent.setData(Uri.parse("tel:"+mobile));
//                startActivity(intent);

