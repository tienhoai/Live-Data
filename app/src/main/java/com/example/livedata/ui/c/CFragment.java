package com.example.livedata.ui.c;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.livedata.R;
import com.example.livedata.pk.livedata.FmLiveData;

import java.util.Objects;

public class CFragment extends Fragment {

    private CViewModel mViewModel;
    FmLiveData fmLiveDataModel;
    TextView tvC;

    private void mapping(View view) {
        fmLiveDataModel = new ViewModelProvider(getActivity()).get(FmLiveData.class);
        tvC = view.findViewById(R.id.tvFc);
    }

    public static CFragment newInstance() {
        return new CFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.c_fragment, container, false);
        mapping(view);
        observeFm();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CViewModel.class);
        // TODO: Use the ViewModel
    }

    private void observeFm() {

        Observer<String> txtObserver = new Observer<String>() {

            @Override
            public void onChanged(@Nullable final String newName) {
                tvC.setText(newName);
            }
        };
        fmLiveDataModel.getTxtC().observe(Objects.requireNonNull(getActivity()), txtObserver);
    }
}
