package org.polo.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.polo.PoloApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = PoloApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
