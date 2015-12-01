package com.alskami.simulators.controllers.login;

import com.alskami.simulators.ClientSimulator;

/**
 * Created by klas on 15-12-01.
 */
public class LoginMainWebImpl implements ILoginController{
    private ClientSimulator simulator;

    @Override
    public ClientSimulator getSimulator() {
        return simulator;
    }

    @Override
    public void setSimulator(ClientSimulator simulator) {
        this.simulator = simulator;
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void logout() {

    }
}
