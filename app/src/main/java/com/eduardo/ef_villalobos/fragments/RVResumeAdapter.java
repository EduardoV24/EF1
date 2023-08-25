package com.eduardo.ef_villalobos.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eduardo.ef_villalobos.databinding.ItemShowBinding;
import com.eduardo.ef_villalobos.retrofit.model.Teams;

import java.util.List;

public class RVResumeAdapter extends RecyclerView.Adapter<RVResumeAdapter.ShowViewHolder> {

    private List<Teams> teams;

    public RVResumeAdapter(List<Teams> players) {
        this.teams = players;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowBinding binding = ItemShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShowViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        Teams product = teams.get(position);
        holder.bind(product);


    }



    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class ShowViewHolder extends RecyclerView.ViewHolder {
        private ItemShowBinding binding;
        public ShowViewHolder(@NonNull ItemShowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }



        public void bind(Teams players) {
            binding.txtName.setText(players.getName());
            Glide.with(itemView.getContext()).load(players.getLogo_url()).into(binding.imgShow);
        }

}
}
