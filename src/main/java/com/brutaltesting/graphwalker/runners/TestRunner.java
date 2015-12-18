package com.brutaltesting.graphwalker.runners;

import com.brutaltesting.graphwalker.modelimplementations.ModelPaymentsImpl;
import com.brutaltesting.graphwalker.modelimplementations.AddCreditsImpl;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.testng.annotations.Test;

/**
 * Created by klas.flodqvist on 2015-05-21.
 */
public class TestRunner {

    @Test
    public static void regTestRunner() {
        Executor executor = new TestExecutor(ModelPaymentsImpl.class,
                AddCreditsImpl.class);
        Result result = executor.execute();
        System.out.println("Done: [" + result.getCompletedCount() + "," + result.getFailedCount() + "]");
    }
}
