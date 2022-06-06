package Injection_module;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ScenarioContext {
    public DriverFactory driverFactory = new DriverFactory();
    public Props props = new Props();
    public TestData testData = new TestData();
}
