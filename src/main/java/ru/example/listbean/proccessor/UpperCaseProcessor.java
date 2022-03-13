package ru.example.listbean.proccessor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "bean", havingValue = "true")
public class UpperCaseProcessor implements Processor {

    @Override
    public String process(String str) {
        return str.toUpperCase();
    }
}
