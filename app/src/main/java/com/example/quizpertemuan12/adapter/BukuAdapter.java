package com.example.quizpertemuan12.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.quizpertemuan12.R;
import com.example.quizpertemuan12.crud.bukuCRUD;
import com.example.quizpertemuan12.model.Buku;
import com.example.quizpertemuan12.bukuEditFormActivity;

import java.util.List;

public class BukuAdapter extends ArrayAdapter<Buku>{

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Buku buku =getItem(position);
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listviewbuku, parent, false);
        }

        TextView txvIDBuku = (TextView) convertView.findViewById(R.id.txvIDBuku);
        TextView txvJudulBuku = (TextView) convertView.findViewById(R.id.txvJudulBuku);
        TextView txvPengarang = (TextView) convertView.findViewById(R.id.txvPengarang);
        TextView txvPenerbit = (TextView) convertView.findViewById(R.id.txvPenerbit);
        TextView txvTahunTerbit = (TextView) convertView.findViewById(R.id.txvTahunTerbit);

        txvIDBuku.setText(buku.getIDBuku());
        txvJudulBuku.setText(buku.getJudulBuku());
        txvPengarang.setText(buku.getPengarang());
        txvPenerbit.setText(buku.getPenerbit());
        txvTahunTerbit.setText(buku.getTahunTerbit());

        ImageButton btnEdit= (ImageButton) convertView.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), bukuEditFormActivity.class);

                intent.putExtra("idbuku", buku.getIDBuku());
                intent.putExtra("judulbuku", buku.getJudulBuku());
                intent.putExtra("pengarang", buku.getPengarang());
                intent.putExtra("penerbit", buku.getPenerbit());
                intent.putExtra("tahunterbit", buku.getTahunTerbit());
                getContext().startActivity(intent);
            }
        });

        ImageButton btnDelete= (ImageButton) convertView.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bukuCRUD bukucrud = new bukuCRUD();
                bukucrud.deleteDataBuku(buku.getIDBuku());
                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    public BukuAdapter(Context context, List<Buku> objects) {
        super(context, 0, objects);
    }

}
