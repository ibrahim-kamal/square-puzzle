package ibrahim.test;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Math.sqrt;

public class gamePlayActivity extends AppCompatActivity {
    public static  int sequere ;
    public static  String numbergame ;
    public static  int X ;
    public static  int Y ;
    public static int puzzle[][];
    public static int goalpuzzle[][];
    public static int Dpuzzle[];
    public static int movegame;
    public static int Poslastpart;
    public static int morppos ;

    public static int numbershuffle;
    public static Bitmap b[];
    public static int[] allimages;
    public void setPuzzle()
    {
        int n = (int) sqrt(this.sequere);
        puzzle = new int[n][n];
        int i,l, index = 1;
        for (i =0;i<n;i++)
        {
            for (l =0;l<n;l++)
            {
                puzzle[i][l] = index;
                index++;
            }
        }

    }


    public int[] getZero()
    {
        int i,l;
        int arr[] = new int[2];
        int n = (int) sqrt(this.sequere);
        for (i =0;i<n;i++)
        {
            for (l =0;l<n;l++)
            {
                if(puzzle[i][l] == sequere)
                {
                    arr[0]= i;
                    arr[1]= l;
                }
            }
        }
        return arr;
    }

    public int[][] getposoblestateGui(int PosA[])
    {
        int arr[][] = new int[4][2];
        int num = ((int) sqrt(sequere))-1;
        int col = PosA[0],row= PosA[1];
        int i = 0;
        if (col > 70)
        {
            arr[i][0]= col - morppos;
            arr[i][1]= row ;
            i++;
        }
        if (row > 70)
        {
            arr[i][0]= col ;
            arr[i][1]= row -morppos;
            i++;
        }
        if (col < Poslastpart)
        {
            arr[i][0]= col +morppos;
            arr[i][1]= row ;
            i++;
        }
        if (row < Poslastpart)
        {
            arr[i][0]= col ;
            arr[i][1]= row +morppos;
            i++;
        }
        return arr;
    }

    public int[][] getposoblestate(int PosA[])
    {
        int arr[][] = new int[4][2];
        int num = ((int) sqrt(sequere))-1;
        int col = PosA[0],row= PosA[1];
        int i = 0;
        if (col > 0)
        {
            arr[i][0]= col - 1;
            arr[i][1]= row ;
            i++;
        }
        if (row > 0)
        {
            arr[i][0]= col ;
            arr[i][1]= row -1;
            i++;
        }
        if (col < num)
        {
            arr[i][0]= col +1;
            arr[i][1]= row ;
            i++;
        }
        if (row < num)
        {
            arr[i][0]= col ;
            arr[i][1]= row +1;
            i++;
        }
        while (i<4)
        {
            arr[i][0]= -1 ;
            arr[i][1]= -1;
            i++;
        }
        return arr;
    }

    public void swap(int PosA[],int PosB[])
    {
        int num = puzzle[PosA[0]][PosA[1]];
        puzzle[PosA[0]][PosA[1]] = puzzle[PosB[0]][PosB[1]];
        puzzle[PosB[0]][PosB[1]] = num;
    }



    public void shuffle()
    {
        setPuzzle();
        int i = 0;
        while(i<numbershuffle)
        {
            int y=0,x =0;
            int Pos[][] = getposoblestate(this.getZero());
            while (x<4)
            {
                if(Pos[x][0] != -1)
                {
                   y++;
                }
                x++;
            }
            Random rn = new Random();
            int random = rn.nextInt(y);
            swap(Pos[random],this.getZero());
            i++;

        }
    }

    public void setDpuzzle()
    {
        int i,l ,n = (int) sqrt(this.sequere);
        this.Dpuzzle = new int[this.sequere];
        int a = 0;
        for (i =0;i<n;i++)
        {
            for (l =0;l<n;l++)
            {
                this.Dpuzzle[a] = puzzle[i][l];
                a++;
            }
        }
    }


    public void islastsequre()
    {
        int num = sequere - 1;
        if(this.Dpuzzle[num] == sequere)
        {
            this.X = this.Poslastpart;
            this.Y = this.Poslastpart;
        }
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ////
            gamePlayActivity.b = splitphoto();

        ////
        super.onCreate(savedInstanceState);
        goalpuzzle = new int[sequere][2];
//        int images [] ;
//        if (gameActivity.gamecol == "Puzzleeasy")
//        {
//             images = new int []{ R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8};
//        }
//        else if(gameActivity.gamecol == "PuzzleMid")
//        {
//            images = new int []{ R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b7,R.drawable.b8, R.drawable.b9,R.drawable.b10,R.drawable.b11,R.drawable.b12,R.drawable.b13,R.drawable.b14,R.drawable.b15};
//        }
//        else{
//            images  = new int []{ R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8, R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,R.drawable.c15,R.drawable.c16,R.drawable.c17,R.drawable.c18,R.drawable.c19,R.drawable.c20,R.drawable.c21,R.drawable.c22,R.drawable.c23,R.drawable.c24};
//        }
//        int images [] = new int[sequere-1];
//        images[0] = R.drawable.a1;
//        for (int count=1;count<(sequere-1);count++)
//            images[count] = images[count-1] + 1;
        shuffle();
        setDpuzzle();
        setContentView(R.layout.gameplay);
        final RelativeLayout re = (RelativeLayout) findViewById(R.id.Re);
        int Startwidth = 70;
        int startheight = 70;
        int Pwidth = 70;
        int Pheight = 70;
        int width = morppos;
        int height = morppos;
        ImageView iv[] = new ImageView[sequere-1];
        int ii =0;
        for (int i =0;i<sequere-1;i++)
        {
            goalpuzzle[i][0] =Pwidth;
            goalpuzzle[i][1] =Pheight;
            if(this.Dpuzzle[ii]!=this.sequere)
            {
                iv[i] = new ImageView(this);

                //iv[i].setImageResource(images[(this.Dpuzzle[ii])-1]);
                iv[i].setImageBitmap(b[(this.Dpuzzle[ii])-1]);

                iv[i].setY(startheight);
                iv[i].setX(Startwidth);
                iv[i].setLayoutParams(new Toolbar.LayoutParams(width, height));
                iv[i].setId((this.Dpuzzle[ii])-1);
                iv[i].setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        if (!isgoal())
                        {
                            move(view);
                            if(isgoal())
                            {
                                Toast.makeText(getBaseContext(),"congratulations",Toast.LENGTH_LONG).show();
                                MainActivity.db.update(gameActivity.gamecol,Integer.parseInt(gamePlayActivity.numbergame));
                                ImageView iv = new ImageView(getBaseContext());
                                iv.setImageBitmap(gamePlayActivity.b[gamePlayActivity.sequere-1]);
                                iv.setY(gamePlayActivity.Y);
                                iv.setX(gamePlayActivity.X);
                                iv.setLayoutParams(new Toolbar.LayoutParams(morppos, morppos));
                                iv.setId(sequere);
                                re.addView(iv);
                            }
                        }
                    }
                });
                re.addView(iv[i]);

                Pwidth = Pwidth + width;
                if (((i + 1) % sqrt(sequere)) == 0) {
                    Pwidth = 70;
                    Pheight = Pheight + height;
                }
            }
            else
            {
                this.X = Startwidth;
                this.Y = startheight;
                i--;
            }
            Startwidth = Startwidth + width;
            if (((ii + 1) % sqrt(sequere)) == 0) {
                Startwidth = 70;
                startheight = startheight + height;
            }
            ii++;


        }

        this.islastsequre();


    }

    public boolean isgoal()
    {
        int i;
        for (i=0;i<(sequere-1);i++)
        {
            ImageView iv = (ImageView) findViewById(i);
            if(((int)iv.getX()) == goalpuzzle[i][0] && ((int)iv.getY()) == goalpuzzle[i][1])
            {

            }
            else
                return false;
        }
        return true;
    }

    public void move(View v)
    {
        ImageView iv = (ImageView) findViewById(v.getId());
        int widthX = this.X;
        int heightY = this.Y;
        int width1 = (int) iv.getX();
        int height1 = (int) iv.getY();
        int width = (int) iv.getX();
        int height = (int) iv.getY();
        int y=0,x =0;
        int Pos[][] = getposoblestateGui(new int[]{widthX,heightY});
        int flag = 0;
        while (x<4)
        {
            if(Pos[x][0] != 0 || Pos[x][1] !=0)
            {

                //Toast.makeText(getBaseContext(),"EX = "+Pos[x][0] +" EY = "+Pos[x][1],Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(),"SX = "+width +"   SY = "+height,Toast.LENGTH_LONG).show();

               if(Pos[x][0] == width && Pos[x][1] == height)
               {
                   while(flag == 0 && width < widthX)
                   {
                       width+=movegame;
                       iv.setX(width);
                       x = 5;
                       if(width == widthX)
                       flag = 1;

                   }
                   while(flag == 0 && height < heightY)
                   {
                       height +=movegame;
                       iv.setY(height);
                       x = 5;
                       if (height == heightY)
                       flag = 1;

                   }
                   while(flag == 0 && width > widthX)
                   {
                       width-=movegame;
                       iv.setX(width);
                       x = 5;
                       if(width == widthX)
                       flag = 1;

                   }
                   while(flag == 0 && height > heightY)
                   {

                       height -=movegame;
                       iv.setY(height);
                       x = 5;
                       if (height == heightY)
                       flag = 1;

                   }

                   this.X = width1;
                   this.Y = height1;
                   break;
               }
            }
            x++;
        }

    }

    public void back(View v)
    {
        Intent i = new Intent(this,gameActivity.class);
        startActivity(i);
        finish();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Bitmap[] splitphoto()
    {
        allimages = new int[]{R.drawable.x1, R.drawable.x2, R.drawable.x3, R.drawable.x4, R.drawable.x5, R.drawable.x6, R.drawable.x7, R.drawable.x8, R.drawable.x9, R.drawable.x10, R.drawable.x11, R.drawable.x12, R.drawable.x13, R.drawable.x14, R.drawable.x15, R.drawable.x16, R.drawable.x17, R.drawable.x18, R.drawable.x19, R.drawable.x20, R.drawable.x21, R.drawable.x22, R.drawable.x23, R.drawable.x24, R.drawable.x25, R.drawable.x26, R.drawable.x27, R.drawable.x28, R.drawable.x29, R.drawable.x30, R.drawable.x31, R.drawable.x32, R.drawable.x33, R.drawable.x34, R.drawable.x35, R.drawable.x36, R.drawable.x37, R.drawable.x38, R.drawable.x39, R.drawable.x40, R.drawable.x41, R.drawable.x42, R.drawable.x43, R.drawable.x44, R.drawable.x45, R.drawable.x46, R.drawable.x47, R.drawable.x48, R.drawable.x49, R.drawable.x50, R.drawable.x51,R.drawable.x52, R.drawable.x53, R.drawable.x54, R.drawable.x55, R.drawable.x56, R.drawable.x57, R.drawable.x58, R.drawable.x59, R.drawable.x60, R.drawable.x61, R.drawable.x62, R.drawable.x63, R.drawable.x64, R.drawable.x65, R.drawable.x66, R.drawable.x67, R.drawable.x68, R.drawable.x69, R.drawable.x70, R.drawable.x71, R.drawable.x72, R.drawable.x73, R.drawable.x74, R.drawable.x75, R.drawable.x76, R.drawable.x77, R.drawable.x78, R.drawable.x79, R.drawable.x80, R.drawable.x81, R.drawable.x82, R.drawable.x83, R.drawable.x84,R.drawable.x85};
        Bitmap bm []= new Bitmap[sequere];
        int startwidth  = 0;
        int startheight = 0;
        int numgame = Integer.parseInt(gamePlayActivity.numbergame) - 1 ;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),allimages[numgame]);
        int number = ((int)sqrt(sequere));
        int partwidth = bitmap.getWidth()/number;
        int partheight = bitmap.getHeight()/number;
        int heightandwidth = 2700/number;
        Bitmap mBitmap;
        for (int i = 0;i<sequere;i++)
        {
            mBitmap = Bitmap.createBitmap(bitmap, startwidth,startheight, partwidth, partheight);
            startwidth = startwidth + partwidth;
            bm[i] = mBitmap;
            if (((i+1)%(sqrt(sequere))) ==0 )
            {
                startwidth = 0;
                startheight = startheight + partheight;
            }
        }
      return  bm;
    }


    public void showImage(View v)
    {
        final Button show =(Button)findViewById(v.getId());
        show.setVisibility(View.INVISIBLE);
        int numgame = Integer.parseInt(gamePlayActivity.numbergame) - 1 ;
        RelativeLayout re = (RelativeLayout) findViewById(R.id.Re);
        final RelativeLayout newre = new RelativeLayout(getBaseContext());
        newre.setLayoutParams(new Toolbar.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 1200));
        newre.setX(0);
        newre.setY(0);
        re.addView(newre);
        ImageView iv = new ImageView(getBaseContext());
        iv.setImageResource(allimages[numgame]);
        iv.setY(70);
        iv.setX(70);
        iv.setLayoutParams(new Toolbar.LayoutParams(900, 900));
        iv.setId(sequere+1);
        newre.addView(iv);
        Button close = new Button(getBaseContext());
        close.setY(1000);
        close.setX(400);
        close.setText("close");
        close.setLayoutParams(new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView iv = (ImageView) findViewById(sequere+1);
                RelativeLayout re = (RelativeLayout)findViewById(R.id.Re);
                newre.removeView(iv);
                newre.removeView(view);
                re.removeView(newre);
                show.setVisibility(View.VISIBLE);

            }
        });
        newre.addView(close);


    }


}
