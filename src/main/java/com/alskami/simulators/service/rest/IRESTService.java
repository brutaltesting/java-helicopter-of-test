package com.alskami.simulators.service.rest;

import com.alskami.simulators.ClientSimulator;

/**
 * Created by klas on 15-12-01.
 */
public interface IRESTService {
    public void setSimulator(ClientSimulator simulator);
    public ClientSimulator getSimulator();
}
