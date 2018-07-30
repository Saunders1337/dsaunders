package com.adaptavist.tm4j.junit.result;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ExecutionResult {

    private String source;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String testCaseKey;
    private String result;

    public String getTestCaseKey() {
        return testCaseKey;
    }

    public void setTestCaseKey(String testCaseKey) {
        this.testCaseKey = testCaseKey;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
