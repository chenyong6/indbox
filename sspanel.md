# Nice Tools



# [ss-panel](https://www.echoteen.com/ss-panel.html)

## LNMP



```shell
[root@localhost ~]# cd ~
[root@localhost ~]# ls
[root@localhost ~]# mkdir download
[root@localhost ~]# cd download/
# install nginx
[root@localhost download]# rpm -ivh  http://nginx.org/packages/centos/6/i386/RPMS/nginx-1.10.0-1.el6.ngx.i386.rpm
```

[Mariadb](https://mariadb.com/kb/en/mariadb/yum/)

```shell
vim /etc/yum.repos.d/MariaDB.repo
[mariadb]
name = MariaDB
baseurl = http://yum.mariadb.org/10.1/centos6-x86
gpgkey=https://yum.mariadb.org/RPM-GPG-KEY-MariaDB
gpgcheck=1

yum update

sudo yum install MariaDB-server MariaDB-client
```

 





![golang](pic/golang.jpg)