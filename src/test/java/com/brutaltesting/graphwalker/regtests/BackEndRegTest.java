package com.brutaltesting.graphwalker.regtests;

import com.brutaltesting.graphwalker.modelimplementations.ModelPaymentsImpl;
import com.brutaltesting.graphwalker.runners.TestRunner;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by klas.flodqvist on 2015-05-21.
 */
@GraphWalker
public class BackEndRegTest extends ModelPaymentsImpl implements Model_payments{
    public final static Path MODEL_PATH = Paths.get("com/alskami/graphwalker/regtests/Model_payments.graphml");
    private static Logger logger = LoggerFactory.getLogger(BackEndRegTest.class);

    @Test
    public void runFuncionalRegTest(){
        //Context context = new BackEndRegTest();
        //runFunctionalTest(MODEL_PATH, context, 100, "e_init");
        //GraphStreamRunner.regTestRunner();
        TestRunner.regTestRunner();
    }
}
