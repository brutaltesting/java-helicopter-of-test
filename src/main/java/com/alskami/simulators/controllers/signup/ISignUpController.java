package com.alskami.simulators.controllers.signup;


import com.alskami.simulators.controllers.IController;
import com.alskami.simulators.model.user.IUserModel;

public interface ISignUpController extends IController{

    public Object signupUser(IUserModel user, String password);
    public Object signupUser(String username, String password, String firstName, String lastName);

}
