package ru.example.listbean;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "bean=true")
class EmptyBeanApplicationWithBeanTest {

    @Autowired
    private EmptyBeanApplication emptyBeanApplication;

    @Value("${stringValue}")
    private String value;

    @Test
    void checkWithBeanTest() {

        assertThat(emptyBeanApplication.getValue()).isEqualTo(value.toUpperCase());
    }


}
