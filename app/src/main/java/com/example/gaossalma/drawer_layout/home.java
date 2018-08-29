package com.example.gaossalma.drawer_layout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {

    private RelativeLayout menu1;

    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        menu1 = (RelativeLayout) rootView.findViewById(R.id.menu1);
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getActivity(), "Klick me", Toast.LENGTH_SHORT).show();
                Intent menu1 = new Intent(getActivity().getApplication(), Detail_berita.class);
                startActivity(menu1);
                //FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                //ft.replace(R.id.berita_utama,new Berita());
                //return inflater.inflate(R.layout.fragment_berita, container, false);
            }




        });

        return rootView;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
