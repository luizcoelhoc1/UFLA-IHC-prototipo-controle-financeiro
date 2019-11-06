package com.example.controlefinanceiro.ui.home;

import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("R$ 1000,00");
    }

    public LiveData<String> getText() {
        return mText;
    }
}