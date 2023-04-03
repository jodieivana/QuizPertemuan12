package com.example.quizpertemuan12;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizpertemuan12.adapter.BukuAdapter;
import com.example.quizpertemuan12.model.Buku;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class DataBukuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_buku);

        //tarik data pengguna
        Realm realm = Realm.getDefaultInstance();

        //penarikan data
        RealmResults<Buku> users = realm.where(Buku.class).findAll();

        //menampilkan data
//        for (User user: users) {
//            Log.d("TAG", "Nama :"+user.getNama() + ", Nomor Telp : " +user.getNotlp());
//        }

        ArrayList<Buku> arrayofuser = new ArrayList<Buku>();
        arrayofuser.addAll(realm.copyFromRealm(users));
        realm.close();

        BukuAdapter userAdapter = new BukuAdapter(this, arrayofuser);
        ListView listView = (ListView) findViewById(R.id.listViewUser);
        listView.setAdapter(userAdapter);
    }
}