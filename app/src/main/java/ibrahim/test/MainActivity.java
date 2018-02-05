package ibrahim.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static datebase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if(displayMetrics.widthPixels < 1080)
        {
            Toast.makeText(getBaseContext(),"this app can't run in your mobile ",Toast.LENGTH_LONG).show();
            finish();
        }
        db = new datebase(getBaseContext());


    }


    public void play(View v)
    {
        Intent i = new Intent(this,playActivity.class);
        startActivity(i);
        finish();
    }

    public void exit(View v)
    {
        onBackPressed();
    }



    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you close program ?");
        builder.setCancelable(true);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }
}
