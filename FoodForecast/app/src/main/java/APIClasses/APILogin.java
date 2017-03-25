package APIClasses;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raulbr on 3/24/17.
 */

public class APILogin {
    public String isLogin;

    @SerializedName("userName")
    private String _userName;

    @SerializedName("password")
    private String _password;

    public String getIsLogin() {
        return isLogin;
    }

    public String get_userName() {
        return _userName;
    }

    public String get_password() {
        return _password;
    }
}
