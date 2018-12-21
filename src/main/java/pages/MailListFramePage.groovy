package pages

import geb.Page
import modules.MailInfoModule

/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
class MailListFramePage extends Page {

    // 该页面一定存在这样一个元素
    static at = { $('body#list.tbody') }

    static content = {

        // 邮件信息列表
        mailList { $('td.l').moduleList(MailInfoModule) }
    }

}
