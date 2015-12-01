package com.alskami.simulators;

/**
 * created by klas.flodqvist on 2015-03-18.
 */
public class ClientSimulatorEvent {
    protected com.alskami.simulators.ClientSimulator simulator;


    public ClientSimulator getSimulator() {
        return simulator;
    }

    public void setSimulator(ClientSimulator simulator) {
        this.simulator = simulator;
    }
}
