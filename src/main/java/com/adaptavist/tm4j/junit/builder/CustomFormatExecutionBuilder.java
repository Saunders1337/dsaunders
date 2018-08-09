package com.adaptavist.tm4j.junit.builder;

import com.adaptavist.tm4j.junit.customformat.CustomFormatExecution;
import com.adaptavist.tm4j.junit.decorator.TestDescriptionDecorator;

public class CustomFormatExecutionBuilder {

    private final CustomFormatExecution customFormatExecution;

    public CustomFormatExecutionBuilder() {
        customFormatExecution = new CustomFormatExecution();
    }

    public CustomFormatExecutionBuilder build(TestDescriptionDecorator testDescriptionDecorator) {
        customFormatExecution.setTestCase(testDescriptionDecorator.getTestCase());
        customFormatExecution.setSource(testDescriptionDecorator.getSource());

        return this;
    }

    public CustomFormatExecution getCustomFormatExecution() {
        return customFormatExecution;
    }
}
