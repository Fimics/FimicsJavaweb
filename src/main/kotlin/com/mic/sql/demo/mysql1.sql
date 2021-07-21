# show databases ;
# create database javaweb character set gbk;
#create datatase if not exists javaweb;
# show create  database javaweb;
# show tables ;

# create database if not exists db4 character set gbk

#表操作
# create table student(
#                         id int,
#                         name varchar(32),
#                         age int ,
#                         score double(4,1),
#                         birthday date,
#                         insert_time timestamp
# );
# create table stu like student;
# select  * from student;
# show tables ;
# desc  stu;
# CREATE TABLE student3 (
#                           id int, -- 编号
#                           name varchar(20), -- 姓名
#                           age int, -- 年龄
#                           sex varchar(5), -- 性别
#                           address varchar(100), -- 地址
#                           math int, -- 数学
#                           english int -- 英语
# );
#
# INSERT INTO student3(id,NAME,age,sex,address,math,english) VALUES (1,'马云',55,'男','
# 杭州',66,78),(2,'马化腾',45,'女','深圳',98,87),(3,'马景涛',55,'男','香港',56,77),(4,'柳岩
# ',20,'女','湖南',76,65),(5,'柳青',20,'男','湖南',86,NULL),(6,'刘德华',57,'男','香港
# ',99,99),(7,'马德',22,'女','香港',99,99),(8,'德玛西亚',18,'男','南京',56,65);
# select * from student3;
# select  name ,age from student3;
# select age from student3 where age>50;
# select  * from student3 group by  age;
# select  distinct address from student3;(去重要保证结果集一样)
# select  * from student3 order by age desc ;
# select name,english ,math,math+english from student3; //NUll+any =0如何解决
# select  name,english,math ,math+ifnull(english,0) from student3;
# select  name,english 英语,math 数学 ,math+ifnull(english,0) 总分 from student3; #起别名

件查询
		1. where子句后跟条件
		2. 运算符
			* > 、< 、<= 、>= 、= 、<>
			* BETWEEN...AND
			* IN( 集合)
			* LIKE：模糊查询
				* 占位符：
					* _:单个任意字符
					* %：多个任意字符
			* IS NULL
			* and  或 &&
			* or  或 ||
			* not  或 !

#-- 查询年龄大于20岁
SELECT * FROM student3 WHERE age > 20;
SELECT * FROM student3 WHERE age >= 20;

-- 查询年龄等于20岁
# SELECT * FROM student3 WHERE age = 20;
#
# -- 查询年龄不等于20岁
# SELECT * FROM student3 WHERE age != 20;
# SELECT * FROM student3 WHERE age <> 20;

# -- 查询年龄大于等于20 小于等于30
# SELECT * FROM student3 WHERE age >= 20 &&  age <=30;
# SELECT * FROM student3 WHERE age >= 20 AND  age <=30;
# SELECT * FROM student3 WHERE age BETWEEN 20 AND 30;

# -- 查询年龄22岁，18岁，25岁的信息
# SELECT * FROM student3 WHERE age = 22 OR age = 18 OR age = 25
# SELECT * FROM student3 WHERE age IN (22,18,25);

-- 查询英语成绩为null
# SELECT * FROM student3 WHERE english = NULL; -- 不对的。null值不能使用 = （!=） 判断
# SELECT * FROM student3 WHERE english IS NULL;

# -- 查询英语成绩不为null
# SELECT * FROM student3 WHERE english  IS NOT NULL;

# -- 查询姓马的有哪些？ like
# SELECT * FROM student3 WHERE NAME LIKE '马%';
# -- 查询姓名第二个字是化的人
# SELECT * FROM student3 WHERE NAME LIKE "_化%";

# -- 查询姓名是3个字的人
# SELECT * FROM student3 WHERE NAME LIKE '___';
#
# -- 查询姓名中包含德的人
# SELECT * FROM student3 WHERE NAME LIKE '%德%';



