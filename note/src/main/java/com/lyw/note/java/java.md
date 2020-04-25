#JAVA
1. new出来的对象，基本类型为初始值，String类型为"null"，Object为null
2. 接口调用时，使用BeanCopy，在对象类型不同时，不能copy
3. spring的BeanUtils.copyProperties()在对象类型不同时，会复制为键值对HashMap
4. list遍历删除时，使用迭代器进行删除