package yuhui.a25.a441.schultegrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity {
    private Shimmer tv=new Shimmer();
    private Button button;
    private ShimmerTextView shimmerTextView;
    private RelativeLayout.LayoutParams lp;
    private EditText editText;
    public static int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shimmerTextView= (ShimmerTextView)findViewById(R.id.titleTv);
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        lp = (RelativeLayout.LayoutParams)button.getLayoutParams();
        lp.setMargins(80,80,80,80);
        button.setLayoutParams(lp);
        tv.setDuration(1000);
        tv.start(shimmerTextView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"必须输入一个数字！",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, GameLayout.class);
                    a = Integer.parseInt(editText.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}
