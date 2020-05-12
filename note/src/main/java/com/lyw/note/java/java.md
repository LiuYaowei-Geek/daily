# JAVA
1. new出来的对象，基本类型为初始值，String类型为"null"，Object为null
2. 接口调用时，使用BeanCopy，在对象类型不同时，不能copy
3. spring的BeanUtils.copyProperties()在对象类型不同时，会复制为键值对HashMap
4. list遍历删除时，使用迭代器进行删除
5. 一字节等于8位
6. 8种基本类型长度：byte = 1字节（8位）, shor = 2byte, char = 2byte, int = 4byte, float = 4byte, long = 8byte, double = 8byte, boolean = 1bit

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

### HashMap
1. 位置要么在原位置，要么在增加2次幂的位置
2. HashMap中，如果key经过hash算法得出的数组索引位置全部不相同，即Hash算法非常好，那样的话，getKey方法的时间复杂度就是O(1)，
如果Hash算法技术的结果碰撞非常多，假如Hash算极其差，所有的Hash算法结果得出的索引位置一样，那样所有的键值对都集中到一个桶中，或者在一个链表中，或者在一个红黑树中，时间复杂度分别为O(n)和O(lgn)。
3. 初始大小16。扩容每次变大2倍。大于等于8时，从8位置开始转为红黑树