import org.junit.AfterClass
import org.junit.Test
import qq.QqMailBrowser

/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
class QqTest {

    static QqMailBrowser qMail = new QqMailBrowser()


    @AfterClass
    static void tearDown() {
        qMail.cleanUp()
    }


    @Test
    void "登陆QQ"() {
        qMail.loginQqMail('****@qq.com', '****')
    }

    @Test
    void "阅读邮件"() {
        qMail.loginQqMail('****@qq.com', '****')
        qMail.readLatestMailInfo()
        qMail.readFirstMailWithTileMatchPattern(~/交通银行/)

    }

    @Test
    void "写新邮件"() {

    }
}
