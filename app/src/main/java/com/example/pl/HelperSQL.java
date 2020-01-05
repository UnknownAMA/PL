package com.example.pl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.example.pl.G.database;

public class HelperSQL extends SQLiteOpenHelper {

    public HelperSQL(@Nullable Context context) {
        super(context, "pl.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE  TABLE IF NOT EXISTS Contact (" +
                "Id INTEGER PRIMARY KEY AutoIncrement  NOT NULL  UNIQUE ," +
                " name TEXT," +
                " lastName TEXT," +
                " nickName TEXT," +
                " gName TEXT," +
                " workAdd TEXT ," +
                " homeAdd TEXT," +
                " email TEXT," +
                " web TEXT," +
                " bdate TEXT ," +
                " mobile TEXT ," +
                " phoneWork TEXT ," +
                " phoneHome TEXT ," +
                " faxWork TEXT ," +
                " faxHOme TEXT ," +
                " other TEXT" +
                ")");
    }

    public void Add(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", person.Name());
        contentValues.put("lastName", person.LastName());
        contentValues.put("nickName", person.NickName());
        contentValues.put("gName", person.GName());
        contentValues.put("workAdd", person.WorkAdd());
        contentValues.put("homeAdd", person.HomeAdd());
        contentValues.put("email", person.Email());
        contentValues.put("web", person.Web());
        contentValues.put("bdate", person.Bdate());
        contentValues.put("mobile", person.Mobile());
        contentValues.put("phoneWork", person.PhoneWork());
        contentValues.put("phoneHome", person.PhoneHome());
        contentValues.put("faxWork", person.FaxWork());
        contentValues.put("faxHOme", person.FaxHOme());
        contentValues.put("other", person.Other());

        db.insert("Contact", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Person SerchId(String Type, String Id) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Contact WHERE Id = '" + Id + "'",null);
        return CursorToPerson(cursor);
    }

    public List<Person> getAll() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Contact",null);
        ArrayList<Person> R = new ArrayList<Person>();
        while (cursor.moveToNext())
        {
            R.add(CursorToPerson(cursor));
        }
        cursor.close();
        return R;
    }

    public void DeletePerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM QType1" + " WHERE Id = '" + person.Id() + "'");
    }

    public void DeleteG(String GName) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM QType1" + " WHERE gName = '" + GName + "'");
    }

    public void Edit(Person person) {
         SQLiteDatabase db = this.getWritableDatabase();

         db.execSQL("UPDATE Contact SET " +
                "pimage = '" + person.PImage() + "'," +
                "name = '" + person.Name() + "'," +
                "lastName = '" + person.LastName() + "'," +
                "nickName = '" + person.NickName() + "'," +
                "gName = '" + person.GName() + "'," +
                "workAdd = '" + person.WorkAdd() + "'," +
                "homeAdd = '" + person.HomeAdd() + "'," +
                "email = '" + person.Email() + "'," +
                "web = '" + person.Web() + "'," +
                "bdate = '" + person.Bdate() + "'," +
                "mobile = '" + person.Mobile() + "'," +
                "phoneWork = '" + person.PhoneWork() + "'," +
                "phoneHome = '" + person.PhoneHome() + "'," +
                "faxWork = '" + person.FaxWork() + "'," +
                "faxHOme = '" + person.FaxHOme() + "'," +
                "other = '" + person.Other() +"' " +
                "WHERE  Id = '" + person.Id() +"'");
    }

    public ArrayList<Person> SerchG(String gName) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Contact WHERE gName = '" + gName + " ",null);
        ArrayList<Person> R = new ArrayList<Person>();
        while (cursor.moveToNext())
        {
            R.add(CursorToPerson(cursor));
        }
        cursor.close();
        return R;
    }

    private Person CursorToPerson(Cursor cursor){
        Person person = new Person(Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id"))));
        person.Name(cursor.getString(cursor.getColumnIndex("name")));
//        person.PImage(cursor.getString(cursor.getColumnIndex("image")));
        person.LastName(cursor.getString(cursor.getColumnIndex("lastName")));
        person.NickName(cursor.getString(cursor.getColumnIndex("nickName")));
        person.GName(cursor.getString(cursor.getColumnIndex("gName")));
        person.WorkAdd(cursor.getString(cursor.getColumnIndex("workAdd")));
        person.HomeAdd(cursor.getString(cursor.getColumnIndex("homeAdd")));
        person.Email(cursor.getString(cursor.getColumnIndex("email")));
        person.Web(cursor.getString(cursor.getColumnIndex("web")));
        person.Bdate(cursor.getString(cursor.getColumnIndex("bdate")));
        person.Mobile(cursor.getString(cursor.getColumnIndex("mobile")));
        person.PhoneWork(cursor.getString(cursor.getColumnIndex("phoneWork")));
        person.PhoneHome(cursor.getString(cursor.getColumnIndex("phoneHome")));
        person.FaxWork(cursor.getString(cursor.getColumnIndex("faxWork")));
        person.FaxHOme(cursor.getString(cursor.getColumnIndex("faxHOme")));
        person.Other(cursor.getString(cursor.getColumnIndex("other")));
        return person;
    }
}
