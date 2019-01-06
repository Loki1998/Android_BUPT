package cui.bupt.gameapp;

import android.support.v7.app.AppCompatActivity; import android.os.Bundle; import android.content.Intent;

import android.view.View;

import android.widget.ProgressBar;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity { private ProgressBar pb1;

    private ProgressBar pb2;

    private ProgressBar pb3;

    private TextView tv_main_life;

    private TextView tv_main_atk;

    private TextView tv_main_speed;

    private TextView main_tv_1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(MainActivity.this,MusicServer.class);
        super.onCreate(savedInstanceState);
        startService(intent);

        setContentView(R.layout.activity_main);

//显示 username

        Intent intent1=getIntent();

        Bundle bundle=intent1.getExtras();//.getExtras()得到 intent 所附带的额外数据

        String str=bundle.getString("username");//getString()返回指定 key 的值 main_tv_1=(TextView) findViewById(R.id.main_tv_1);//用 TextView 显示值main_tv_1.setText(str+"的乔巴酱");

//(1)找到我们关心的控件

        pb1 = (ProgressBar) findViewById(R.id.progressBar1); pb2 = (ProgressBar) findViewById(R.id.progressBar2); pb3 = (ProgressBar) findViewById(R.id.progressBar3);

        tv_main_life = (TextView) findViewById(R.id.tv_main_life);

        tv_main_atk = (TextView) findViewById(R.id.tv_main_atk);

        tv_main_speed = (TextView) findViewById(R.id.tv_main_speed);

//(2)初始化进度条的最大值

        pb1.setMax(1000);

        pb2.setMax(1000);

        pb3.setMax(1000);


    }

    public void click(View v) {

        Intent intent = new Intent(this, ShoppingActivity.class); startActivityForResult(intent, 1);

    }

//当我们开启的 Activity 关闭的时候调用这个方法

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data); //(1)代表数据来源于 shoppingActivity 取数据

        ItemInfo info = (ItemInfo) data.getExtras().get("info"); //（2）更新一下 UI

        updateProgressBar(info);

    }

//更新当前控件的 UI

    private void updateProgressBar(ItemInfo info) { //(1)获取当前 progressbar 的进展

        int progress1 = pb1.getProgress();

        int progress2 = pb2.getProgress();

        int progress3 = pb3.getProgress();

//(2)更新一下 progressbar 的进展

        pb1.setProgress(progress1 + info.getLife());

        pb2.setProgress(progress2 + info.getAcctack());

        pb3.setProgress(progress3 + info.getSpeed());

//更新一下 textview 的值

        tv_main_life.setText(pb1.getProgress() + "");

        tv_main_atk.setText(pb2.getProgress() + "");

        tv_main_speed.setText(pb3.getProgress() + "");

    }


    protected void onStop(){
        Intent intent = new Intent(MainActivity.this,MusicServer.class);
        stopService(intent);
        super.onStop();

    }

}