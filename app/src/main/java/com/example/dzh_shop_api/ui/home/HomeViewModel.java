package com.example.dzh_shop_api.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dzh_shop_api.model.ModelM;
import com.example.dzh_shop_api.repositories.JemRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private JemRepository jemRepositoty;
    private  LiveData<List<ModelM>> modelMResponseLiveData;
    public HomeViewModel() {
        jemRepositoty = new JemRepository();
        modelMResponseLiveData = jemRepositoty.getDashJeminyList();
    }

    public LiveData<List<ModelM>> getModeResponseLiveData() {
        return modelMResponseLiveData;
    }
}