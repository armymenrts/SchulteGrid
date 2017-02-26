package yuhui.a25.a441.schultegrid;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Random;


public class GameLayout extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout root;
    private WrongAction wrongAction=new WrongAction();
    public Button button;
    private int time=0;
    private TextView textView;
    final Handler handler = new Handler();
    private int a=1,width,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wrongAction.setDuration(500);
        textView=new TextView(this);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(25);
        /*
        初始化计时器
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                time++;
                handler.postDelayed(this,1000);
                textView.setGravity(Gravity.CENTER);
                textView.setText("已用时间："+time+"秒");
            }
        };
        handler.postDelayed(runnable,1000);


        DisplayMetrics metrics = new DisplayMetrics();//获取屏幕宽高
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;


        root=new LinearLayout(this);
        root.setBackgroundColor(Color.parseColor("#333232"));
        root.setOrientation(LinearLayout.VERTICAL);
        setContentView(root);

        CreatGrid(MainActivity.a);

    }
    private void CreatGrid(int RowsAndCols){
        int a =0;
        int[] num=new int[RowsAndCols*RowsAndCols];
        Random random=new Random();
        LinearLayout row;
        LinearLayout.LayoutParams rowconfing =new LinearLayout.LayoutParams(300,300);
        LinearLayout.LayoutParams rootconfing=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height/RowsAndCols);
        rootconfing.setMargins(0,0,0,0);
        rowconfing.setMargins(0,0,0,0);
        rootconfing.weight=1;
        rowconfing.weight=1;
        for(int j=0;j<RowsAndCols+1;j++) {//添加线性布局

            row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            if (j == 0) {//添加显示的计时器
                row.addView(textView,rootconfing);
                root.addView(row, rootconfing);
            } else {
                for (int i = 0; i < RowsAndCols; i++) { //添加按钮
                    button = new Button(this);
                    //button.set
                    for (int n = 0; n < RowsAndCols * RowsAndCols; n++) {
                        a = (random.nextInt(RowsAndCols * RowsAndCols) + 1);//产生随机数
                        if (num[a - 1] == 1) n--;
                    }
                    num[a - 1] = 1;
                    button.setGravity(Gravity.CENTER);
                    button.setText("" + a);
                    button.setOnClickListener(this);
                    row.addView(button, rowconfing);
                }
                root.addView(row, rootconfing);
            }
        }
    }

    @Override
    public void onClick(View v) {//按钮按下事件

        Button b=(Button)v;
        if(b.getText().equals(a+"")) {
            System.out.println("2333");
            v.setVisibility(View.INVISIBLE);
            if (a==MainActivity.a*MainActivity.a){
                Intent intent = new Intent(GameLayout.this,Win.class);
                intent.putExtra("score",time);
                startActivity(intent);
                finish();
            }
            a++;
        }
        else {
            v.startAnimation(wrongAction);//错误动画
        }
    }
}
