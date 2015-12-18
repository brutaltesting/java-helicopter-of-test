package com.brutaltesting.helicopters.model;

import com.brutaltesting.helicopters.Helicopter;

/**
 * Created by klas on 15-12-01.
 */
public interface IModel {
    public void setSimulator(Helicopter simulator);
    public Helicopter getSimulator();
}
