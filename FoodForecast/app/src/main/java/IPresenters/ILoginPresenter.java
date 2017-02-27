package IPresenters;

import Models.User;

/**
 * Created by raulbr on 2/26/17.
 */
public interface ILoginPresenter {
    public void login(User user);
    public void register(User user);
    public void setCurrentUser(User user);
}
