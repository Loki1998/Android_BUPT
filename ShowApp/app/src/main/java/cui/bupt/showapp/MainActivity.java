package cui.bupt.showapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


/*

    private String filename = null;
    private Button startCard = null;
    private Button startUri = null;
    private TextView fileName = null;
    private VideoView video = null;
    private MediaController media = null;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        //music
        Intent intent = new Intent(MainActivity.this,MusicServer.class);
 /*       //video
        filename= Environment.getExternalStorageDirectory()+"/Pictures/video.mp4";
        startCard=(Button)findViewById(R.id.startCard);
        startUri=(Button)findViewById(R.id.startUri);
        fileName=(TextView)findViewById(R.id.fileName);
        media=new MediaController(MainActivity.this);
        startCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideoFromFile();
            }
        });
        startUri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVideoFromUri();
            }
        });*/



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ComicAdapter teacherAdapter = new ComicAdapter(this, R.layout.comic_item, Comic.getAllComics());
        ListView listView = (ListView) findViewById(R.id.comic_ListView);
        listView.setAdapter(teacherAdapter);

        startService(intent);
    }
    public void onClick(View v) {
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }
    public void onClick1(View v) {
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
    }


    protected void onStop() {
        Intent intent = new Intent(MainActivity.this, MusicServer.class);
        stopService(intent);
        super.onStop();
    }
 /*   private void playVideoFromFile(){
        if(startCard.getText().toString().equals("PlayCard")) {
            File file = new File(filename);
            if (file.exists()) {
                //将VideoView与MediaController进行关联
                video.setVideoPath(file.getAbsolutePath());
                video.setMediaController(media);
                media.setMediaPlayer(video);
                //让VideoView获取焦点
                video.requestFocus();
                video.start();
                startCard.setText(R.string.pauseCard);
                fileName.setText(filename);
            }
        }
        else {
            video.pause();
            startCard.setText(R.string.startCard);
        }
    }

    private void openVideoFromUri(){
        if(startUri.getText().toString().equals("PlayUri")) {
            Uri uri = Uri.parse(filename);
            video.setVideoURI(uri);
            video.setMediaController(media);
            media.setMediaPlayer(video);
            //同上
            video.requestFocus();
            video.start();
            startUri.setText(R.string.pauseUri);
            fileName.setText(filename);
        }
        else {
            video.pause();
            startUri.setText(R.string.startUri);
        }
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "app的作者是崔宏基", Toast.LENGTH_LONG).show();
              return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
