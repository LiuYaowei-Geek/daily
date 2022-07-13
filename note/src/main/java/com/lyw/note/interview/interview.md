#Java集合
1. hashMap的key和value可以为空，但是ConCurrentHashMap的key和value不能为空
```text
1.源码层面，hashMap的key为null时返回哈希值为0，ConCurrentHashMap会抛异常NPE
2.在HashMap之中，我们可以很容易的通过contains方法来判断key或者value为null是否真的存在。
但是这个问题要是出现在ConurrentMaps中了，那么就可能会有问题了。
试想一下，当我们首先从map中get某个key，由于map中这个key不存在，那么会返回null，这之后我们通过contains进行判断，此时如果有线程并发写入了一条value为null的值，那么contains的结果就为true。这样就会与真实的情况不一致了，这就是二义性。
因此我们也需要注意Doug 的观点：不管容器是否考虑了线程安全问题，都不应该允许null值的出现。他觉得在现有的某些集合里面允许了null值的出现，是集合的设计问题。
ref: https://cloud.tencent.com/developer/article/1690271
```