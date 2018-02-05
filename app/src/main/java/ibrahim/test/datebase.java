package ibrahim.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by prog_ibrahim on 1/9/2018.
 */

public class datebase extends SQLiteOpenHelper {

    private static String database_name = "SPuzzle";
    private static String table_name = "GamePuzzle";
    public Context Pcontext;
    public datebase(Context context) {
       super(context, database_name, null, 1);
        Pcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            this.createtable(db);
            this.Insert(db);
        }
        catch (Exception e)
        {

        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


    public void createtable(SQLiteDatabase db)
    {
        String createtable = "CREATE TABLE "+table_name+" ( Puzzleeasy INTEGER ,PuzzleId INTEGER PRIMARY KEY AUTOINCREMENT , PuzzleMid INTEGER , Puzzlehard INTEGER );";
        db.execSQL(createtable);
    }

    public void  Insert(SQLiteDatabase db)
    {
        ContentValues CV = new ContentValues();
        for (int i = 1; i<85;i++)
        {
            CV.put("Puzzleeasy",0);
            CV.put("PuzzleId",i);
            CV.put("PuzzleMid",0);
            CV.put("Puzzlehard",0);
            db.insert(table_name,null,CV);
            CV.clear();
        }

    }


    public void update(String col,int Id )
    {
        SQLiteDatabase db = MainActivity.db.getWritableDatabase();
        ContentValues CV = new ContentValues();
        CV.put(col,1);
        String where []= new String[]{""+ Id};
        db.update(table_name,CV,"PuzzleId = ?", where);
    }


    public int select(String col,int Id )
    {
        SQLiteDatabase db = MainActivity.db.getWritableDatabase();
        Cursor cursor = db.query(table_name, new String[]{col},"PuzzleId = "+Id,null,null,null,null);
        while(cursor.moveToNext())
            return cursor.getInt(0);
        return -1;
    }


}
