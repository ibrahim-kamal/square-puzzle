package ibrahim.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class playActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);


    }

    public void start(View v)
    {
        gameActivity GA = new gameActivity();
        Button b = (Button) findViewById(v.getId());
        String s = (String) b.getText();
        this.setGamecolor(s);
        Intent i = new Intent(this,gameActivity.class);
        startActivity(i);
        finish();
    }

    public void setGamecolor(String Level)
    {
        gameActivity.gameplay = Level;
        if(Level.equals("easy"))
        {
            gameActivity.gamecolor ="#80e903";
            gamePlayActivity.sequere = 9;
            gameActivity.gamecol = "Puzzleeasy";
            gamePlayActivity.movegame = 60;
            gamePlayActivity.Poslastpart = 670;
            gamePlayActivity.morppos = 300;
            gamePlayActivity.numbershuffle = 100;
        }
        else if(Level.equals("middle"))
        {
            gameActivity.gamecolor ="#e1d600";
            gamePlayActivity.sequere = 16;
            gameActivity.gamecol = "PuzzleMid";
            //change
            gamePlayActivity.movegame = 45;
            gamePlayActivity.Poslastpart = 745;
            gamePlayActivity.morppos = 225;
            gamePlayActivity.numbershuffle = 200;

            //
        }
        else
        {
            gameActivity.gamecolor ="#f06341";
            gamePlayActivity.sequere = 25;
            gameActivity.gamecol = "Puzzlehard";
            //change
            gamePlayActivity.movegame = 36;
            gamePlayActivity.Poslastpart = 790;
            gamePlayActivity.morppos = 180;
            gamePlayActivity.numbershuffle = 400;  //
        }
    }


    public void back(View v)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }



}
