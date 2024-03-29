# JAVA

## jvm
### jvm内存区域

#### 虚拟机栈
是描述java方法执行的内存模型，每个方法在执行时都会创建一个栈帧
##### 栈帧
局部变量表、操作数栈、动态链接、方法出口

#### 本地方法栈
类似虚拟机栈，为native方法服务

#### 程序计数器（线程私有）
是当前线程所执行的字节码的行号指示器，
正在执行Java方法时，计数器记录的是虚拟机字节码指令的地址。
是唯一一个在虚拟机中没有固定任何oom的区域

#### 堆
创建的对象和数组保存在堆中，是垃圾收集的最重要区域

#### 元数据
存储被jvm加载的类信息、常量、静态变量、即时编译器编译后的代码

## 基础
1. new出来的对象，基本类型为初始值，String类型为""，Object为null
2. 接口调用时，使用BeanCopy，在对象类型不同时，不能copy
3. spring的BeanUtils.copyProperties()在对象类型不同时，会复制为键值对HashMap
4. list遍历删除时，使用迭代器进行删除
5. 一字节等于8位
6. 8种基本类型长度：byte = 1字节（8位）, short = 2byte, char = 2byte, int = 4byte, float = 4byte, long = 8byte, double = 8byte, boolean = 1bit
7. 基本类型长度，n为位数长度。-2^(n-1) ~ 2^(n-1)-1
8. 字符整型大小，a-z:97-122, A-Z:65-90

## 位运算
### 异或运算 ^
相同位，同为0，异为1
### 与运算 &
相同位的两个数字都为1，则为1；若有一个不为1，则为0。
### 或运算 |
相同位只要一个为1即为1
### 右移运算 >>
二进制，右移多少位，高位补零
### 左移运算 <<
二进制，左移多少位，高位补零

## 内存可见性和原子性：Synchronized和Volatile的比较
[参考文章](https://blog.csdn.net/guyuealian/article/details/52525724)  
### Java内存模型
1. Java中所有变量都存储在主内存中
2. 每个线程都有自己独立的工作内存，里面保存该线程使用到的变量副本（副本的主内存中该变量的拷贝）
![Java内存模型](./pictures/Java内存模型.png "Java内存模型")
3. 线程对共享变量的所有操作只能在自己的工作内存中进行，不能直接在主内存中进行读写
4. 不同线程间不能直接访问彼此的工作内存中的变量，线程间变量值的传递需要通过主内存来完成
### 可见性与原子性
1. 可见性：一个线程对共享变量的修改能够及时被其他线程看到
2. 原子性：操作不可再分
### Synchronized与Volatile:  
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

## Java中异常
1. Throwable为父类
2. Error为子类：指java运行时系统的内部错误和资源耗尽错误。应用程序不会抛出该类对象。如果 出现了这样的错误，除了告知用户，剩下的就是尽力使程序安全的终止
3. Exception为子类：有两个子类，一个是运行时异常 RuntimeException ，一个是 CheckedException
4. RuntimeException：在 Java 虚拟机正常运行期间抛出的异常的超类。 如果出现RuntimeException，那么一 定是程序员的错误（NullPointerException、ClassCastException）
5. CheckedException：：一般是外部错误，这种异常都发生在编译阶段，Java 编译器会强 制程序去捕获此类异常，即会出现要求你把这段可能出现异常的程序进行 try catch（ IOException、SQLException）

## 泛型
1. Java 中的泛型基本上都是在编译器这个层次来实现
2. Java中泛型是伪泛型
3. 泛型的好处：
适用于多种数据类型执行相同的代码
泛型中的类型在使用时指定
泛型归根到底就是“模版”
4. 泛型的继承：  
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

## 创建线程的四种方法
1. 继承Thread类

## 线程池

## hashCode与equals()

## 集合
1. Collection：List、Set、Queue。对象的集合
2. Map：TreeMap、HashMap、HashTable。键值对映射表

### Set
TreeSet：基于红黑树实现，支持有序性操作，例如根据一个范围查找元素的操作。但是查找效率不如 HashSet，HashSet 查找的时间复杂度为 O(1)，TreeSet 则为 O(logN)。

HashSet：基于哈希表实现，支持快速查找，但不支持有序性操作。并且失去了元素的插入顺序信息，也就是说使用 Iterator 遍历 HashSet 得到的结果是不确定的。

LinkedHashSet：具有 HashSet 的查找效率，并且内部使用双向链表维护元素的插入顺序。

### List
ArrayList：基于动态数组实现，支持随机访问。

Vector：和 ArrayList 类似，但它是线程安全的。

LinkedList：基于双向链表实现，只能顺序访问，但是可以快速地在链表中间插入和删除元素。不仅如此，LinkedList 还可以用作栈、队列和双向队列。

### Queue
LinkedList：可以用它来实现双向队列。

PriorityQueue：基于堆结构实现，可以用它来实现优先队列。

### Map
TreeMap：基于红黑树实现。

HashMap：基于哈希表实现。

HashTable：和 HashMap 类似，但它是线程安全的，这意味着同一时刻多个线程同时写入 HashTable 不会导致数据不一致。它是遗留类，不应该去使用它，而是使用 ConcurrentHashMap 来支持线程安全，ConcurrentHashMap 的效率会更高，因为 ConcurrentHashMap 引入了分段锁。

LinkedHashMap：使用双向链表来维护元素的顺序，顺序为插入顺序或者最近最少使用（LRU）顺序。

### ArrayList
1. 默认大小为10，扩容newCapacity = oldCapacity + (oldCapacity >> 1)，新容量为旧容量的1.5倍，调用 Arrays.copyOf()把原数组整个复制到新数组中
2. 删除元素调用System.arraycopy()将index+1后面的元素都复制到index位置上，该操作的时间复杂度为O(N)
3. 序列化，保存元素的数组 elementData 使用 transient 修饰，该关键字声明数组默认不会被序列化。
序列化时需要使用 ObjectOutputStream 的 writeObject() 将对象转换为字节流并输出。
而 writeObject() 方法在传入的对象存在 writeObject() 的时候会去反射调用该对象的 writeObject() 来实现序列化。
反序列化使用的是 ObjectInputStream 的 readObject() 方法
4. modCount 用来记录 ArrayList 结构发生变化的次数。
结构发生变化是指添加或者删除至少一个元素的所有操作，或者是调整内部数组的大小，仅仅只是设置元素的值不算结构发生变化。
在进行序列化或者迭代等操作时，需要比较操作前后 modCount 是否改变，如果改变了需要抛出 ConcurrentModificationException。
代码参考上节序列化中的 writeObject() 方法。

### CopyOnWriteArrayList
#### 读写分离
写操作在一个复制的数组上进行，读操作还是在原始数组中进行，读写分离，互不影响。

写操作需要加锁，防止并发写入时导致写入数据丢失。

写操作结束之后需要把原始数组指向新的复制数组。
```java
public boolean add(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] elements = getArray();
            int len = elements.length;
            Object[] newElements = Arrays.copyOf(elements, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }
```

#### 适用场景
CopyOnWriteArrayList 在写操作的同时允许读操作，大大提高了读操作的性能，因此很适合读多写少的应用场景。

但是 CopyOnWriteArrayList 有其缺陷：

内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右；
数据不一致：读操作不能读取实时性的数据，因为部分写操作的数据还未同步到读数组中。

所以 CopyOnWriteArrayList 不适合内存敏感以及对实时性要求很高的场景。

### LinkedList
#### 概览
基于双向链表实现，使用 Node 存储链表节点信息。
```java
private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
```

每个链表存储了 first 和 last 指针
```java
transient Node<E> first;
transient Node<E> last;
```

#### LinkedList与ArrayList的比较
ArrayList 基于动态数组实现，LinkedList 基于双向链表实现。
ArrayList 和 LinkedList 的区别可以归结为数组和链表的区别：

数组支持随机访问，但插入删除的代价很高，需要移动大量元素；
链表不支持随机访问，但插入删除只需要改变指针。

### HashMap JDK1.8
1. 位置要么在原位置，要么在增加2次幂的位置（数组大小为2的幂）
2. HashMap中，如果key经过hash算法得出的数组索引位置全部不相同，即Hash算法非常好，那样的话，getKey方法的时间复杂度就是O(1)，
如果Hash算法技术的结果碰撞非常多，假如Hash算极其差，所有的Hash算法结果得出的索引位置一样，那样所有的键值对都集中到一个桶中，或者在一个链表中，或者在一个红黑树中，时间复杂度分别为O(n)和O(lgn)。
3. 初始大小16。扩容每次变大2倍。大于等于8时，从8位置开始转为红黑树
4. 线程不安全，在resize中的指向下一个Entry时会出现环形链表
5. 解决hash冲突：拉链法。hash值相同的直接追加（链表或红黑树）
6. 键值可以为null，键位null只有一个，在位置0上

### HashMap线程不安全
1. 在JDK1.7中，当并发执行扩容操作时会造成环形链和数据丢失的情况。
2. 在JDK1.8中，在并发执行put操作时会发生数据覆盖的情况。

### HashTable
put和get方法使用synchronized修饰，保证线程安全
11
不能插入键值为null的

### ConcurrentHashMap
JDK 1.7 使用分段锁机制来实现并发更新操作，核心类为 Segment，它继承自重入锁 ReentrantLock，并发度与 Segment 数量相等。

JDK 1.8 使用了 CAS 操作来支持更高的并发度，在 CAS 操作失败时使用内置锁 synchronized。

并且 JDK 1.8 的实现也在链表过长时会转换为红黑树。

#### 如何避免并发
首先new一个新的hash表(nextTable)出来，大小是原来的2倍。后面的rehash都是针对这个新的hash表操作，不涉及原hash表(table)。

然后会对原hash表(table)中的每个链表进行rehash，此时会尝试获取头节点的锁。这一步就保证了在rehash的过程中不能对这个链表执行put操作。

通过sizeCtl控制，使扩容过程中不会new出多个新hash表来。

最后，将所有键值对重新rehash到新表(nextTable)中后，用nextTable将table替换。这就避免了HashMap中get和扩容并发时，可能get到null的问题。

在整个过程中，共享变量的存储和读取全部通过volatile或CAS的方式，保证了线程安全。

### LinkedHashMap
继承自HashMap, 内部维护了一个双向链表用来维护插入顺序或者 LRU 顺序。

accessOrder 决定了顺序，默认为 false，此时维护的是插入顺序。
#### afterNodeAccess()
当一个节点被访问时(调用get方法)，如果 accessOrder 为 true，则会将该节点移到链表尾部。
也就是说指定为 LRU 顺序之后，在每次访问一个节点时，会将这个节点移到链表尾部，保证链表尾部是最近访问的节点，那么链表首部就是最近最久未使用的节点。

#### afterNodeInsertion()
put 等操作之后执行，当 removeEldestEntry() 方法返回 true 时会移除最晚的节点，也就是链表首部节点 first。
 
#### LRU 缓存
下是使用 LinkedHashMap 实现的一个 LRU 缓存：

设定最大缓存空间 MAX_ENTRIES 为 3；
使用 LinkedHashMap 的构造函数将 accessOrder 设置为 true，开启 LRU 顺序；
覆盖 removeEldestEntry() 方法实现，在节点多于 MAX_ENTRIES 就会将最近最久未使用的数据移除。
```java
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
    LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }
}
```
## CAS
CAS的全称是 Compare-and-Swap

原子操作：读-修改-写

CAS 有三个参数：V，A，B。
内存值 V、旧的预期值 A、要修改的值 B，当且仅当预期值 A 和内存值 V 相同时，将内存值修改为 B 并返回 true，否则什么都不做并返回 false。
CAS指令执行时，当且仅当V的值等于预期值A时，才会将V的值设为B。
在多线程的情况下，当多个线程同时使用CAS操作一个变量时，只有一个会成功并更新值，其余线程均会失败，但失败的线程不会被挂起，而是不断的再次循环重试。
正是基于这样的原理，CAS即使没有使用锁，也能发现其他线程对当前线程的干扰，从而进行及时的处理。可见CAS 其实是一个乐观锁

CAS操作大概有如下几步:
1. 读取旧值为一个临时变量
2. 对旧值的临时变量进行操作或者依赖旧值临时变量进行一些操作
3. 判断旧值临时变量是不是等于旧值，等于则没被修改，那么新值写入；不等于则被修改，此时放弃或者从步骤1重试。

缺点:
1. ABA的问题，就是一个值从A变成了B又变成了A，
使用CAS操作不能发现这个值发生变化了，因为CAS需要在操作值的时候检查下值有没有发生变化，如果没有发生变化则更新，
但是如果一个值原来是A，变成了B，又变成了A，那么使用CAS进行检查时会发现它的值没有发生变化，但是实际上却变化了。
ABA问题的解决思路就是使用版本号。在变量前面追加上版本号，每次变量更新的时候把版本号加一，那么A－B－A 就会变成1A-2B－3A。
也可以使用携带类似时间戳的版本AtomicStampedReference。
2. 循环时间长开销大导致的性能问题，我们使用时大部分时间使用的是 while(true)方式对数据的修改，直到成功为止。
优势就是相应极快，但当线程数不停增加时，性能下降明显，因为每个线程都需要执行，占用CPU时间。

## 锁
### 可重入锁
```java
Sychronized
ReentrantLock
```
一个线程调用一个加锁的方法后,还可以调用其他加同一把锁的方法.
### 不可重入锁
一个线程获取到一把锁之后,该线程是无法调用其他加了该锁的方法.这种情况,容易造成死锁.
比如:方法一添加了不可重入锁,方法二添加了不可重入锁,并且调用了方法一.这种情况下,调用方法二就会出现死锁的情况.那么.重入锁就可以避免这种情况

## 代理
代理模式
### 静态代理
这种代理方式需要代理对象和目标对象实现一样的接口。

优点：可以在不修改目标对象的前提下扩展目标对象的功能

缺点：

冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。

### 动态代理
动态代理利用了JDK API，动态地在内存中构建代理对象，从而实现对目标对象的代理功能。动态代理又被称为JDK代理或接口代理。

静态代理与动态代理的区别主要在：

静态代理在编译时就已经实现，编译完成后代理类是一个实际的class文件
动态代理是在运行时动态生成的，即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中

特点：
动态代理对象不需要实现接口，但是要求目标对象必须实现接口，否则不能使用动态代理。

### cglib代理
cglib特点

JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
如果想代理没有实现接口的类，就可以使用CGLIB实现。
CGLIB是一个强大的高性能的代码生成包，它可以在运行期扩展Java类与实现Java接口。
它广泛的被许多AOP的框架使用，例如Spring AOP和dynaop，为他们提供方法的interception（拦截）。
CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。
不鼓励直接使用ASM，因为它需要你对JVM内部结构包括class文件的格式和指令集都很熟悉。
cglib与动态代理最大的区别就是

使用动态代理的对象必须实现一个或多个接口
使用cglib代理的对象则无需实现接口，达到代理类无侵入。

### 总结
静态代理实现较简单，只要代理对象对目标对象进行包装，即可实现增强功能，但静态代理只能为一个目标对象服务，如果目标对象过多，则会产生很多代理类。

JDK动态代理需要目标对象实现业务接口，代理类只需实现InvocationHandler接口。

动态代理生成的类为 lass com.sun.proxy.$Proxy4，cglib代理生成的类为class com.cglib.UserDao$$EnhancerByCGLIB$$552188b6。

静态代理在编译时产生class字节码文件，可以直接使用，效率高。

动态代理必须实现InvocationHandler接口，通过反射代理方法，比较消耗系统性能，但可以减少代理类的数量，使用更灵活。

cglib代理无需实现接口，通过生成类字节码实现代理，比反射稍快，不存在性能问题，但cglib会继承目标对象，需要重写方法，所以目标对象不能为final类。

## 数据结构
### 红黑树
![Java内存模型](./pictures/红黑树.jpg "红黑树")
#### 定义
特殊的二叉查找树
#### 特性
1. 每个节点都是黑色或者红色
2. 根节点是黑色
3. 每个叶节点都是黑色
4. 如果一个节点是红色，那么它的子节点必须为黑色
5. 从一个节点到该节点的子孙节点的所有路径包含相同数目的黑节点
#### 操作
添加、删除、旋转（左旋和右旋）：保证红黑树特性
#### 应用
红黑树的应用比较广泛，主要是用它来存储有序的数据，它的查找、插入和删除操作的时间复杂度是O(lgn)
