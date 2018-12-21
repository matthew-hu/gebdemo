/**
 * @author leiting.hlt
 * @date 2018/09/15
 */

reportsDir = "target/geb-reports"
cacheDriver = false

waiting {
    timeout = 10
    retryInterval = 1
    includeCauseInMessage = true

    presets {
        slow {
            timeout = 30
            retryInterval = 2
        }
        quick {
            timeout = 5
            retryInterval = 1
        }
    }
}

atCheckWaiting = true

withWindow.close = true

withNewWindow {
    close = false
    wait = true
}

autoClearCookies = false

reportOnTestFailureOnly = true

autoClearWebStorage = false

baseNavigatorWaiting = true

templateOptions {
    cache = false
    wait = true
    toWait = true
    // 这个也吃过亏，不加*，对于返回多个元素的 Navigator 验证不过
    // 如果只使用 it*.displayed
    // 就限制了内容定义必须返回 Navigator
    waitCondition = {  it instanceof String || it*.displayed}
    required = false
    min = 0
    // 因为这个吃过亏 当时设置成1 抛出 ContentCountOutOfBoundsException
    max = 200
}

