package com.brutaltesting.graphwalker.modelimplementations;

import com.brutaltesting.graphwalker.regtests.Model_payments;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by klas.flodqvist on 2015-05-21.
 */
@GraphWalker(value = "random(edge_coverage(100))")
public class ModelPaymentsImpl extends AddCreditsImpl implements Model_payments{
    private static Logger logger = LoggerFactory.getLogger(ModelPaymentsImpl.class);

    @Override
    public void e_make_a_call() {
    }

    @Override
    public void v_Unauthorized() {

    }

    @Override
    public void e_login() {

    }

    @Override
    public void v_AddCredit() {

    }

    @Override
    public void v_CallAccounted() {

    }

    @Override
    public void e_log_out() {

    }

    @Override
    public void e_signup() {

    }

    @Override
    public void e_init() {

    }
}
