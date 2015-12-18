package com.brutaltesting.helicopters.views;

import com.brutaltesting.helicopters.Helicopter;

/**
 * Created by klas on 15-12-01.
 */
public interface IView {
    public void setSimulator(Helicopter simulator);
    public Helicopter getSimulator();
}
