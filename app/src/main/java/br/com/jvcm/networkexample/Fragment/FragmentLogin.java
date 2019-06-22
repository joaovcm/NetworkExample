package br.com.jvcm.networkexample.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import br.com.jvcm.networkexample.R;

public class FragmentLogin extends Fragment {

    private EditText edtEmail;
    private EditText edtPassword;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, true);
        edtEmail = rootView.findViewById(R.id.edt_email);
        edtPassword = rootView.findViewById(R.id.edt_password);

        return rootView;
    }

    public String getEmail(){
        return edtEmail.getText().toString();
    }

    public String getPassword(){
        return edtPassword.getText().toString();
    }

}
