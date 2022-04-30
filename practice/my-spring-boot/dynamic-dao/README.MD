# 特别注意
***此中多数据源配置，有@Transactional注解的方法里面多数据源切换是不生效的。***

# 测试方式
## docker启动两个mysql
```bash
# 绑定3306端口
sudo docker run -p 3306:3306 --name mysql0 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
# 绑定3307端口
sudo docker run -p 3307:3306 --name mysql1 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
```
## 执行sql
### mysql0执行如下sql
```sql
CREATE DATABASE my_database0;
USE my_database0;
CREATE TABLE `my_table0` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(64) DEFAULT '' NOT NULL COMMENT '名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 COMMENT='第一张表';
SHOW TABLES;
```
### mysql1执行如下sql
```sql
CREATE DATABASE my_database1;
USE my_database1;
CREATE TABLE `my_table1` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` VARCHAR(64) DEFAULT '' NOT NULL COMMENT '名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 COMMENT='第一张表';
SHOW TABLES;
```