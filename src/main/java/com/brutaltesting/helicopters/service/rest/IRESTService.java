package com.brutaltesting.helicopters.service.rest;

import com.brutaltesting.helicopters.Helicopter;

/**
 * Created by klas on 15-12-01.
 */
public interface IRESTService {
    public void setSimulator(Helicopter simulator);
    public Helicopter getSimulator();
}
