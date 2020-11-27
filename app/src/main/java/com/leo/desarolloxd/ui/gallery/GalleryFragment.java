package com.leo.desarolloxd.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leo.desarolloxd.ClinicasActivity;
import com.leo.desarolloxd.HospitalesActivity;
import com.leo.desarolloxd.PostasActivity;
import com.leo.desarolloxd.R;

public class GalleryFragment extends Fragment {

    Button hospital,clinica,posta;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        hospital = root.findViewById(R.id.botonhospital);
        clinica = root.findViewById(R.id.botonclinicas);
        posta = root.findViewById(R.id.botonpostas);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HospitalesActivity.class);
                startActivity(intent);
            }
        });
        clinica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ClinicasActivity.class);
                startActivity(intent);
            }
        });
        posta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PostasActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}