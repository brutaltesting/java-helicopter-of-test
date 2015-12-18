package com.brutaltesting.helicopters;

import com.brutaltesting.helicopters.controllers.ControllerType;
import com.brutaltesting.helicopters.controllers.login.LoginMainWebImpl;
import com.brutaltesting.helicopters.controllers.signup.SignupMainWebImpl;
import com.brutaltesting.helicopters.views.ViewType;
import com.brutaltesting.helicopters.views.signupandlogin.SignupAndLoginWeb;

/**
 * Created by klas on 15-12-01.
 */
public class HelicopterFactory {

    public static Helicopter getMainWebSimulator(){
        Helicopter simulator = new Helicopter();

        simulator.addController(ControllerType.SIGN_UP, new SignupMainWebImpl());
        simulator.addController(ControllerType.LOGIN, new LoginMainWebImpl());

        simulator.addView(ViewType.SIGNUP, new SignupAndLoginWeb());

        return simulator;
    }
}
