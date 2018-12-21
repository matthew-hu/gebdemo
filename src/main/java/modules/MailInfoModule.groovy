package modules

import geb.Module

/**
 * 建模收件箱中的每一份邮件（建模同一页面中的重复页面内容）
 * 发件人/主题/时间
 *
 * @author leiting.hlt
 * @date 2018/12/12
 */
class MailInfoModule extends Module {

    static content = {

        // 表格的单元格
        cell { int index -> $('td', index) }

        // 发件人
        sender { cell(0).text() }

        // 主题
        mailTitle { cell(2).text() }

        // 时间
        sendTime { cell(3).text() }
    }

}
