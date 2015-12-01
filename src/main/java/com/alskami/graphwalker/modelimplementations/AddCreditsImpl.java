package com.alskami.graphwalker.modelimplementations;

import com.alskami.graphwalker.GraphwalkerTestBase;
import com.alskami.graphwalker.regtests.Model_AddCredit;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by klas.flodqvist on 2015-05-21.
 */
@GraphWalker(value = "random(edge_coverage(100))")
public class AddCreditsImpl extends GraphwalkerTestBase implements Model_AddCredit{
    private static Logger logger = LoggerFactory.getLogger(AddCreditsImpl.class);
    private String attributeNameBalance = "balance";
    private Float attributeValueBalance = 0f;
    private String attributeNameMinBalanceCall = "minBalanceCall";
    private Float attributeValueMinBalanceCall = 2f;

    @Override
    public void v_callFailedNoCredits() {
        logger.debug("Call failed no credits (as expected)");
    }

    @Override
    public void e_disableATUSetting() {
        logger.debug("Disable Auto Top Up with Settings");
    }

    @Override
    public void e_enableATUSetting() {
        logger.debug("Enable Auto Top Up with Settings");

    }

    @Override
    public void v_AutoTopupEnabled() {
        logger.debug("Verify Auto Top Up enabled");
        logger.debug("Balance=" + getAttribute(attributeNameBalance));
    }

    @Override
    public void e_AddCreditIVR() {

    }

    @Override
    public void e_AddCreditATUEnabled() {
        logger.debug("Add 10 dollar Auto Top Up");
        add10Dollar();
    }

    @Override
    public void e_addCreditSavedCard() {

    }

    @Override
    public void v_ATU_state_Any() {

    }

    @Override
    public void e_goToAtuState() {

    }

    @Override
    public void e_AddCreditNoATU() {
        logger.debug("Add 10 dollar no Auto Top Up enabled");
        add10Dollar();

    }


    @Override
    public void v_AutoTopupDisabled() {
        logger.debug("Verify Auto Top Up is Disabled");
        logger.debug("Balance=" + getAttribute(attributeNameBalance));
    }


    @Override
    public void e_call15Sec() {
        logger.debug("Make a call during 15 seconds");
        Float startBalance = (Float) getAttribute(attributeNameBalance);
        Float newBalance = startBalance - 3.1f;
        setAttribute(attributeNameBalance, Math.max(newBalance, 0f));

    }

    @Override
    public void v_AddCredit() {
        logger.debug("Add Credit starting point AC model");

    }

    @Override
    public void v_AutoTopUpTriggered() {
        logger.debug("Verify that Auto Top Up was triggered");
    }

    private void add10Dollar(){
        Float startBalance = (Float) getAttribute(attributeNameBalance);
        Float newBalance = startBalance + 10f;
        setAttribute(attributeNameBalance, newBalance);
    }

    @Override
    public void e_startAddCredit() {
        logger.debug("Start add credit");
        setAttribute(attributeNameBalance, 0f);

    }

    @Override
    public void v_startAddCredits() {
        logger.debug("Verify start add credit");
        logger.debug("Start balance: " + getAttribute(attributeNameBalance));
        logger.debug("Start minBalanceCall: " + getAttribute(attributeNameMinBalanceCall));

    }

    @Override
    public void e_exitAddCredit() {

    }

    @Override
    public void e_autoTriggerATU() {

    }
}
