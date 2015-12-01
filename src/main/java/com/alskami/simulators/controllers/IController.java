package com.alskami.simulators.controllers;

import com.alskami.simulators.ClientSimulator;

/**
 * Created by charlie.wang on 2015-07-09.
 */
public interface IController {
    public void setSimulator(ClientSimulator simulator);
    public ClientSimulator getSimulator();
}
