package com.brutaltesting.helicopters.controllers.signup;


import com.brutaltesting.helicopters.controllers.IController;
import com.brutaltesting.helicopters.model.user.IUserModel;

public interface ISignUpController extends IController{

    public Object signupUser(IUserModel user, String password);
    public Object signupUser(String username, String password, String firstName, String lastName);

}
