package com.brutaltesting.graphwalker.observers;

import com.brutaltesting.graphwalker.GraphwalkerTestBase;
import com.brutaltesting.helicopters.Helicopter;
import org.graphwalker.core.event.EventType;
import org.graphwalker.core.event.Observer;
import org.graphwalker.core.machine.Machine;
import org.graphwalker.core.model.Edge;
import org.graphwalker.core.model.Element;

/**
 * Created by klas.flodqvist on 2015-04-20.
 */
public class EdgeObserver implements Observer{
    private GraphwalkerTestBase testBase;

    public EdgeObserver(GraphwalkerTestBase testBase){
        this.testBase = testBase;
    }

    public GraphwalkerTestBase getTestBase() {
        return testBase;
    }

    public void setTestBase(GraphwalkerTestBase testBase) {
        this.testBase = testBase;
    }

    @Override
    public void update(Machine machine, Element element, EventType eventType) {
        if(EventType.BEFORE_ELEMENT.equals(eventType)){
            if(element instanceof Edge.RuntimeEdge){
                testBase.setPreviousHelicopter(Helicopter.copy(testBase.getCurrentHelicopter()));
            }
        }
    }
}
