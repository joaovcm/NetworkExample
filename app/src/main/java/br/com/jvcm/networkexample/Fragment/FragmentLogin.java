package br.com.jvcm.networkexample.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import br.com.jvcm.networkexample.LoginActivity;
import br.com.jvcm.networkexample.R;
import br.com.jvcm.networkexample.SimpleTextWatcher;

public class FragmentLogin extends Fragment {

    private EditText edtEmail;
    private EditText edtPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, true);
        edtEmail = rootView.findViewById(R.id.edt_email);
        edtPassword = rootView.findViewById(R.id.edt_password);
        edtEmail.addTextChangedListener(watcherEmail);
        edtPassword.addTextChangedListener(watcherPassword);

        return rootView;
    }

    private TextWatcher watcherEmail = new SimpleTextWatcher(){
        @Override
        public void afterTextChanged(Editable s) {
            ((LoginActivity)getActivity()).validEmail(s.toString());
        }
    };

    private TextWatcher watcherPassword = new SimpleTextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            ((LoginActivity)getActivity()).validPassword(s.toString());
        }
    };

    public String getEmail(){
        return edtEmail.getText().toString();
    }

    public String getPassword(){
        return edtPassword.getText().toString();
    }

}
