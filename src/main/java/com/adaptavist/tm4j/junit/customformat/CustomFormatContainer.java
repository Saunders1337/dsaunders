package com.adaptavist.tm4j.junit.customformat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomFormatContainer {

    private List<CustomFormatExecution> executions = new ArrayList<>();

    public List<CustomFormatExecution> getExecutions() {
        return executions;
    }

    public void setExecutions(List<CustomFormatExecution> executions) {
        this.executions = executions;
    }

    public void addResult(CustomFormatExecution customFormatExecution) {
        executions.add(customFormatExecution);
    }

    public Optional<CustomFormatExecution> getExecutionBySource(String source) {
        return executions
                .stream()
                .filter(r -> r.getSource().equals(source))
                .findFirst();
    }
}
