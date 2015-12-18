package com.brutaltesting.helicopters.controllers.signup;

import com.brutaltesting.helicopters.Helicopter;
import com.brutaltesting.helicopters.model.user.IUserModel;

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
    public void setSimulator(Helicopter simulator) {

    }

    @Override
    public Helicopter getSimulator() {
        return null;
    }
}
