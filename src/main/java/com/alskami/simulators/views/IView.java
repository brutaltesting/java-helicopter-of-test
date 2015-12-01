package com.alskami.simulators.views;

import com.alskami.simulators.ClientSimulator;

/**
 * Created by klas on 15-12-01.
 */
public interface IView {
    public void setSimulator(ClientSimulator simulator);
    public ClientSimulator getSimulator();
}
