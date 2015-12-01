package com.alskami.simulators;

import com.alskami.simulators.controllers.ControllerType;
import com.alskami.simulators.controllers.login.LoginMainWebImpl;
import com.alskami.simulators.controllers.signup.SignupMainWebImpl;
import com.alskami.simulators.views.ViewType;
import com.alskami.simulators.views.signupandlogin.SignupAndLoginWeb;

/**
 * Created by klas on 15-12-01.
 */
public class ClientSimulatorFactory {

    public static ClientSimulator getMainWebSimulator(){
        ClientSimulator simulator = new ClientSimulator();

        simulator.addController(ControllerType.SIGN_UP, new SignupMainWebImpl());
        simulator.addController(ControllerType.LOGIN, new LoginMainWebImpl());

        simulator.addView(ViewType.SIGNUP, new SignupAndLoginWeb());

        return simulator;
    }
}
