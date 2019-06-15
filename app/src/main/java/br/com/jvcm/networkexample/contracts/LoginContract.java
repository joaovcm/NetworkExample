package br.com.jvcm.networkexample.contracts;

public interface LoginContract {
    //Contratos de devolução do presenter para a views
    interface View {
        void onEnableButton();

        void onAuthSuccess();

        void onAuthError();
    }

    //Contratos de solicitação da view para o presenter
    interface Presenter {
        void doValidEmail(String email);

        void doValidPassord(String password);

        void doAuth(String email, String password);
    }
}
