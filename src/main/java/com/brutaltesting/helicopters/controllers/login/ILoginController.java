package com.brutaltesting.helicopters.controllers.login;

import com.brutaltesting.helicopters.controllers.IController;

/**
 * Created by klas on 15-12-01.
 */
public interface ILoginController extends IController{
    public void login(String username, String password);
    public void logout();
}
