package sjtu.edu.uavm_a6;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button playButton ;
    VideoView videoView ;
    EditText rtspUrl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rtspUrl = this.findViewById(R.id.url);
        //final String URL = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
        playButton = this.findViewById(R.id.start_play);
        videoView = this.findViewById(R.id.rtsp_player);
        playButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                PlayRtspStream(rtspUrl.getEditableText().toString());
                //PlayRtspStream(URL);
            }
        });
    }
    private void PlayRtspStream(String rtspUrl){
        videoView.setVideoURI(Uri.parse(rtspUrl));
        videoView.requestFocus();
        videoView.start();
    }
}
