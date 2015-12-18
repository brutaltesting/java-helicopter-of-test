package com.brutaltesting.helicopters.controllers.login;

import com.brutaltesting.helicopters.Helicopter;

/**
 * Created by klas on 15-12-01.
 */
public class LoginMainWebImpl implements ILoginController{
    private Helicopter simulator;

    @Override
    public Helicopter getSimulator() {
        return simulator;
    }

    @Override
    public void setSimulator(Helicopter simulator) {
        this.simulator = simulator;
    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void logout() {

    }
}
