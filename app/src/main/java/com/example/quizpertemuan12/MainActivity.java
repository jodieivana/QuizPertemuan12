package com.example.quizpertemuan12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizpertemuan12.model.Buku;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //config Realm
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().allowWritesOnUiThread(true).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("judulbuku", "Mary Poppins");
        editor.apply();

        Button btnCetak= (Button) findViewById(R.id.btnCetak);
        btnCetak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cetakDataBuku();
            }
        });

        Button btnData= (Button) findViewById(R.id.btnData);
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, DataBukuActivity.class);

                startActivity(intent);
            }
        });

        Button btnTambah= (Button) findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, formBukuActivity.class);

                startActivity(intent);
            }
        });

    }

    public void tambahDataBuku() {
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    realm.deleteAll();

                    Buku buku1 = realm.createObject(Buku.class, "12393246127");
                    buku1.setJudulBuku("All The Bright Places");
                    buku1.setPengarang("Jennifer Niven");
                    buku1.setPenerbit("Puffin");
                    buku1.setTahunTerbit("2015");

                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }

    public void cetakDataBuku(){
        Realm realm = Realm.getDefaultInstance();

        //penarikan data
        RealmResults<Buku> bukus = realm.where(Buku.class).findAll();

        //menampilkan data
        for (Buku buku: bukus) {
            Log.d("TAG", "ID Buku :"+buku.getIDBuku() + ", Judul Buku : " +buku.getJudulBuku() + ", Pengarang : " +buku.getPengarang() + ", Penerbit : " + buku.getPenerbit() + ", Tahun Terbit : " + buku.getTahunTerbit());
        }
        realm.close();


    }

}