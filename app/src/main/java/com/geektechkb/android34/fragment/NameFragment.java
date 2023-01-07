package com.geektechkb.android34.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektechkb.android34.CatModel;
import com.geektechkb.android34.CatRepositiry;
import com.geektechkb.android34.OnClickItemCat;
import com.geektechkb.android34.R;
import com.geektechkb.android34.SecondFragment;

import java.io.Serializable;

public class NameFragment extends Fragment implements OnClickItemCat {
    private final CatRepositiry catRepositiry=new CatRepositiry();
    private final NameAdapter adapter=new NameAdapter(catRepositiry.getCatModelList());
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_names);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickItemCat(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        catRepositiry.getCatModelList().clear();
        adapter.setListCat(catRepositiry.getCatModelList());
    }

    @Override
    public void listenerOnClickItemCat(CatModel catModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("cat", (Serializable) catModel);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SecondFragment.class, bundle)
                .commit();
    }
}