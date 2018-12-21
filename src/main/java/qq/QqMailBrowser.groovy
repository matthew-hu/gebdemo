package qq

import geb.Browser
import groovy.util.logging.Slf4j
import pages.LoginPage
import pages.MailIndexPage
import util.BrowserUtil

/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
@Slf4j
class QqMailBrowser {

    boolean isLogin = false
    Browser browser = BrowserUtil.initBrowser('https://mail.qq.com/')

    /**
     * 登陆 QQ 邮箱
     *
     * @param username
     * @param password
     */
    def loginQqMail(String username, String password) {
        log.info("登陆 QQ 邮箱: loginQqMail username: ${username}, password: ${password}")

        if (isLogin) {
            log.info("已经是登陆状态, 跳过")
            return
        }

        Browser.drive(browser) {
            to LoginPage
            login(username, password)
        }
        log.info("登陆成功")
        isLogin = true
    }

    /**
     * 退出浏览器
     */
    void cleanUp() {
        try {
            browser.quit()
        } catch (Exception e) {
        }
        isLogin = false
    }

    /**
     * 阅读最新一份邮件的信息
     */
    def readLatestMailInfo() {
        log.info("阅读最新一份邮件的信息")
        Browser.drive(browser) {
            to MailIndexPage
            goReadMail()

            // now at, InboxPage
            readLatestMail()
        }
    }

    /**
     * 读取当前邮箱页面第一份主题满足给定正则表达式的邮件
     *
     * @param pattern
     */
    def readFirstMailWithTileMatchPattern(pattern) {
        log.info("读取当前邮箱页面第一份主题满足给定正则表达式的邮件")
        Browser.drive(browser) {
            to MailIndexPage
            goReadMail()

            // now at, InboxPage
            readFirstMailWithTileLike(pattern)
        }
    }

}
