package Models;

/**
 * Created by raulbr on 2/26/17.
 */
public class User {

    public User(String userName, String password) {
        _password = password;
        _userName = userName;
    }
    private String _userName;
    private String _password;

    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
