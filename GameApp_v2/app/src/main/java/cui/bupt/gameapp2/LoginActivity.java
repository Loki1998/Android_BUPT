package cui.bupt.gameapp2;

import android.content.Intent;

import android.os.Bundle;

import android.support.annotation.Nullable; import android.support.v7.app.AppCompatActivity; import android.view.View; import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }

    public void gomain(View v){

        String str= ((TextView)findViewById(R.id.et1)).getText().toString();

        Intent intent=new Intent(this,MainActivity.class);

        intent.putExtra("username",str);

        startActivity(intent);

    }

}