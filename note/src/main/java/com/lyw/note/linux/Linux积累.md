#Linux积累
1. grep 'q_fts_ffcas_file_generate_success' /wls/applogs/rtlog/fts/biz/*
2. 批量查询日志：
         zless /wls/applogs/rtlog/fis-web/20181031/integration/fis* | grep '1000010286948990'
3. grep -w 搜索完全匹配
4. 文本更改编码：LANG=zh_CN.utf8 
                               gbk
5. 按照特定分隔符读取文件某一列，累加并控制输出小数点位数  
    多分隔符：awk -F'[|::|]' '{var=sprintf("%.6f", sum+=$9)} END {print var*1000000}' KHKC_41_GSIS_20190201_00000002_STORAGE_1.txt  
    转义分隔符：awk -F'\\\|::\\\|' '{var=sprintf("%.6f", sum+=$3)} END {print var*1000000}' KHKC_41_GSIS_20190201_00000002_STORAGE_1.txt  
    less KHKC_41_GSIS_20190201_00000002_STORAGE_1.txt | awk -F '\\\|::\\\|' 'BEGIN{total=0;} {total+=$3} END{printf("%.6f\n",total);}'  
6. wc -l 查看文件多少行
7. 回滚：svn revert --depth=infinity index.html
8. 查看文件编码格式：vim打开文件，输入:fileencoding
9. linux文件权限：  
   drwxr-xr-x               chmod755  
   第一位表示文件类型。d是目录文件，l是链接文件，-是普通文件，p是管道  
   第2-4位表示这个文件的属主拥有的权限，r是读，w是写，x是执行。  
   第5-7位表示和这个文件属主所在同一个组的用户所具有的权限。  
   第8-10位表示其他用户所具有的权限。  
   chmod是Linux下设置文件权限的命令，后面的数字表示不同用户或用户组的权限  
   第一个数字表示文件所有者的权限  
   第二个数字表示与文件所有者同属一个用户组的其他用户的权限  
   第三个数字表示其它用户组的权限。  
   权限分为三种：读（r=4），写（w=2），执行（x=1）
10. SFTP：  
    登录：sftp user@host
11. kill -9
12. 长连接
13. 查看应用启动信息  
    ps aux | grep java
14. linux下查看进程启动、运行的时间等命令：  
    ps -eo pid,tty,user,comm,lstart,etime | grep java

