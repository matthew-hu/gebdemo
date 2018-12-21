package util

import geb.Browser
import groovy.util.logging.Slf4j
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
@Slf4j
class BrowserUtil {

    static Browser initBrowser(String baseUrl) {
        WebDriver chrome = initAndMaximizeChrome()
        new Browser(driver: chrome, baseUrl: baseUrl)
    }

    static WebDriver initAndMaximizeChrome() {
        WebDriver driver
        ChromeOptions options = new ChromeOptions()
        options.addArguments("start-maximized")
        // options.addArguments("--headless")
        // options.addArguments("--disable-gpu")

        driver = new ChromeDriver(options)
        return driver
    }

    static {
        String os = System.getProperty('os.name').toLowerCase()
        if (os.contains('windows')) {
            System.setProperty('webdriver.chrome.driver', 'src/bin/chromedriver.exe')
        }
        else {
            System.setProperty('webdriver.chrome.driver', 'src/bin/chromedriver')
        }
    }
}
