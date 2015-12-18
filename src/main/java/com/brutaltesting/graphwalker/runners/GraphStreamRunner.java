package com.brutaltesting.graphwalker.runners;

import com.brutaltesting.graphwalker.modelimplementations.AddCreditsImpl;
import com.brutaltesting.graphwalker.modelimplementations.ModelPaymentsImpl;
import com.brutaltesting.graphwalker.observers.GraphStreamObserver;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphwalker.core.event.Observer;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

/**
 * Created by klas.flodqvist on 2015-05-21.
 */
public class GraphStreamRunner {

        public static void regTestRunner() {
            System.setProperty("org.graphstream.ui.renderer",
                    "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
            Graph graph = new SingleGraph("GraphWalker Graph Stream Reg Test runner");
            graph.display(true);
            Executor executor = new TestExecutor(ModelPaymentsImpl.class,
                    AddCreditsImpl.class);
            Observer observer = new GraphStreamObserver(graph);
            executor.getMachine().addObserver(observer);
            Result result = executor.execute();
            System.out.println("Done: [" + result.getCompletedCount() + "," + result.getFailedCount() + "]");
        }
}
