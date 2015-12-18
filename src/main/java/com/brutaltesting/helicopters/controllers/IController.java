package com.brutaltesting.helicopters.controllers;

import com.brutaltesting.helicopters.Helicopter;

/**
 * Created by charlie.wang on 2015-07-09.
 */
public interface IController {
    public void setSimulator(Helicopter simulator);
    public Helicopter getSimulator();
}
