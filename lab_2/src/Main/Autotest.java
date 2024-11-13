package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.LauncherDiscoveryRequest;


import Test.MainTests.ConfigTest;
import Test.MainTests.StrgTest;
import Test.MainTests.TrainTest;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Autotest {
    LogMode logMode;

    public void setLogMode(LogMode logMode) {
        this.logMode = logMode;
    }

    @Test
    public void Autotest() throws IOException {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage("Test.MainTests"))
                .build();

        Launcher launcher = LauncherFactory.create();

        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);
        TestExecutionSummary summary = listener.getSummary();

        String SuccesTests = ("Test run finished with " + summary.getTestsSucceededCount() + " tests succeeded.");
        String FailedTests = ("Test run finished with " + summary.getTestsFailedCount() + " tests failed.");
        View.view(SuccesTests + "\n" + FailedTests + "\n");
        logMode.LogWrite(SuccesTests);
        logMode.LogWrite(FailedTests);

        // Проверка успешности выполнения
        assertEquals(0, summary.getTestsFailedCount(), "Некоторые тесты не прошли.");
    }
}
