package io.geektech.myapplicationfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ChangeFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText editText;
    private Button btnSend;
    private Button btnReplace;

    IFragments iFragments;

    public ChangeFragment() {
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iFragments = (IFragments) context;
    }

    public static ChangeFragment newInstance(String param1, String param2) {
        ChangeFragment fragment = new ChangeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change, container, false);
        editText =  view.findViewById(R.id.etText);
        btnReplace = view.findViewById(R.id.btnReplace);
        btnSend = view.findViewById(R.id.btnSend);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text =  editText.getText().toString();
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.onSendText(text);
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) getActivity();
                activity.onReplace();
            }
        });

        return  view;

    }
}