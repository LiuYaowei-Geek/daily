#JAVA
1. new出来的对象，基本类型为初始值，String类型为"null"，Object为null
2. 接口调用时，使用BeanCopy，在对象类型不同时，不能copy
3. spring的BeanUtils.copyProperties()在对象类型不同时，会复制为键值对HashMap
4. list遍历删除时，使用迭代器进行删除
5. 一字节等于8位
6. 8种基本类型长度：byte = 1字节（8位）, shor = 2byte, char = 2byte, int = 4byte, float = 4byte, long = 8byte, double = 8byte, boolean = 1bit

##内存可见性和原子性：Synchronized和Volatile的比较
[参考文章](https://blog.csdn.net/guyuealian/article/details/52525724)  
###Java内存模型
1. Java中所有变量都存储在主内存中
2. 每个线程都有自己独立的工作内存，里面保存该线程使用到的变量副本（副本的主内存中该变量的拷贝）
![Java内存模型](./pictures/Java内存模型.png "Java内存模型")
3. 线程对共享变量的所有操作只能在自己的工作内存中进行，不能直接在主内存中进行读写
4. 不同线程间不能直接访问彼此的工作内存中的变量，线程间变量值的传递需要通过主内存来完成
###可见性与原子性
1. 可见性：一个线程对共享变量的修改能够及时被其他线程看到
2. 原子性：操作不可再分
###Synchronized与Volatile:  
1. Synchronized：保证可见性与原子性  
Synchronized能够实现原子性和可见性；在Java内存模型中，synchronized规定，线程在加锁时，先清空工作内存→在主内存中拷贝最新变量的副本到工作内存→执行完代码→将更改后的共享变量的值刷新到主内存中→释放互斥锁。
2. Volatile：保证可见性，但不保证操作的原子性  
Volatile实现内存可见性是通过store和load指令完成的；也就是对volatile变量执行写操作时，会在写操作后加入一条store指令，即强迫线程将最新的值刷新到主内存中；而在读操作时，会加入一条load指令，即强迫从主内存中读入变量的值。但volatile不保证volatile变量的原子性
3. Synchronized和Volatile的比较  
a. Synchronized保证内存可见性和操作的原子性  
b. Volatile只能保证内存可见性  
c. Volatile不需要加锁，比Synchronized更轻量级，并不会阻塞线程（volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞。）  
b. volatile标记的变量不会被编译器优化,而synchronized标记的变量可以被编译器优化（如编译器重排序的优化）  
d. volatile是变量修饰符，仅能用于变量，而synchronized是一个方法或块的修饰符。  
e. volatile本质是在告诉JVM当前变量在寄存器中的值是不确定的，使用前，需要先从主存中读取，因此可以实现可见性。而对n=n+1,n++等操作时，volatile关键字将失效，不能起到像synchronized一样的线程同步（原子性）的效果。

##Java中异常
1. Throwable为父类
2. Error为子类：指java运行时系统的内部错误和资源耗尽错误。应用程序不会抛出该类对象。如果 出现了这样的错误，除了告知用户，剩下的就是尽力使程序安全的终止
3. Exception为子类：有两个子类，一个是运行时异常 RuntimeException ，一个是 CheckedException
4. RuntimeException：在 Java 虚拟机正常运行期间抛出的异常的超类。 如果出现RuntimeException，那么一 定是程序员的错误（NullPointerException、ClassCastException）
5. CheckedException：：一般是外部错误，这种异常都发生在编译阶段，Java 编译器会强 制程序去捕获此类异常，即会出现要求你把这段可能出现异常的程序进行 try catch（ IOException、SQLException）

##泛型
1. Java 中的泛型基本上都是在编译器这个层次来实现
2. 泛型的继承：  
```java
//正确
class Son1<T> extends Father<T>{}// 最正常的继承，子类的泛型参数和父类的参数是一致的
class Son2<E, F> extends Father<F>{}// 子类增加了一个泛型参数，父类的泛型参数不能遗漏，所以仍然要定义
class Son4 extends Father<Integer>{}// 继承时指定父类的泛型参数，子类就不用再写泛型参数，如果写了，那就是子类自己新增加的
class Son5<T> extends Father<Integer>{}// 父类指定了类型，子类又增加了，这时子类的只是新增加的泛型参数，跟父类没有关系
class Son3 extends Father{}// 继承时不指定父类的泛型参数,会有警告信息：Father is a raw type.References to generic type Father<T> should be parameterized
class Son8<T, E extends T> extends Father<T>{}// 父类和子类的泛型参数具有关系
//错误
class Son7 extends Father<T>{}//父类的类型参数不明确
class Son9<E, E super T> extends Father<T>{}// 下面的写法也是错误的，要是父类的T为Object 这时E是什么呢
```

##创建线程的四种方法
1. 继承Thread类

##线程池

##hashCode与equals()