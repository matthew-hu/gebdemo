package pages

import geb.Page

/**
 * @author leiting.hlt
 * @date 2018/12/12
 */
class LoginPage extends Page {

    static url = 'cgi-bin/loginpage'
    static at = { title.contains('登录QQ邮箱') }

    static content = {
        loginFrame(page: LoginIFrame) { $('iframe#login_frame') }
    }

    def login(String username, String password) {
        withFrame(loginFrame) {
            // now at, LoginIFrame page
            innerLogin(username, password)
        }
    }
}
