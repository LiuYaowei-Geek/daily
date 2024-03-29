#database
##Oracle
###索引-index
1. 是一种快速查询表中内容的机制
2. 运用在表中某些字段上，但存储时，独立于表外
####索引的特点
1. 索引一旦建立,Oracle管理系统会对其进行自动维护, 而且由Oracle管理系统决定何时使用索引
2. 用户不用在查询语句中指定使用哪个索引
3. 在定义primary key或unique约束后系统自动在相应的列上创建索引
4. 用户也能按自己的需求，对指定单个字段或多个字段，添加索引
####索引的优缺点
1. 索引加快数据库的检索速度
2. 索引降低了插入、删除、修改等维护任务的速度(虽然索引可以提高查询速度，但是它们也会导致数据库系统更新数据的性能下降，因为大部分数据更新需要同时更新索引)
3. 唯一索引可以确保每一行数据的唯一性，通过使用索引，可以在查询的过程中使用优化隐藏器，提高系统的性能
4. 索引需要占物理和数据空间
####索引分类
1. **唯一索引**：唯一索引不允许两行具有相同的索引值
2. **主键索引**：为表定义一个主键将自动创建主键索引，主键索引是唯一索引的特殊类型。主键索引要求主键中的每个值是唯一的，并且不能为空
3. **聚集索引(*Clustered*)**：表中各行的物理顺序与键值的逻辑（索引）顺序相同，每个表只能有一个
4. **非聚集索引(*Non-clustered*)**：非聚集索引指定表的逻辑顺序。数据存储在一个位置，索引存储在另一个位置，索引中包含指向数据存储位置的指针。可以有多个，小于249个
###rowid
1. 位于每个表中，但表面上看不见，例如：desc emp是看不见的
2. 只有在select中，显示写出rowid，方可看见
3. 它与每个表绑定在一起，表亡，该表的rowid亡，二张表rownum可以相同，但rowid必须是唯一的
4. rowid是18位大小写加数字混杂体，唯一表代该条记录在DBF文件中的位置
5. rowid可以参与=/like比较时，用''单引号将rowid的值包起来，且区分大小写
6. rowid是联系表与DBF文件的桥梁
###ACID-数据库事务正确执行的四个基本要素：
1. Atomicity-原子性
2. Consistency-一致性
3. Isolation-隔离性
4. Durability-持久性
###事务隔离级别：
1. Serializable-可避免脏读，不可重复读、虚读
2. Repeatable read-可避免脏读，不可重复读
3. Read committed-可避免脏读
4. Read uncommitted-级别最低，什么也避免不了
###脏读
一个事务读取到另外一个事务未提交的数据
>example:A向B转账，A执行了转账语句，但A还没有提交事务，B读取数据，发现自己账户钱变多了！B跟A说，我已经收到钱了。A回滚事务【rollback】，等B再查看账户的钱时，发现钱并没有多。
###不可重复读
一个事务读取到另外一个事务已经提交的数据，也就是说一个事务可以看到其他事务所做的修改
>example:A查询数据库得到数据，B去修改数据库的数据，导致A多次查询数据库的结果都不一样
【危害：A每次查询的结果都是受B的影响的，那么A查询出来的信息就没有意思了】
###虚读（幻读）
是指在一个事务内读取到了别的事务插入的数据，导致前后读取不一致
>和不可重复读类似，但虚读(幻读)会读到其他事务的插入的数据，导致前后读取不一致
###悲观锁与乐观锁
确保在多个事务同时存取数据库中同一数据时不破坏事务的隔离性和统一性以及数据库的统一性，乐观锁和悲观锁是并发控制主要采用的技术手段。
####悲观锁：假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作
1. 在查询完数据的时候就把事务锁起来，直到提交事务
2. 实现方式：使用数据库中的锁机制
####乐观锁：假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。
1. 在修改数据的时候把事务锁起来，通过version的方式来进行锁定
2. 实现方式：使用version版本或者时间戳
###SQL约束
1. NOT NULL: 用于控制字段的内容一定不能为空（NULL）。
2. UNIQUE: 控件字段内容不能重复，一个表允许有多个 Unique 约束。
3. PRIMARY KEY: 也是用于控件字段内容不能重复，但它在一个表只允许出现一个。
4. FOREIGN KEY: 用于预防破坏表之间连接的动作，也能防止非法数据插入外键列，因为它必须是它指向的那个表中的值之一。
5. CHECK: 用于控制字段的值范围。
##MySQL
###存储引擎数据结构
B+Tree：基于 B Tree 和叶子节点顺序访问指针进行实现，它具有 B Tree 的平衡性，并且通过顺序访问指针来提高区间查询的性能。
###索引
索引是在存储引擎层实现的，而不是在服务器层实现的，所以不同存储引擎具有不同的索引类型和实现。
1. B+Tree 索引
>是大多数 MySQL 存储引擎的默认索引类型。  
>因为不再需要进行全表扫描，只需要对树进行搜索即可，所以查找速度快很多。  
>因为 B+ Tree 的有序性，所以除了用于查找，还可以用于排序和分组。  
>可以指定多个列作为索引列，多个索引列共同组成键。  
>适用于全键值、键值范围和键前缀查找，其中键前缀查找只适用于最左前缀查找。如果不是按照索引列的顺序进行查找，则无法使用索引。  
>InnoDB 的 B+Tree 索引分为主索引和辅助索引。
>>主索引的叶子节点 data 域记录着完整的数据记录，这种索引方式被称为**聚簇索引**。因为无法把数据行存放在两个不同的地方，所以一个表只能有一个聚簇索引。  
>>辅助索引的叶子节点的 data 域记录着主键的值，因此在使用辅助索引进行查找时，需要先查找到主键值，然后再到主索引中进行查找。
2. 哈希索引
>InnoDB 存储引擎有一个特殊的功能叫“自适应哈希索引”，当某个索引值被使用的非常频繁时，会在 B+Tree 索引之上再创建一个哈希索引，这样就让 B+Tree 索引具有哈希索引的一些优点，比如快速的哈希查找。  
>哈希索引能以 O(1) 时间进行查找，但是失去了有序性：
>>无法用于排序与分组；  
>>只支持精确查找，无法用于部分查找和范围查找。  
3. 全文索引
>MyISAM 存储引擎支持全文索引，用于查找文本中的关键词，而不是直接比较是否相等。  
查找条件使用 MATCH AGAINST，而不是普通的 WHERE。  
全文索引使用倒排索引实现，它记录着关键词到其所在文档的映射。  
InnoDB 存储引擎在 MySQL 5.6.4 版本中也开始支持全文索引。
3. 空间数据索引
>MyISAM 存储引擎支持空间数据索引（R-Tree），可以用于地理数据存储。空间数据索引会从所有维度来索引数据，可以有效地使用任意维度来进行组合查询。  
必须使用 GIS 相关的函数来维护数据。
####索引优化
1. 独立的列  
在进行查询时，索引列不能是表达式的一部分，也不能是函数的参数，否则无法使用索引。  
例如下面的查询不能使用 actor_id 列的索引：
```roomsql
SELECT actor_id FROM sakila.actor WHERE actor_id + 1 = 5;
```
2. 多列索引  
在需要使用多个列作为条件进行查询时，使用多列索引比使用多个单列索引性能更好。例如下面的语句中，最好把 actor_id 和 film_id 设置为多列索引。
```roomsql
SELECT film_id, actor_ id FROM sakila.film_actor
WHERE actor_id = 1 AND film_id = 1;
```
3. 索引列的顺序  
让选择性最强的索引列放在前面。  
索引的选择性是指：不重复的索引值和记录总数的比值。最大值为 1，此时每个记录都有唯一的索引与其对应。选择性越高，每个记录的区分度越高，查询效率也越高。  
例如下面显示的结果中 customer_id 的选择性比 staff_id 更高，因此最好把 customer_id 列放在多列索引的前面。
```roomsql
SELECT COUNT(DISTINCT staff_id)/COUNT(*) AS staff_id_selectivity,
COUNT(DISTINCT customer_id)/COUNT(*) AS customer_id_selectivity,
COUNT(*)
FROM payment;
```
4. 前缀索引  
对于 BLOB、TEXT 和 VARCHAR 类型的列，必须使用前缀索引，指索引开始的部分字符。  
前缀长度的选取需要根据索引选择性来确定。
5. 覆盖索引  
索引包含所有需要查询的字段的值。  
具有以下优点：  
索引通常远小于数据行的大小，只读取索引能大大减少数据访问量。  
一些存储引擎（例如 MyISAM）在内存中只缓存索引，而数据依赖于操作系统来缓存。因此，只访问索引可以不使用系统调用（通常比较费时）。  
对于 InnoDB 引擎，若辅助索引能够覆盖查询，则无需访问主索引。  
####索引的优点
大大减少了服务器需要扫描的数据行数。  
帮助服务器避免进行排序和分组，以及避免创建临时表（B+Tree 索引是有序的，可以用于 ORDER BY 和 GROUP BY 操作。临时表主要是在排序和分组过程中创建，不需要排序和分组，也就不需要创建临时表）。  
将随机 I/O 变为顺序 I/O（B+Tree 索引是有序的，会将相邻的数据都存储在一起）。
####索引的使用条件
对于非常小的表、大部分情况下简单的全表扫描比建立索引更高效；  
对于中到大型的表，索引就非常有效；  
但是对于特大型的表，建立和维护索引的代价将会随之增长。这种情况下，需要用到一种技术可以直接区分出需要查询的一组数据，而不是一条记录一条记录地匹配，例如可以使用分区技术。
###查询性能优化
1. 使用 Explain 进行分析  
Explain 用来分析 SELECT 查询语句，开发人员可以通过分析 Explain 结果来优化查询语句。  
比较重要的字段有：  
select_type : 查询类型，有简单查询、联合查询、子查询等  
key : 使用的索引  
rows : 扫描的行数
2. 优化数据访问  
**减少请求的数据量**  
只返回必要的列：最好不要使用 SELECT * 语句。  
只返回必要的行：使用 LIMIT 语句来限制返回的数据。  
缓存重复查询的数据：使用缓存可以避免在数据库中进行查询，特别在要查询的数据经常被重复查询时，缓存带来的查询性能提升将会是非常明显的。  
**减少服务器端扫描的行数**  
最有效的方式是使用索引来覆盖查询。
3. 重构查询方式  
**切分大查询**  
一个大查询如果一次性执行的话，可能一次锁住很多数据、占满整个事务日志、耗尽系统资源、阻塞很多小的但重要的查询。  
**分解大连接查询**  
将一个大连接查询分解成对每一个表进行一次单表查询，然后在应用程序中进行关联，这样做的好处有：  
>让缓存更高效。对于连接查询，如果其中一个表发生变化，那么整个查询缓存就无法使用。而分解后的多个查询，即使其中一个表发生变化，对其它表的查询缓存依然可以使用。  
分解成多个单表查询，这些单表查询的缓存结果更可能被其它查询使用到，从而减少冗余记录的查询。  
减少锁竞争；  
在应用层进行连接，可以更容易对数据库进行拆分，从而更容易做到高性能和可伸缩。  
查询本身效率也可能会有所提升。例如下面的例子中，使用 IN() 代替连接查询，可以让 MySQL 按照 ID 顺序进行查询，这可能比随机的连接要更高效。
```roomsql
SELECT * FROM tag
JOIN tag_post ON tag_post.tag_id=tag.id
JOIN post ON tag_post.post_id=post.id
WHERE tag.tag='mysql';
```
```roomsql
SELECT * FROM tag WHERE tag='mysql';
SELECT * FROM tag_post WHERE tag_id=1234;
SELECT * FROM post WHERE post.id IN (123,456,567,9098,8904);
```
###常用储存引擎
1. Innodb引擎，Innodb引擎提供了对数据库ACID事务的支持。并且还提供了行级锁和外键的约束。它的设计的目标就是处理大数据容量的数据库系统。
2. MyISAM引擎(原本Mysql的默认引擎),不提供事务的支持，也不支持行级锁和外键。
3. MEMORY引擎：所有的数据都在内存中，数据的处理速度快，但是安全性不高。
>同一个数据库也可以使用多种存储引擎的表。如果一个表修改要求比较高的事务处理，可以选择InnoDB。这个数据库中可以将查询要求比较高的表选择MyISAM存储。如果该数据库需要一个用于查询的临时表，可以选择MEMORY存储引擎
####InnoDB与MyIASM区别
1. 事务：InnoDB 是事务型的，可以使用 Commit 和 Rollback 语句。
2. 并发：MyISAM 只支持表级锁，而 InnoDB 还支持行级锁。
3. 外键：InnoDB 支持外键。
4. 备份：InnoDB 支持在线热备份。
5. 崩溃恢复：MyISAM 崩溃后发生损坏的概率比 InnoDB 高很多，而且恢复的速度也更慢。
6. 其它特性：MyISAM 支持压缩表和空间数据索引。
###数据类型
1. 整型  
TINYINT, SMALLINT, MEDIUMINT, INT, BIGINT 分别使用 8, 16, 24, 32, 64 位存储空间，一般情况下越小的列越好。  
INT(11) 中的数字只是规定了交互工具显示字符的个数，对于存储和计算来说是没有意义的。
2. 浮点数  
FLOAT 和 DOUBLE 为浮点类型，DECIMAL 为高精度小数类型。CPU 原生支持浮点运算，但是不支持 DECIMAl 类型的计算，因此 DECIMAL 的计算比浮点类型需要更高的代价。  
FLOAT、DOUBLE 和 DECIMAL 都可以指定列宽，例如 DECIMAL(18, 9) 表示总共 18 位，取 9 位存储小数部分，剩下 9 位存储整数部分。
3. 字符串  
主要有 CHAR 和 VARCHAR 两种类型，一种是定长的，一种是变长的。  
VARCHAR 这种变长类型能够节省空间，因为只需要存储必要的内容。但是在执行 UPDATE 时可能会使行变得比原来长，当超出一个页所能容纳的大小时，就要执行额外的操作。MyISAM 会将行拆成不同的片段存储，而 InnoDB 则需要分裂页来使行放进页内。  
在进行存储和检索时，会保留 VARCHAR 末尾的空格，而会删除 CHAR 末尾的空格。
4. 时间和日期  
MySQL 提供了两种相似的日期时间类型：DATETIME 和 TIMESTAMP。  
**DATETIME**  
能够保存从 1000 年到 9999 年的日期和时间，精度为秒，使用 8 字节的存储空间。  
它与时区无关。  
默认情况下，MySQL 以一种可排序的、无歧义的格式显示 DATETIME 值，例如“2008-01-16 22:37:08”，这是 ANSI 标准定义的日期和时间表示方法。
**TIMESTAMP**  
和 UNIX 时间戳相同，保存从 1970 年 1 月 1 日午夜（格林威治时间）以来的秒数，使用 4 个字节，只能表示从 1970 年到 2038 年。  
它和时区有关，也就是说一个时间戳在不同的时区所代表的具体时间是不同的。  
MySQL 提供了 FROM_UNIXTIME() 函数把 UNIX 时间戳转换为日期，并提供了 UNIX_TIMESTAMP() 函数把日期转换为 UNIX 时间戳。  
默认情况下，如果插入时没有指定 TIMESTAMP 列的值，会将这个值设置为当前时间。  
应该尽量使用 TIMESTAMP，因为它比 DATETIME 空间效率更高。
###切分
####水平切分
水平切分又称为 Sharding，它是将同一个表中的记录拆分到多个结构相同的表中。  
当一个表的数据不断增多时，Sharding 是必然的选择，它可以将数据分布到集群的不同节点上，从而缓存单个数据库的压力。
#####Sharding 策略
哈希取模：hash(key) % N；  
范围：可以是 ID 范围也可以是时间范围；  
映射表：使用单独的一个数据库来存储映射关系。
#####Sharding 存在的问题
1. 事务问题  
使用分布式事务来解决，比如 XA 接口。
2. 连接  
可以将原来的连接分解成多个单表查询，然后在用户程序中进行连接。
3. ID唯一性  
使用全局唯一 ID（GUID）  
为每个分片指定一个 ID 范围  
分布式 ID 生成器 (如 Twitter 的 Snowflake 算法)
####垂直切分  
垂直切分是将一张表按列切分成多个表，通常是按照列的关系密集程度进行切分，也可以利用垂直切分将经常被使用的列和不经常被使用的列切分到不同的表中。  
在数据库的层面使用垂直切分将按数据库中表的密集程度部署到不同的库中，例如将原来的电商数据库垂直切分成商品数据库、用户数据库等。
###复制
####主从复制

主要涉及三个线程：binlog 线程、I/O 线程和 SQL 线程。  
binlog 线程 ：负责将主服务器上的数据更改写入二进制日志（Binary log）中。  
I/O 线程 ：负责从主服务器上读取二进制日志，并写入从服务器的中继日志（Relay log）。   
SQL 线程 ：负责读取中继日志，解析出主服务器已经执行的数据更改并在从服务器中重放（Replay）。
####读写分离
主服务器处理写操作以及实时性要求比较高的读操作，而从服务器处理读操作。  
读写分离能提高性能的原因在于：  
主从服务器负责各自的读和写，极大程度缓解了锁的争用；  
从服务器可以使用 MyISAM，提升查询性能以及节约系统开销；  
增加冗余，提高可用性。  
读写分离常用代理方式来实现，代理服务器接收应用层传来的读写请求，然后决定转发到哪个服务器。
https://juejin.im/post/5a9ca0d6518825555c1d1acd#heading-38  
https://www.xuxueli.com/blog/?blog=./notebook/4-%E6%95%B0%E6%8D%AE%E5%BA%93/MySQL.md  
https://blog.csdn.net/a745233700/article/details/80959716