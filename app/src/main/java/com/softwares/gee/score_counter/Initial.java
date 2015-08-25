package com.softwares.gee.score_counter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Initial.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Initial#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Initial extends Fragment {
    public static final String USER_PREFS = "User_Prefs";
    public static final String USER_NAME = "User_name";
    public static final String USER_AGE = "User_age";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Initial() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_initial, container, false);

        //É necessario instanciar o button e definir seu callback aqui, senão ele busca
        //o método na classe activity
        Button button = (Button) view.findViewById(R.id.saveProfile_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //Cria Shared Preferences e salva os dados de perfil nelas
              //  SharedPreferences profile = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences profile = getActivity().getSharedPreferences(USER_PREFS,Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = profile.edit();
                EditText username = (EditText)(getActivity().findViewById(R.id.username_EditText));
                editor.putString(USER_NAME, username.getText().toString());
                editor.commit();
            }
        });

        return view;
    }
}
