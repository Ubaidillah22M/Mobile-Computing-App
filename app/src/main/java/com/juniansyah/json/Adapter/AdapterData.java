package com.juniansyah.json.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juniansyah.json.Model.ModelData;
import com.juniansyah.json.R;

import java.util.List;

/**
 * Created by asus on 2/10/2019.
 */

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    private List<ModelData> mItems;
    private Context context;

    public AdapterData (Context context, List<ModelData> items) {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_row, parent, false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelData md = mItems.get(position);
        holder.tvnim.setText(md.getNim());
        holder.tvnama.setText(md.getNama());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder {
        TextView tvnim, tvnama;
        public HolderData (View view) {
            super(view);

            tvnim = (TextView) view.findViewById(R.id.nim);
            tvnama = (TextView) view.findViewById(R.id.nama);
        }
    }
}
