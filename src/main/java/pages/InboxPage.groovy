package pages

import geb.Page
import groovy.util.logging.Slf4j

/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
@Slf4j
class InboxPage extends Page {

    static at = { title == "QQ邮箱 - 收件箱" }

    static content = {

        // 邮件列表
        mailListFrame(page: MailListFramePage) { $('div#mainFrameContainer iframe') }
    }

    /**
     * 读取收件箱中最新的一份邮件
     *
     * @return
     */
    def readLatestMail() {
        withFrame(mailListFrame) {
            // now at, MailListFramePage
            if (mailList?.size()) {
                log.info("${mailList[0].sender} 于 ${mailList[0].sendTime} 发送了主题为: ${mailList[0].mailTitle} 的邮件给您")
            }
            else {
                log.warn("您的收件箱中目前没有邮件")
            }
        }
    }

    /**
     * 读取收件箱当前页面中，最近的一份标题满足某个条件的邮件
     *
     * @param pattern
     * @return
     */
    def readFirstMailWithTileLike(pattern) {
        withFrame(mailListFrame) {
            def theMail = mailList?.find { it.mailTitle =~ pattern }
            if (theMail) {
                log.info("最近一份主题匹配 ${pattern} 的邮件是 ${theMail.sender} 于 ${theMail.sendTime} 发给您的, 主题为: ${theMail.mailTitle}")
            }
            else {
                log.warn("当前收件箱页面未找到主题匹配 ${pattern} 的邮件")
            }
        }
    }
}
