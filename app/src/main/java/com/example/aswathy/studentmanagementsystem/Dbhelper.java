package com.example.aswathy.studentmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2/12/2019.
 */
public class Dbhelper extends SQLiteOpenHelper {
    public static final String Dbname = "Mydb.db";
    public static final String Tablename = "Register";
    public static final String col1 = "id";
    public static final String col2 = "name";
    public static final String col3 = "email";
    public static final String col4 = "mob";
    public static final String col5 = "uname";
    public static final String col6 = "psd";



//  StudentRegistration data

    public static final String Tablename1 = "StudentRegister";
    public static final String col01 = "id";
    public static final String col02 = "studname";
    public static final String col03 = "address";
    public static final String col04 = "sex";
    public static final String col05 = "college";
    public static final String col06 = "dob";
    public static final String col07 = "mail";
    public static final String col08 = "mobileno";
    public static final String col09 = "place";
    public static final String col10 = "district";
    public static final String col11 = "state";


    // admintable

    public static final String Tablename2 = "adminupdate";
    public static final String col011 = "id";
    public static final String col021 = "examdate";
    public static final String col022 = "examresult";
    public static final String col023 = "branch";



//    notification




    public Dbhelper(Context context) {
        super(context, Dbname, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + Tablename + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text)";
        sqLiteDatabase.execSQL(query);

//StudentRegistration

        String query1 = "create table " + Tablename1 + "(" + col01 + " integer primary key autoincrement," + col02 + " text," + col03 + " text," + col04 + " text," + col05 + " text," + col06 + " text," + col07 + " text," + col08 + " text," + col09 + " text," + col10 + " text," +col11+ " text)";
        sqLiteDatabase.execSQL(query1);

//         adminupdate

        String query2 = "create table " + Tablename2 + "(" + col011 + " integer primary key autoincrement," + col021 + " text," + col022 + " text," + col023 + " text)";
        sqLiteDatabase.execSQL(query2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exit" + Tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

//   StudentRegistration
        String query1 = "drop table if exit" + Tablename1;
        sqLiteDatabase.execSQL(query1);
        onCreate(sqLiteDatabase);

//        admin

        String query2 = "drop table if exit" + Tablename2;
        sqLiteDatabase.execSQL(query2);
        onCreate(sqLiteDatabase);



    }



    public boolean insertdata(String name, String email, String mobno, String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, name);
        contentValues.put(col3, email);
        contentValues.put(col4, mobno);
        contentValues.put(col5, username);
        contentValues.put(col6, password);


        long status = sqLiteDatabase.insert(Tablename, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }


    //        StudentRegistration insertion code

    public boolean insertdata1(String studname, String address, String sex, String college, String dob,String mail, String mobileno, String place, String district,String state) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col02, studname);
        cv.put(col03, address);
        cv.put(col04, sex);
        cv.put(col05, college);
        cv.put(col06, dob);
        cv.put(col07, mail);
        cv.put(col08, place);
        cv.put(col09, district);
        cv.put(col10, state);



        long status = sqLiteDatabase.insert(Tablename1, null, cv);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }



//    admin insert

    public boolean insertdata2(String examdate,String examresult,String branch) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put(col021,examdate);
        cv1.put(col022,examresult);
        cv1.put(col023,branch);


        long status = sqLiteDatabase.insert(Tablename2, null, cv1);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }

//retrieve

    public Cursor searchdata(String name)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cur=sqLiteDatabase.rawQuery("SELECT * FROM "+Tablename+" WHERE "+col2+"='"+name+"'",null);
        return cur;

    }

//    retrivestudname

    public Cursor searchdata4(String studname)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cur=sqLiteDatabase.rawQuery("SELECT * FROM "+Tablename1+" WHERE "+col02+"='"+studname+"'",null);
        return cur;

    }


//    notificationretrive

    public Cursor searchdata1(String branch)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cur=sqLiteDatabase.rawQuery("SELECT * FROM "+Tablename2+" WHERE "+col023+"='"+branch+"'",null);
        return cur;

    }


//    admin update date

    public boolean updateData(String id, String examdate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put(col021,examdate );
        long status1 = db.update(Tablename2,cv1,col011 +"=" +id,null);

        if (status1 == -1) {
            return false;
        }
        else{
            return true;
        }

    }



//    admin update examresult


    public boolean updateData1(String id, String examresult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv2 = new ContentValues();
        cv2.put(col022,examresult );
        long status2 = db.update(Tablename2,cv2,col022 +"=" +id,null);

        if (status2 == -1) {
            return false;
        }
        else{
            return true;
        }

    }

//    admin update branch

    public boolean updateData11(String id, String branch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv21 = new ContentValues();
        cv21.put(col021,branch );
        long status3 = db.update(Tablename2,cv21,col022 +"=" +id,null);

        if (status3 == -1) {
            return false;
        }
        else{
            return true;
        }

    }



//Register Delete
    public  boolean DeleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long status = db.delete(Tablename1, col01 + "=" + id, null);
        if (status == -1) {
            return false;
        } else {
            return true;
        }

    }



}
