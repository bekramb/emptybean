package ru.example.listbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.example.listbean.proccessor.Processor;

import java.util.Optional;

@SpringBootApplication
public class EmptyBeanApplication implements ApplicationRunner {

    private final Optional<Processor> processor;

    @Value("${stringValue}")
    private String value;

    public EmptyBeanApplication(Optional<Processor> processor) {
        this.processor = processor;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmptyBeanApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) {

        value = processor.map(p -> p.process(value)).orElse(value);
    }

    public String getValue() {
        return value;
    }
}
