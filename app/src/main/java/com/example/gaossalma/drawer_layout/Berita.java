package com.example.gaossalma.drawer_layout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.gaossalma.drawer_layout.API.ApiRequest;
import com.example.gaossalma.drawer_layout.API.RetroServer;
import com.example.gaossalma.drawer_layout.Adapter.AdapterData;
import com.example.gaossalma.drawer_layout.Model.DataModel;
import com.example.gaossalma.drawer_layout.Model.ResponsModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gaossalma on 4/22/2018.
 */

public class Berita extends Fragment {

    EditText tanggal, judul, isi;

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    //private RecyclerView.LayoutManager mManager;
    private List<DataModel> mItems = new ArrayList<>();
    ProgressDialog pd;

    public Berita(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView =  inflater.inflate(R.layout.fragment_berita, container, false);
        final FragmentActivity c = getActivity();
        final RecyclerView mRecycler = (RecyclerView) rootView.findViewById(R.id.recyclerTemp);
        LinearLayoutManager layoutManager = new LinearLayoutManager(c);
        //rootView.setTag(mRecycler);
        //mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        //mRecycler = (RecyclerView) rootView.findViewById(R.id.recyclerTemp);
        //mManager = new LinearLayoutManager(getActivity());
        //mRecycler.setLayoutManager(mManager);

        //pd.setMessage("Loading ...");
        //pd.setCancelable(false);
        //pd.show();


        String sjudul = judul.getText().toString();
        String sisi = isi.getText().toString();
        String stanggal = tanggal.getText().toString();
        ApiRequest api = RetroServer.getClient().create(ApiRequest.class);
        Call<ResponsModel> getdata = api.getberita(sjudul, sisi, stanggal);
        getdata.enqueue(new Callback<ResponsModel>() {
            @Override
            public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                pd.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult();

                mAdapter = new AdapterData(Berita.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponsModel> call, Throwable t) {
                pd.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });

        return rootView;
    }
}
