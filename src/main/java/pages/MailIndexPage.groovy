package pages

import geb.Page
import groovy.util.logging.Slf4j

/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
@Slf4j
class MailIndexPage extends Page {

    static at = { title == 'QQ邮箱' }

    // 无法使用右键检查元素的页面
    static content = {

        // 写信
        writeMailLink { $('a#composebtn') }

        // 收信
        receiveMailLink { $('a#readmailbtn_link') }

        // 收件箱
        inboxLink(to: InboxPage, toWait: true) { $('a#folder_1') }
    }

    /**
     * 去写信
     */
    def goWriteMail() {

    }

    /**
     * 去收信
     */
    def goReceiveMail() {

    }

    /**
     * 去收件箱页面
     * @return
     */
    def goReadMail() {
        log.info("去收件箱页面")
        inboxLink.click()
    }
}
