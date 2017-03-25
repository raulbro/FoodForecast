package IPresenters;

import Models.User;

/**
 * Created by raulbr on 2/26/17.
 */
public interface ILoginPresenter {
    public void login(String userName, String password);
    public void register(String userName, String password);
}
