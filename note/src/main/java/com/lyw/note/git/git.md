# git
## git代理全局设置
git config --global http.proxy 'socks5://127.0.0.1:1080'

git config --global https.proxy 'socks5://127.0.0.1:1080'

## git只针对github设置代理和取消代理
git config --global http.https://github.com.proxy socks5://127.0.0.1:1080

git config --global --unset http.https://github.com.proxy
# git代理设置
## 使用http或者https代理
git config --global https.proxy http://127.0.0.1:1080'

git config --global https.proxy 'https://127.0.0.1:1080'
## 或者使用sock5代理
git config --global https.proxy 'socks5://127.0.0.1:1080'

git config --global https.proxy 'socks5://127.0.0.1:1080'
## 取消代理
git config --global --unset http.proxy

git config --global --unset https.proxy