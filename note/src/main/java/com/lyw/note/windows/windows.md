#windows
##端口
1. 查找所有端口:`netstat -ano`
2. 查找具体端口号：`netstat -aon | findstr "8080"`
3. 查找进程：`tasklist|findstr "21548"`
4. 结束进程：` taskkill /F /PID 10760`