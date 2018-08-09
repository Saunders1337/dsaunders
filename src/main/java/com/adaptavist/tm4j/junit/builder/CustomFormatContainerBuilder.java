package com.adaptavist.tm4j.junit.builder;

import com.adaptavist.tm4j.junit.decorator.TestDescriptionDecorator;
import com.adaptavist.tm4j.junit.customformat.CustomFormatExecution;
import com.adaptavist.tm4j.junit.customformat.CustomFormatContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.adaptavist.tm4j.junit.customformat.CustomFormatConstants.FAILED;
import static com.adaptavist.tm4j.junit.customformat.CustomFormatConstants.PASSED;

public class CustomFormatContainerBuilder {

    private CustomFormatContainer customFormatContainer = new CustomFormatContainer();
    private List<TestDescriptionDecorator> failedTests = new ArrayList<>();

    public void registerFailure(TestDescriptionDecorator testDescriptionDecorator) {
        failedTests.add(testDescriptionDecorator);
    }

    public void registerFinished(TestDescriptionDecorator testDescriptionDecorator) {
        Optional<CustomFormatExecution> optionalCustomFormatExecution = customFormatContainer.getExecutionBySource(testDescriptionDecorator.getSource());

        if (optionalCustomFormatExecution.isPresent()) {
            CustomFormatExecution customFormatExecution = optionalCustomFormatExecution.get();

            updateResult(customFormatExecution, testDescriptionDecorator);
        } else {
            createResult(testDescriptionDecorator);
        }
    }

    private void createResult(TestDescriptionDecorator testDescriptionDecorator) {
        CustomFormatExecution customFormatExecution = new CustomFormatExecutionBuilder().build(testDescriptionDecorator).getCustomFormatExecution();

        updateResult(customFormatExecution, testDescriptionDecorator);

        customFormatContainer.addResult(customFormatExecution);
    }

    private void updateResult(CustomFormatExecution customFormatExecution, TestDescriptionDecorator testDescriptionDecorator) {
        String result = failedTests.contains(testDescriptionDecorator) ? FAILED : PASSED;
        customFormatExecution.setResult(result);
    }

    public CustomFormatContainer getCustomFormatContainer() {
        return customFormatContainer;
    }
}
