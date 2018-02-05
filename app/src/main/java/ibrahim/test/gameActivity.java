package ibrahim.test;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class gameActivity extends AppCompatActivity {
    public static  String gameplay;
    public static String gamecolor;;
    public String wingame = "#0f0cd6";
    public static String gamecol ;



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        RelativeLayout re = (RelativeLayout) findViewById(R.id.Re);
        this.createStep(re);



    }

    public void back(View v)
    {
        Intent i = new Intent(this,playActivity.class);
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public void createStep(final RelativeLayout re)
    {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int w = displayMetrics.widthPixels;
        int startWidth= 35,endWidth;
        int startHeight= 10;
        final TextView t[] = new TextView[84];
        int i = 0, n = 1;
        while(i<84)
        {
            String oldcolor = this.gamecolor;;
                int check = MainActivity.db.select(gamecol,(i+1));
            if (check == 1) // condtion --------------------------------------------------------------------------------------
            {
                this.gamecolor  = this.wingame;
            }
            t[i] = new TextView(this);
            t[i].setHeight(100);
            t[i].setWidth(140);
            t[i].setText(""+(i+1));
            t[i].setX(startWidth);
            t[i].setY(startHeight);
            t[i].setTextSize(24);
            t[i].setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            t[i].setBackgroundColor(Color.parseColor(this.gamecolor));
            t[i].setId(i);
            re.addView(t[i]);

            t[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    TextView tv = (TextView) findViewById(v.getId());
                    gamePlayActivity.numbergame = (String) tv.getText();
                    gotogameplay();
                }
            });

            startWidth = startWidth +145;
            endWidth= startWidth +145;
            i++;
            if(endWidth > w)
            {
                startWidth = 35;
                startHeight = startHeight +105;
            }

            this.gamecolor  = oldcolor;
        }

        Button back = (Button) findViewById(R.id.button3);
        back.setWidth(300);
        back.setY(startHeight);
        back.setX(w/2 -150);
    }

    private void gotogameplay() {
        Intent i = new Intent(this,gamePlayActivity.class);
        startActivity(i);
        finish();
    }


}
