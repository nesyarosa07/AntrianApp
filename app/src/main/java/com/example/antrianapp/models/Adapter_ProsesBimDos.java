package com.example.antrianapp.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.antrianapp.DetailsAntrian;
import com.example.antrianapp.ItemClickListener;
import com.example.antrianapp.R;
import java.util.ArrayList;

public class Adapter_ProsesBimDos extends RecyclerView.Adapter<Adapter_ProsesBimDos.MyViewHolder>{
    Context context;
    ArrayList<Helper_ReqBim> list;

    public Adapter_ProsesBimDos(Context context, ArrayList<Helper_ReqBim> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter_ProsesBimDos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ITEM NYA DIIMPLEMENTASIKAN DARI XML
        View v = LayoutInflater.from(context).inflate(R.layout.item_antrian_mhs,parent,false);
        return new Adapter_ProsesBimDos.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_ProsesBimDos.MyViewHolder holder, int position) {

      Helper_ReqBim a = list.get(position);

        holder.namados.setText(a.getTo_dosen());
        holder.namamhs.setText(a.getNama_mhs());
        holder.tanggal.setText(a.getTanggal());
        holder.jenisbim.setText(a.getBimb());
        holder.status.setText(a.getStatus());
        holder.nim.setText(a.getId_mhs());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String item =  list.get(position).getId_bim();
                String item1 = list.get(position).getTo_dosen();
                String item2 = list.get(position).getTanggal();
                String item4 = list.get(position).getBimb();
                String item5 = list.get(position).getStatus();
                String item6 = list.get(position).getNama_mhs();
                String item7 = list.get(position).getId_dos();
                String item8 = list.get(position).getId_mhs();


                Intent i = new Intent(context, DetailsAntrian.class);
                i.putExtra("to_dosen", item1);
                i.putExtra("tanggal", item2);
                i.putExtra("bimb", item4);
                i.putExtra("status", item5);
                i.putExtra("id_bim",item);
                i.putExtra("nama_mhs",item6);
                i.putExtra("id_dos",item7);
                i.putExtra("id_mhs",item8);


                context.startActivity(i);
            }
        });

    } //tutup onbind

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView namados, namamhs, tanggal, waktu, jenisbim, status, nim;

        ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            namados = itemView.findViewById(R.id.item_namadosen);
            namamhs = itemView.findViewById(R.id.item_namamhs);
            tanggal = itemView.findViewById(R.id.item_tanggal);
            jenisbim = itemView.findViewById(R.id.item_jenisbimb);
            status = itemView.findViewById(R.id.item_status);
            nim = itemView.findViewById(R.id.item_nim);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v,getLayoutPosition());

        }

        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }
}
