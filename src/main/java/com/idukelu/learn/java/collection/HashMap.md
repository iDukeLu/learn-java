## HashMap 简介
HashMap 基于 Map 实现，提供所有关于 Map 的操作且允许空键和空值
HashMap 和 HashTable 区别：非同步、允许空键和空值
不保证顺序，随着时间推进会更不保证顺序

put/get 提供常量级的性能
迭代性能与容量capacity、大小size成正比，不要设置初始容量过高或负载因子过低

影响 HashMap 性能的两个因素：初始容量、负载因子
容量（capacity）：hash 表中桶的数量
初始容量（initial capacity）：hash 表初始时的容量
负载因子（load factor）：hash 表自动扩容的度量
当 entry 的数量超过阈值（容量*负载因子），哈希表将会 rehash 来进行扩容（扩容后，哈希表的内部数据结构将会改变）

默认的负载因子 0.75，很好的平衡了空间和时间的转换
较高的值：会减少空间开销，但会增加查找成本
初始容量太小会导致频繁的 rehash 扩容

请注意，使用具有相同hashCode()的许多键是降低任何哈希表性能的肯定方法

请注意，HashMap 是非同步的，任何修改 HashMap 结构的多线程操作，必须在外部同步
HashMap 的结构被修改是指：一个或多个元素被删除或添加，不包括已有键的值修改
Map m = Collections.synchronizedMap(new HashMap(...));
返回一个 Collections 维护的一个内部类：SynchronizedMap

HashMap 的所有“集合视图方法”返回的迭代器都是快速失败的：如果在创建迭代器后的任何时间对结构进行结构修改，则除了通过迭代器自己的remove方法之外，该迭代器都将抛出ConcurrentModificationException 。 
因此，面对并发修改，迭代器会快速干净地失败，而不会在未来的不确定时间内冒任意，不确定的行为的风险。

注意，迭代器的快速失败行为无法得到保证，因为通常来说，在存在不同步的并发修改的情况下，不可能做出任何严格的保证。 
快速失败的迭代器会尽最大努力抛出ConcurrentModificationException。 
因此，编写依赖于此异常的程序的正确性是错误的：迭代器的快速失败行为仅应用于检测错误。

## HashTable 简介

## HashMap 和 HashTab 的区别