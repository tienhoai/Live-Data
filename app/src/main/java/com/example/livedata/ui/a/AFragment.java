package com.example.livedata.ui.a;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.livedata.R;
import com.example.livedata.pk.livedata.FmLiveData;

import java.util.Objects;

public class AFragment extends Fragment {
    private AViewModel mViewModel;
    private FmLiveData fmLiveDataModel;
    private EditText etB, etC;
//    private Button btSentB, btSentC;

    private void mapping(View view) {
        fmLiveDataModel = new ViewModelProvider(getActivity()).get(FmLiveData.class);
        etB = view.findViewById(R.id.etFb);
        etC = view.findViewById(R.id.etFc);
//        btSentB = view.findViewById(R.id.btSentB);
//        btSentC = view.findViewById(R.id.btSentC);
    }

    public static AFragment newInstance() {
        return new AFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a_fragment, container, false);
        mapping(view);
        onChange();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AViewModel.class);
        // TODO: Use the ViewModel
    }

    private void onChange() {

//        btSentB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fmLiveDataModel.getTxtB().setValue(etB.getText().toString());
//                etB.setText("");
//            }
//        });
//
//        btSentC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fmLiveDataModel.getTxtC().setValue(etC.getText().toString());
//                etC.setText("");
//            }
//        });

        etB.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fmLiveDataModel.getTxtB().setValue(etB.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etC.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                fmLiveDataModel.getTxtC().setValue(etC.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
