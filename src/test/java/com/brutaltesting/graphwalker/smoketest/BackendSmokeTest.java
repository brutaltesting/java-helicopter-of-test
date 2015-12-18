package com.brutaltesting.graphwalker.smoketest;

import com.brutaltesting.graphwalker.GraphwalkerTestBase;
import com.brutaltesting.helicopters.Helicopter;
import com.brutaltesting.helicopters.HelicopterFactory;
import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.java.annotation.GraphWalker;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.graphwalker.java.test.TestExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

@GraphWalker
public class BackendSmokeTest extends GraphwalkerTestBase implements Model_smoke_backend {
    public final static Path MODEL_PATH = Paths.get("com/alskami/graphwalker/smoketest/Model_smoke_backend.graphml");
    private static Logger logger = LoggerFactory.getLogger(BackendSmokeTest.class);


    @Override
    public void e_make_a_call() {
        System.out.println("Calling");
    }
    @Override
    public void v_Unauthorized() {
        System.out.println("Verifying unauthorized state");
    }

    @Override
    public void e_add10dollars() {
        setPreviousHelicopter(Helicopter.copy(getCurrentHelicopter()));
        System.out.println("Adding 10 dollar");
        //getCurrentClientSimulator().getCreditPurchaseController().buy10DollarCredit();
    }

    @Override
    public void v_CreditAdded() {
        System.out.println("Verifying credit added");
        //BigDecimal balanceBefore = getPreviousClientSimulator().getAccountModel().fetchCurrentBalance();
        //BigDecimal balanceAfter = getCurrentClientSimulator().getAccountModel().fetchCurrentBalance();
        //BigDecimal diff = balanceAfter.subtract(balanceBefore);
        //logger.debug("Balance after - balance before = " + diff);
        //getReport().appendStepResult("10 Dollars added", BigDecimal.valueOf(10d).compareTo(diff) == 0);
        getReport().assertReport();

    }

    @Override
    public void e_login() {
        logger.info("Logging in");
        String username = "";
        if(null == getCurrentHelicopter()){
            setCurrentHelicopter(HelicopterFactory.getMainWebSimulator());
            getCurrentHelicopter().getLoginController().login(username,getDefaultPassword());
        }else {
            getCurrentHelicopter().getLoginController().login(username, getDefaultPassword());
        }
        getReport().checkpoint("Logged in");
    }

    @Override
    public void v_LoggedIn() {
        System.out.println("Verifying logged in");

    }

    @Override
    public void v_CallAccounted() {
        System.out.println("Verifying call accounted");
    }

    @Override
    public void e_log_out() {
        logger.info("Loging out");
        getCurrentHelicopter().getLoginController().logout();
    }

    @Override
    public void e_signup() {
        logger.info("Start with signup");
        setCurrentHelicopter(HelicopterFactory.getMainWebSimulator());
        getCurrentHelicopter().getSignUpController().signupUser("TheKing", "InTheGhetto", "Elvis", "Presley");
        getReport().checkpoint("Signed up");
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
                .setContext(new BackendSmokeTest())
                .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
                //.setPathGenerator(new QuickRandomPath(new EdgeCoverage(80)))
                .setStart("e_init")
                .execute();
    }


    public static void main(String[] args) {

        TestExecutor executor = new TestExecutor(BackendSmokeTest.class);
        Result result = executor.execute();
        logger.info("Result: completed: " + result.getCompletedCount() + " failed: " + result.getFailedCount());
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