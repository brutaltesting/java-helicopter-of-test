package com.alskami.graphwalker.observers;

import com.alskami.graphwalker.GraphwalkerTestBase;
import com.alskami.simulators.ClientSimulator;
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
                testBase.setPreviousClientSimulator(ClientSimulator.copy(testBase.getCurrentClientSimulator()));
            }
        }
    }
}
