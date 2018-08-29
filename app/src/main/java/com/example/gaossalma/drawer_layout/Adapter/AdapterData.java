package com.example.gaossalma.drawer_layout.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaossalma.drawer_layout.Berita;
import com.example.gaossalma.drawer_layout.MainActivity;
import com.example.gaossalma.drawer_layout.Model.DataModel;
import com.example.gaossalma.drawer_layout.R;

import java.util.List;

/**
 * Created by gaossalma on 4/25/2018.
 */


    public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

        private List<DataModel> mList ;
        private Context ctx;


        public  AdapterData (Context ctx, List<DataModel> mList)
        {
            this.ctx = ctx;
            this.mList = mList;
        }

    public AdapterData(Berita berita, List<DataModel> mItems) {
    }

    @Override
        public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent, false);
            HolderData holder = new HolderData(layout);
            return holder;
        }

        @Override
        public void onBindViewHolder(HolderData holder, int position) {
            DataModel dm = mList.get(position);
            holder.tgl_berita.setText(dm.getTgl_berita());
            holder.judul.setText(dm.getJudul());
            holder.isi.setText(dm.getIsi());
            /*holder.fullname.setText(dm.getFullname());
            holder.username.setText(dm.getUsername());
            holder.e_mail.setText(dm.getE_mail());
            holder.gender.setText(dm.getGender());
            holder.counry.setText(dm.getId_country());
            holder.language.setText(dm.getLanguage());
            holder.birthday.setText(dm.getBirthday());
            holder.phone_number.setText(dm.getPhone_number());
            holder.password.setText(dm.getPassword());*/
            holder.dm = dm;
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }


        class HolderData extends  RecyclerView.ViewHolder{
            TextView tgl_berita, judul, isi;
            DataModel dm;
            public HolderData (View v)
            {
                super(v);
                tgl_berita  = (TextView) v.findViewById(R.id.tvjudul);
                judul  = (TextView) v.findViewById(R.id.tvjudul);
                /*fullname  = (TextView) v.findViewById(R.id.fullname);
                username = (TextView) v.findViewById(R.id.create_username);
                e_mail = (TextView) v.findViewById(R.id.create_email);
                password = (TextView) v.findViewById(R.id.create_password);
                gender = (TextView) v.findViewById(R.id.gender);
                phone_number = (TextView) v.findViewById(R.id.phone_number);
                language = (TextView) v.findViewById(R.id.create_language);
                birthday = (TextView) v.findViewById(R.id.birthday);
                counry = (TextView) v.findViewById(R.id.country);*/

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goInput = new Intent(ctx,Berita.class);
                        goInput.putExtra("id_berita", dm.getId_berita());
                        goInput.putExtra("judul", dm.getJudul());
                        goInput.putExtra("tgl_berita", dm.getTgl_berita());
                        goInput.putExtra("isi", dm.getIsi());

                        /*goInput.putExtra("id", dm.getFullname());
                        goInput.putExtra("nama", dm.getUsername());
                        goInput.putExtra("usia", dm.getE_mail());
                        goInput.putExtra("domisili", dm.getCounry());
                        goInput.putExtra("domisili", dm.getPassword());
                        goInput.putExtra("domisili", dm.getGender());
                        goInput.putExtra("domisili", dm.getPhone_number());
                        goInput.putExtra("domisili", dm.getLanguage());
                        goInput.putExtra("domisili", dm.getBirthday());*/

                        ctx.startActivity(goInput);
                    }
                });
            }
        }
    }


