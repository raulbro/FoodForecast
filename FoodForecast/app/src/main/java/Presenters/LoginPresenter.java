package Presenters;

import android.content.Context;

import APIClasses.APILogin;
import IPresenters.ILoginPresenter;
import Models.Singleton;
import Models.User;
import Server.APIInterface;
import Server.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by raulbr on 2/26/17.
 */
public class LoginPresenter implements ILoginPresenter {
    private final Context context;
    private final LoginPresenterListener mListener;
    private final APIService apiService;
    private boolean loginSuccessfull;

    public LoginPresenter(LoginPresenterListener listener, Context context) {
        this.mListener = listener;
        this.context = context;
        this.apiService = new APIService();
    }

    public interface LoginPresenterListener{
        void loginListener(APILogin apiLogin);
    }

    @Override
    public void login(final String userName, final String password) {
        apiService
                .getAPI()
                .register(userName, password)
                .enqueue(new Callback<APILogin>() {
                    @Override
                    public void onResponse(Call<APILogin> call, Response<APILogin> response) {
                        APILogin result = response.body();
                        if(result != null) {
                            mListener.loginListener(result);
                            //Action on activity WHEN LOGIN SUCCEED
                            loginSuccessfull = true;
                            User currentUser = new User(userName, password);
                            Singleton._SINGLETON.setCurrentUser(currentUser);
                            return;
                        }
                        loginSuccessfull = false;
                        //LOGIN FAIED ACTION
                    }
                    @Override
                    public void onFailure(Call<APILogin> call, Throwable t) {
                        try {
                            throw  new InterruptedException("ON FAILURE LOGIN");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void register(final String userName, final String password) {
        apiService
                .getAPI()
                .register(userName, password)
                .enqueue(new Callback<APILogin>() {
                    @Override
                    public void onResponse(Call<APILogin> call, Response<APILogin> response) {
                        APILogin result = response.body();
                        if(result != null) {
                            mListener.loginListener(result);
                            //Action on activity WHEN LOGIN SUCCEED
                            loginSuccessfull = true;
                            User currentUser = new User(userName, password);
                            Singleton._SINGLETON.setCurrentUser(currentUser);
                            return;
                        }
                        loginSuccessfull = false;
                        //LOGIN FAIED ACTION
                    }
                    @Override
                    public void onFailure(Call<APILogin> call, Throwable t) {
                        try {
                            throw  new InterruptedException("ON FAILURE LOGIN");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void switchToMainActivity() {

    }
}
