package com.alskami.simulators.model;

import com.alskami.simulators.ClientSimulator;

/**
 * Created by klas on 15-12-01.
 */
public interface IModel {
    public void setSimulator(ClientSimulator simulator);
    public ClientSimulator getSimulator();
}
