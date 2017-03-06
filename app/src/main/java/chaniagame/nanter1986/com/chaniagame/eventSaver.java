package chaniagame.nanter1986.com.chaniagame;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class eventSaver extends SQLiteOpenHelper{

    private static final String DB_NAME = "eventSaver.db";
    private static final int DB_VERSION = 1;

     eventSaver(Context context){

         super(context,DB_NAME,null,DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  IF NOT EXISTS EVENT" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME,VALUE)");






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "EVENT");
        onCreate(db);
    }

    public String readEvent(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query("EVENT",
                new String[]{"NAME", "VALUE"},
                "NAME = ?",
                new String[] {name},
                null,
                null,
                null);
        c.moveToFirst();
        String vl = c.getString(c.getColumnIndex("VALUE"));
        c.close();
        return vl;
    }

    public void updateEvent(String name,String newValue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("VALUE",newValue);
        db.update("EVENT",
                cv,
                "NAME = ?",
                new String[]{name});
    }

    public void addToTable(String name,String value){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues l = new ContentValues();
        l.clear();
        l.put("NAME",name);
        l.put("VALUE",value);
        db.insert("EVENT",null,l);

    }

    public boolean checkExistence(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            Cursor c = db.query("EVENT",
                    new String[]{"NAME", "VALUE"},
                    "NAME = ?",
                    new String[]{name},
                    null,
                    null,
                    null);
            if (c.equals(null)) {
                c.close();
                return false;

            } else {
                c.close();
                return true;
            }

        } catch (SQLiteException ex){
            return false;
        }

    }

    public void deleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + "EVENT");
    }
}
