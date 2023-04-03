package com.example.quizpertemuan12.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

public class Buku extends RealmObject{

    @Required
    private String judulbuku;
    private String pengarang;
    private String penerbit;
    private String tahunterbit;
    @PrimaryKey
    private String idbuku;


    public Buku() {
    }

    public Buku(String judulbuku, String pengarang, String penerbit, String tahunterbit, String idbuku) {
        this.judulbuku = judulbuku;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunterbit = tahunterbit;
        this.idbuku = idbuku;
    }

    public String getJudulBuku() {
        return judulbuku;
    }

    public void setJudulBuku(String judulbuku) {
        this.judulbuku = judulbuku;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) { this.pengarang = pengarang; }

    public String getPenerbit() { return penerbit; }

    public void setPenerbit(String penerbit) { this.penerbit = penerbit; }

    public String getTahunTerbit() {
        return tahunterbit;
    }

    public void setTahunTerbit(String tahunterbit) { this.tahunterbit = tahunterbit; }

    public String getIDBuku() {
        return idbuku;
    }

    public void setIDBuku(String idbuku) { this.idbuku = idbuku; }

}
