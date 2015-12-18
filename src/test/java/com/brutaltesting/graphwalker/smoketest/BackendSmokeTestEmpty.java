package com.brutaltesting.graphwalker.smoketest;

import com.brutaltesting.graphwalker.GraphwalkerTestBase;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.TestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

@GraphWalker
public class BackendSmokeTestEmpty extends GraphwalkerTestBase implements Model_smoke_backend {
    public final static Path MODEL_PATH = Paths.get("com/alskami/graphwalker/smoketest/Model_smoke_backend.graphml");
    private static Logger logger = LoggerFactory.getLogger(BackendSmokeTestEmpty.class);


    @Override
    public void e_make_a_call(){
        logger.info("Calling");
    }

    @Override
    public void v_Unauthorized() {
        logger.info("Verifying unauthorized state");
    }

    @Override
    public void e_add10dollars() {
        logger.info("Adding 10 dollar");
    }

    @Override
    public void v_CreditAdded() {
        logger.info("Verifying credit added");
    }

    @Override
    public void e_login() {
        logger.info("Logging in");
    }

    @Override
    public void v_LoggedIn() {
        logger.info("Verifying logged in");
    }

    @Override
    public void v_CallAccounted() {
        logger.info("Verifying call accounted");
    }

    @Override
    public void e_log_out() {
        logger.info("Loging out");
    }

    @Override
    public void e_signup() {
        logger.info("Start with signup");
    }

    @Override
    public void e_init() {
        logger.info("Init test");
    }


/*    @Test
    public void runSmokeTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new BackendSmokeTest())
                .setPathGenerator(new AStarPath(new ReachedVertex("v_Browse")))
                .setStart("e_Init")
                .execute();
    }*/

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new BackendSmokeTestEmpty())
                .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
                //.setPathGenerator(new QuickRandomPath(new EdgeCoverage(80)))
                .setStart("e_init")
                .execute();
    }



/*    @Test
    public void runStabilityTest() {
        new TestBuilder()
                .setModel(MODEL_PATH)
                .setContext(new BackendSmokeTest())
                .setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)))
                .setStart("e_Init")
                .execute();
    }*/
}