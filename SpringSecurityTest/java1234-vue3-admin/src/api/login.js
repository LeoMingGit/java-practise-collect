import requestUtil from '@/utils/request'

// 获取验证码
export function getCodeImg() {
    return requestUtil.get('/captcha')
}
