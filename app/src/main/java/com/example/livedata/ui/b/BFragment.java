package com.example.livedata.ui.b;

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

public class BFragment extends Fragment {

    private BViewModel mViewModel;
    private FmLiveData fmLiveDataModel;
    private TextView tvB;

    private void mapping(View view) {
        tvB = view.findViewById(R.id.tvFb);
        fmLiveDataModel = new ViewModelProvider(getActivity()).get(FmLiveData.class);
    }

    public static BFragment newInstance() {
        return new BFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.b_fragment, container, false);
        mapping(view);
        observeFm();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BViewModel.class);
        // TODO: Use the ViewModel
    }

    private void observeFm() {

        Observer<String> txtObserver = new Observer<String>() {

            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                tvB.setText(newName);
            }
        };
        fmLiveDataModel.getTxtB().observe(Objects.requireNonNull(getActivity()), txtObserver);
    }
}
