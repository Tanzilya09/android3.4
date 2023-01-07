package com.geektechkb.android34;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondFragment extends Fragment {
    private ImageView imageSecond;
    private TextView txtNameSecond;
    private TextView txtSecond;
    CatModel catModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageSecond=view.findViewById(R.id.image_second);
        txtNameSecond=view.findViewById(R.id.txt_name_second);
        txtSecond=view.findViewById(R.id.txt_second);

        getData();
    }

    private void getData() {
        Bundle bundle = getArguments();
        if (getArguments() != null){
            catModel= (CatModel) bundle.getSerializable("cat");
            Glide.with(imageSecond.getContext()).load(catModel.getImageCat()).into(imageSecond);
            txtSecond.setText(catModel.getImageCat());
            txtNameSecond.setText(catModel.getDescrioption());
        }
    }
}