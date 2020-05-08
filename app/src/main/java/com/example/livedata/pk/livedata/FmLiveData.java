package com.example.livedata.pk.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FmLiveData extends ViewModel {
    private MutableLiveData<String> txtB;
    private MutableLiveData<String> txtC;

    public MutableLiveData<String> getTxtB() {
        if (txtB == null) {
            txtB = new MutableLiveData<String>();
        }
        return txtB;
    }

    public MutableLiveData<String> getTxtC() {
        if (txtC == null) {
            txtC = new MutableLiveData<String>();
        }
        return txtC;
    }
}
