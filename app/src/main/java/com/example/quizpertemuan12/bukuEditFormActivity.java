package com.example.quizpertemuan12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizpertemuan12.crud.bukuCRUD;

public class bukuEditFormActivity extends AppCompatActivity {

    EditText edtJudulBukue, edtPengarange, edtPenerbite, edtTahunTerbite;
    TextView edtIDBukue;
    Button btnSimpanBukue;

    String JudulBuku = "";
    String Pengarang = "";
    String Penerbit = "";
    String TahunTerbit = "";
    String IDBuku = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_edit_form);
        getIntent().getStringExtra("judulbuku");
        getIntent().getStringExtra("pengarang");
        getIntent().getStringExtra("penerbit");
        getIntent().getStringExtra("tahunterbit");
        getIntent().getStringExtra("idbuku");

        edtIDBukue = (TextView) findViewById(R.id.edtIDBukue);
        edtJudulBukue = (EditText) findViewById(R.id.edtJudulBukue);
        edtPengarange = (EditText) findViewById(R.id.edtPengarange);
        edtPenerbite = (EditText) findViewById(R.id.edtPenerbite);
        edtTahunTerbite = (EditText) findViewById(R.id.edtTahunTerbite);
        btnSimpanBukue = (Button) findViewById(R.id.btnSimpanBukue);

        edtIDBukue.setText(getIntent().getStringExtra("idbuku"));
        edtJudulBukue.setText(getIntent().getStringExtra("judulbuku"));
        edtPengarange.setText(getIntent().getStringExtra("pengarang"));
        edtPenerbite.setText(getIntent().getStringExtra("penerbit"));
        edtTahunTerbite.setText(getIntent().getStringExtra("tahunterbit"));

        btnSimpanBukue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JudulBuku = (String) edtJudulBukue.getText().toString();
                Pengarang = (String) edtPengarange.getText().toString();
                Penerbit = (String) edtPenerbite.getText().toString();
                TahunTerbit = (String) edtTahunTerbite.getText().toString();
                IDBuku = (String) edtIDBukue.getText().toString();
                Log.d("TAG", "JudulBuku" + JudulBuku + "Pengarang" + Pengarang + "Penerbit" + Penerbit + "TahunTerbit" + TahunTerbit + "IDBuku" + IDBuku);
                bukuCRUD bukucrud = new bukuCRUD();
                bukucrud.updateDataBuku(IDBuku, JudulBuku, Pengarang, Penerbit, TahunTerbit);
                finish();
            }
        });
    }
}