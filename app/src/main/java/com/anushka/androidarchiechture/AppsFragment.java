package com.anushka.androidarchiechture;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapters.AppListAdapter;
import pojo.Datum;
import pojo.FeaturedApp;
import retrofit.Repository;
import viewmodel.AppsDataViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppsFragment extends Fragment {

private RecyclerView appListRecyclerView;
private Observer<List<Datum>> observer;
private AppsDataViewModel appsDataViewModel;
private AppListAdapter appListAdapter;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // getting object of viewModel
        appsDataViewModel= ViewModelProviders.of(getActivity()).get(AppsDataViewModel.class);

        appListRecyclerView=getView().findViewById(R.id.app_items);
        appListRecyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        appListRecyclerView.setLayoutManager(linearLayoutManager);

        observer=new Observer<List<Datum>>() {
            @Override
            public void onChanged(@Nullable List<Datum> featuredAppList) {

                if(featuredAppList!=null ) {

                    appListAdapter = new AppListAdapter(getActivity(), featuredAppList);
                    appListRecyclerView.setAdapter(appListAdapter);

                    System.out.println("on changed called");
                }
            }
        };

        appsDataViewModel.getAppMutableLiveData().observe(this,observer);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_apps, container, false);


        return view;
    }

}
