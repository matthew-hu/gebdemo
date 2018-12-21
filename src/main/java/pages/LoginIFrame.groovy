package pages

import geb.Page
import geb.module.TextInput

/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
class LoginIFrame extends Page {

    static content = {
        nameInput { $('input', name: 'u') }
        passwordInput { $('input', type: 'password') }
        submit(to: MailIndexPage, toWait: true) { $('input#login_button') }
    }

    def innerLogin(String username, String password) {
        nameInput.module(TextInput).text = username
        passwordInput = password
        submit.click()
    }
}
