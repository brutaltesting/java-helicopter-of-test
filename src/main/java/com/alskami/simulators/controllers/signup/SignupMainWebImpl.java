package com.alskami.simulators.controllers.signup;

import com.alskami.simulators.ClientSimulator;
import com.alskami.simulators.model.user.IUserModel;

/**
 * Created by klas on 15-12-01.
 */
public class SignupMainWebImpl implements ISignUpController {
    @Override
    public Object signupUser(IUserModel user, String password) {
        return null;
    }

    @Override
    public Object signupUser(String username, String password, String firstName, String lastName) {
        return null;
    }

    @Override
    public void setSimulator(ClientSimulator simulator) {

    }

    @Override
    public ClientSimulator getSimulator() {
        return null;
    }
}
