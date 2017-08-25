package cookbook.controllers

import org.openqa.selenium.Capabilities
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.phantomjs.PhantomJSDriverService
import org.openqa.selenium.remote.DesiredCapabilities

environments {

    reportsDir = "target/geb-reports"

    waiting {
        timeout = 15
        retryInterval = 0.5
    }

    driver = {
        Capabilities caps = DesiredCapabilities.phantomjs()

        def phantomJsDriver = new PhantomJSDriver(PhantomJSDriverService.createDefaultService(caps), caps)
        phantomJsDriver.manage().window().maximize()

        return phantomJsDriver
    }

//    driver = {
//        System.setProperty('webdriver.chrome.driver', '/Users/clayweidinger/projects/big-underwriting-assistant/server/src/systemtest/groovy/chromedriver')
//        ChromeOptions options = new ChromeOptions()
//        options.addArguments("--disable-popup-blocking");
//        def driverInstance = new ChromeDriver(options)
//        driverInstance.manage().window().maximize()
//        driverInstance
//    }
}

/*

//These settings enable remote debugging on localhost:9000 but phantomjs will not shutdown properly so you have to kill it manually
//        Capabilities caps = new DesiredCapabilities("phantomjs.cli.args":["--remote-debugger-port=9000"] as String[]);
//        caps.browserName = "phantomjs"
//        caps.version = ""
//        caps.platform = Platform.ANY
}

 */