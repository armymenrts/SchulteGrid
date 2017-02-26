package yuhui.a25.a441.schultegrid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;
import com.romainpiel.shimmer.ShimmerTextView;

public class Win extends AppCompatActivity {
    TextView s3,s4,s5,s6;
    Shimmer shimmer=new Shimmer();
    ShimmerTextView shimmerTextView;//score
    ShimmerTextView shimmerTextView2;
    ShimmerButton shimmerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        s3=(TextView)findViewById(R.id.timethree);
        s4=(TextView)findViewById(R.id.timefour);
        s5=(TextView)findViewById(R.id.timefive);
        s6=(TextView)findViewById(R.id.timesix);
        shimmerTextView=(ShimmerTextView)findViewById(R.id.score);
        shimmerButton=(ShimmerButton) findViewById(R.id.shimmerButton);
        shimmerTextView2=(ShimmerTextView)findViewById(R.id.shimmerTextView);
        Intent intent=getIntent();
        int score =intent.getIntExtra("score",0);
        shimmerTextView.setText(score+"s");
        SharedPreferences sharedPreferences = getSharedPreferences("game",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int high3 = sharedPreferences.getInt("3*3",9999);
        int high4 = sharedPreferences.getInt("4*4",9999);
        int high5 = sharedPreferences.getInt("5*5",9999);
        int high6 = sharedPreferences.getInt("6*6",9999);
        switch (MainActivity.a){
            case 3:
                if(score<high3){editor.putInt("3*3",score);editor.commit();high3 = sharedPreferences.getInt("3*3",9999);}
                break;
            case 4:
                if(score<high4){editor.putInt("4*4",score);editor.commit();high4 = sharedPreferences.getInt("4*4",9999);}
                break;
            case 5:
                if(score<high5){editor.putInt("5*5",score);editor.commit();high5 = sharedPreferences.getInt("5*5",9999);}
                break;
            case 6:
                if(score<high6){editor.putInt("6*6",score);editor.commit();high6 = sharedPreferences.getInt("6*6",9999);}
                break;
        }
        s3.setText("3*3最快时间："+high3+"s");
        s4.setText("4*4最快时间："+high4+"s");
        s5.setText("5*5最快时间："+high5+"s");
        s6.setText("6*6最快时间："+high6+"s");
        shimmer.setDuration(1500);
        shimmer.start(shimmerTextView);
        shimmer.start(shimmerTextView2);
        shimmer.start(shimmerButton);
        shimmerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
