package com.alskami.graphwalker;

import com.alskami.report.VerificationReport;
import com.alskami.simulators.ClientSimulator;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.Context;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

/**
 * Created by klas.flodqvist on 2015-04-20.
 */
public class GraphwalkerTestBase extends ExecutionContext {
    private static Logger logger = LoggerFactory.getLogger(GraphwalkerTestBase.class);
    private String defaultPassword;
    private VerificationReport report;
    private ClientSimulator currentClientSimulator;
    private ClientSimulator previousClientSimulator;

    public GraphwalkerTestBase(){
        setDefaultTestParameters();
    }

    protected void setDefaultTestParameters(){
        defaultPassword = "123210";
        report = new VerificationReport("Graphwalker default report");
    }

/*    @BeforeElement
    public void beforeElement(){
        Element element = getNextElement();
        if(null != element && element.getName().startsWith("e_")){
            setPreviousClientEmulator(ClientEmulator.copy(getCurrentClientEmulator()));
        }
        logger.debug("PreviousClientEmulator set to: " + getPreviousClientEmulator());
    }*/

    public ClientSimulator getCurrentClientSimulator() {
        return currentClientSimulator;
    }

    public void setCurrentClientSimulator(ClientSimulator currentClientSimulator) {
        this.currentClientSimulator = currentClientSimulator;
    }

    public ClientSimulator getPreviousClientSimulator() {
        return previousClientSimulator;
    }

    public void setPreviousClientSimulator(ClientSimulator previousClientSimulator) {
        this.previousClientSimulator = previousClientSimulator;
    }

    public String getDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = defaultPassword;
    }

    public VerificationReport getReport() {
        return report;
    }

    public void setReport(VerificationReport report) {
        this.report = report;
    }

    public static void runFunctionalTest(Path model_path, Context testClass, int percentageEdgeCoverage, String startEdgeName) {

        new TestBuilder()

                .setModel(model_path)
                .setContext(testClass)
                .setPathGenerator(new RandomPath(new EdgeCoverage(percentageEdgeCoverage)))
                        //.setPathGenerator(new QuickRandomPath(new EdgeCoverage(80)))
                .setStart(startEdgeName)
                .execute();
    }
}
