package com.example.quizpertemuan12;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizpertemuan12.model.Buku;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class formBukuActivity extends AppCompatActivity {

    EditText edtIDBuku, edtJudulBuku, edtPengarang, edtPenerbit, edtTahunTerbit;
    Button btnSimpanBuku;

    String JudulBuku = "";
    String Pengarang = "";
    String Penerbit = "";
    String TahunTerbit = "";
    String IDBuku = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_buku);

        edtIDBuku = (EditText) findViewById(R.id.edtIDBuku);
        edtJudulBuku = (EditText) findViewById(R.id.edtJudulBuku);
        edtPengarang = (EditText) findViewById(R.id.edtPengarang);
        edtPenerbit = (EditText) findViewById(R.id.edtPenerbit);
        edtTahunTerbit = (EditText) findViewById(R.id.edtTahunTerbit);
        btnSimpanBuku = (Button) findViewById(R.id.btnSimpanBuku);

        btnSimpanBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IDBuku = (String) edtIDBuku.getText().toString();
                JudulBuku = (String) edtJudulBuku.getText().toString();
                Pengarang = (String) edtPengarang.getText().toString();
                Penerbit = (String) edtPenerbit.getText().toString();
                TahunTerbit = (String) edtTahunTerbit.getText().toString();
                Log.d("TAG", "JudulBuku" + JudulBuku + "Pengarang" + Pengarang + "Penerbit" + Penerbit + "TahunTerbit" + TahunTerbit + "IDBuku" + IDBuku);
                tambahDataBuku(JudulBuku, Pengarang, Penerbit, TahunTerbit, IDBuku);
            }
        });

    }

    public void tambahDataBuku(String JudulBuku, String Pengarang, String Penerbit, String TahunTerbit, String IDBuku) {
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", "JudulBuku" + JudulBuku + "Pengarang" + Pengarang + "Penerbit" + Penerbit + "TahunTerbit" + TahunTerbit + "IDBuku" + IDBuku);
                    Buku buku1 = realm.createObject(Buku.class, IDBuku);
                    buku1.setJudulBuku(JudulBuku);
                    buku1.setPengarang(Pengarang);
                    buku1.setPenerbit(Penerbit);
                    buku1.setTahunTerbit(TahunTerbit);
                    finish();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}