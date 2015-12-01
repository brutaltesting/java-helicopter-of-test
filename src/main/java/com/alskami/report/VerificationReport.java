package com.alskami.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;

/**
 * VerificationReport is a way to collect information about the verification steps and uniformly 
 * report, e.g. to an assert to provide more extensive information than true or false.
 * 
 * Usage:
 * VerificationReport report = new VerificationReport("My report");
 * // Inform about debug information, e.g. in parameters to the test.
 * report.setDebugParameters("UserId=" + userId);
 * // Verify something 
 * report.appendStepResult(true, "My first step passed with in parameters " + inParams)
 * // Verify something else
 * report.appendStepResult(false, "My 2:nd step failed with in parameters " + inParams)
 * Assert.assertTrue(report.isOK(), report.getResultString);
 * 
 * @author klas.flodqvist
 *
 */
public class VerificationReport {
	private static Logger log = LoggerFactory.getLogger(VerificationReport.class);
	private String reportName;
	private String debugInfo;
	private ArrayList<ReportStep> testSteps;
	
	public VerificationReport(String reportName){
		setReportName(reportName);
		setDebugInfo("");
		this.testSteps = new ArrayList<ReportStep>();
	}
	
	public String getDebugInfo() {
		return debugInfo;
	}

	public void setDebugInfo(String debugParameters) {
		this.debugInfo = debugParameters;
	}

    public void checkpoint(String checkpointInfo){
        testSteps.add(new ReportStep(true, "Checkpoint: " + checkpointInfo));
    }

	public void appendStepResult(String expectedResult, boolean pass){
		appendStepResult(pass, expectedResult);
	}
	
	public void appendStepResult(boolean pass, String expectedResult){
		testSteps.add(new ReportStep(pass, expectedResult));

		if(pass){
			log.debug("PASS: - " + expectedResult);
		}else{
			log.error("FAIL: - " + expectedResult);
		}
	}
	
	public String getResultString(){
		String msg = "\n";
		msg += "***** VerificationReport: " + getReportName() + " *****\n";

		String result;
		if(isOK()){
			result = "PASS";
		}else{
			result = "FAIL";
		}
		msg += "*** Total Result: " + result + "\n";
		
		msg += "Debug information: " + getDebugInfo() + "\n";
		
		for(ReportStep testStep : testSteps){
			String stepRes = "";
			if(testStep.pass){
				stepRes = "PASS";
			}else{
				stepRes = "FAIL";
			}
			msg += stepRes + " - " + testStep.getMsg() + "\n";
		}
		log.debug(msg);
		return msg;
	}
	
	/**
	 *  If any step fails, return false, else true.
	 */
	public boolean isOK(){
		for(ReportStep step: testSteps){
			if(!step.isPass()){
				return false;
			}
		}
		return true;
	}

    public void assertReport(){
        assertReport(false);
    }

    public void assertReport(boolean keepPreviousResult){
        log.info("Asserting report: \n" + getResultString());
        Assert.assertTrue(isOK(), getResultString());
        if(!keepPreviousResult){
            testSteps.clear();
        }
	}

	private String getReportName() {
		return reportName;
	}

	private void setReportName(String reportName) {
		this.reportName = reportName;
	}	

	@Override
	public String toString() {
		return getResultString();
	}

	private class ReportStep {
		public boolean pass = true;
		public String msg = "";
		public ReportStep(boolean pass, String msg){
			setPass(pass);
			setMsg(msg);
		}
		public boolean isPass() {
			return pass;
		}
		public void setPass(boolean pass) {
			this.pass = pass;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		@Override
		public String toString() {
			return "ReportStep [pass=" + pass + ", msg=" + msg + "]";
		}
		
		
	}

}
