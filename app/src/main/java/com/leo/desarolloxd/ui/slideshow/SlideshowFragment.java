package com.leo.desarolloxd.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.leo.desarolloxd.R;
import com.leo.desarolloxd.ZonasRiesgoActivity;

public class SlideshowFragment extends Fragment {

Button aceptar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        aceptar = root.findViewById(R.id.botonaceptar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZonasRiesgoActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}