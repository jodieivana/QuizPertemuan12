package com.example.quizpertemuan12.crud;

import android.util.Log;

import com.example.quizpertemuan12.model.Buku;
import com.example.quizpertemuan12.model.Buku;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class bukuCRUD {

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
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }

    public void updateDataBuku(String IDBuku, String JudulBuku, String Pengarang, String Penerbit, String TahunTerbit) {
        Realm realm = Realm.getDefaultInstance();
        //update data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", "JudulBuku" + JudulBuku + "Pengarang" + Pengarang + "Penerbit" + Penerbit + "TahunTerbit" + TahunTerbit + "IDBuku" + IDBuku);
                    Buku buku1 = realm.where(Buku.class).equalTo("idbuku",IDBuku).findFirst();
                    buku1.setJudulBuku(JudulBuku);
                    buku1.setPengarang(Pengarang);
                    buku1.setPenerbit(Penerbit);
                    buku1.setTahunTerbit(TahunTerbit);
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }

    public void deleteDataBuku(String IDBuku) {
        Realm realm = Realm.getDefaultInstance();
        //delete data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG",  "IDBuku" + IDBuku);
                    Buku buku1 = realm.where(Buku.class).equalTo("idbuku",IDBuku).findFirst();
                    buku1.deleteFromRealm();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}
