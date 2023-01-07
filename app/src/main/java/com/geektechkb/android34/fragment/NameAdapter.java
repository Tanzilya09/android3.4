package com.geektechkb.android34.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geektechkb.android34.CatModel;
import com.geektechkb.android34.OnClickItemCat;
import com.geektechkb.android34.R;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NamesViewHolder> {
    private List<CatModel> listCat = null;
    private OnClickItemCat onClickItemCat;

    public NameAdapter(List<CatModel> listCat) {
        this.listCat = listCat;
    }

    public void setListCat(List<CatModel> listCat) {
        this.listCat = listCat;
    }

    public void setOnClickItemCat(OnClickItemCat onClickItemCat) {
        this.onClickItemCat = onClickItemCat;
    }

    @NonNull
    @Override
    public NamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NamesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull NamesViewHolder holder, int position) {
        holder.onBind(listCat.get(position));
    }

    @Override
    public int getItemCount() {
        return listCat.size();
    }

    public class NamesViewHolder extends RecyclerView.ViewHolder  {
        TextView  name;
        TextView txt;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        public NamesViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            txt = itemView.findViewById(R.id.txt_item);
            imageView =itemView.findViewById(R.id.image);
            constraintLayout = itemView.findViewById(R.id.item_name);
        }

        public void onBind(CatModel listCats){
            URI uri = null;
            try {
                uri = new URI(listCats.getImageCat());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            Glide.with(imageView.getContext()).load(listCats.getImageCat()).into(imageView);
            String path = uri.getPath();
            String idStr = path.substring(path.lastIndexOf("/") + 1);
            int id = Integer.parseInt(idStr);
            name.setText(listCats.getDescrioption());
            txt.setText(String.valueOf(id));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickItemCat.listenerOnClickItemCat(listCats);
                }
            });

        }
    }
}

