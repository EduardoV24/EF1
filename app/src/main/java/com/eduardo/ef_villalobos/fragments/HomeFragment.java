package com.eduardo.ef_villalobos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eduardo.ef_villalobos.R;
import com.eduardo.ef_villalobos.databinding.FragmentHomeBinding;
import com.eduardo.ef_villalobos.retrofit.model.Teams;
import com.eduardo.ef_villalobos.retrofit.TeamsInterface;
import com.eduardo.ef_villalobos.retrofit.RetroFitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_teams);
        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 2);
        binding.rvTeams.setLayoutManager(layoutManager);

        TeamsInterface playerInterface = RetroFitHelper.getInstance().create(TeamsInterface.class);
        Call<List<Teams>> call = playerInterface.getShowTeams();
        call.enqueue(new Callback<List<Teams>>() {
            @Override
            public void onResponse(Call<List<Teams>> call, Response<List<Teams>> response) {
                List<Teams> items = response.body();
                showTeams(items);
            }

            @Override
            public void onFailure(Call<List<Teams>> call, Throwable t) {

            }


        });
    }

    private void showTeams(List<Teams> showsList) {
        RVResumeAdapter rvShowProductAdapter = new RVResumeAdapter(showsList);
        recyclerView.setAdapter(rvShowProductAdapter);
    }
}