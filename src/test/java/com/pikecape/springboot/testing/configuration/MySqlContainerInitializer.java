package com.pikecape.springboot.testing.configuration;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MySQLContainer;

public class MySqlContainerInitializer implements
    ApplicationContextInitializer<ConfigurableApplicationContext>, AfterAllCallback {

  private static final MySQLContainer mySqlContainer = new MySQLContainer(
      "mysql:latest")
      .withDatabaseName("myql")
      .withUsername("admin")
      .withPassword("admin");


  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    mySqlContainer.start();

    TestPropertyValues.of(
        "spring.datasource.url=" + mySqlContainer.getJdbcUrl(),
        "spring.datasource.username=" + mySqlContainer.getUsername(),
        "spring.datasource.password=" + mySqlContainer.getPassword()
    ).applyTo(applicationContext.getEnvironment());
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    if (mySqlContainer == null) {
      return;
    }
    mySqlContainer.close();
  }
}
