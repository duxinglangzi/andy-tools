# Java 1.5 开始提供了java.util.concurrent.atomic 包
>这个包中的原子操作类提供了一种用法简单、性能高效、线程安全的更新一个变量的方式。
>因为变量的类型有很多种，所以在 atomic包内提供了 13个类，属于4种类型的原子更新方式。
>分别是: 更新基本类型、更新数组、更新引用、更新属性(字段)

>> 原子更新基本类型
>>> AtomicInteger 原子更新整型

>>> AtomicLong    原子更新长整型

>>> AtomicBoolean 原子更新布尔类型 

>> 原子更新数组
>>> AtomicIntegerArray 原子更新整型数组

>>> AtomicLongArray    原子更新长整型数组

>>> AtomicReferenceArray 原子更新引用类型数组里元素

>> 原子更新引用类型
>>> AtomicReference 原子更新引用类型

>>> AtomicReferenceFieldUpdater 原子更新引用类型里的字段

>>> AtomicMarkableReference 原子更新带有标记的引用类型，可以原子更新一个布尔类型的标记位和引用类型


>> 原子更新字段(属性)
>>> AtomicIntegerFieldUpdater 原子更新整型字段的更新器

>>> AtomicLongFieldUpdater      原子更新长整型字段的更新器

>>> AtomicStampedReference   原子更新带有版本号的引用类型，该类将整数值与引用关联起来，
                            可用于原子的更新数据和数据的版本号，可以解决使用CAS进行原子更新时可能出现的ABA问题。





