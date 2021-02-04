# algorithm_practice
leetcode or something like that





## 常见api

### List

### Set

### Map

### String





待整理：

集合类的由来：
	对象用于封装特有数据，对象多了需要存储，如果对象的个数不确定。
	就使用集合容器进行存储。
	
集合特点：
1，用于存储对象的容器。存储的是对象的引用地址
2，集合的长度是可变的。
3，集合中不可以存储基本数据类型值。 但是jdk1.5后有自动封箱的特性，存储的还是对象

与数组区别：
1，数组长度固定，集合长度可变
2，数组中存储的是同一类型的元素，可以存储基本数据类型值
   集合存储的都是对象，而且对象的类型可以不一致

为了满足各种需求，数据结构（数据存储的方式）不同，产生多种具体集合容器。
不断的向上抽取，就形成了集合框架。

框架的顶层Collection接口：定义了集合体系中最共性的功能
看顶层，用底层

Collection的常见方法：

1，添加。
	boolean add(Object obj):
	boolean addAll(Collection coll):
	

2，删除。
	boolean remove(object obj):
	boolean removeAll(Collection coll);
	void clear();
	
3，判断：
	boolean contains(object obj):
	boolean containsAll(Colllection coll);
	boolean isEmpty():判断集合中是否有元素。 

4，获取：
	int size():
	Iterator iterator():取出元素的方式：迭代器。
	设计原理：因为每一个容器的数据结构都不同，取出是每种集合容器的特有功能，
			将共性的功能向上抽取为Iterator接口
	共性的取出方式：一个一个取，去之前先判断，有就取，没有就结束
	这就叫 迭代
	
	每一个具体容器内，都有迭代器对象（Iterator接口类型），Collection提供iterator方法去获取
	
	该对象必须依赖于具体容器，因为每一个容器的数据结构都不同。
	所以该迭代器对象是在容器中进行内部实现的。
	对于使用容器者而言，具体的实现不重要，只要通过容器获取到该实现的迭代器的对象即可，
	也就是iterator方法。
	
	Iterator接口就是对所有的Collection容器进行元素取出的公共接口。
	其实就是抓娃娃游戏机中的夹子！
	
	iterator方法取出的是迭代器对象（Iterator接口类型）
	迭代器调用的next()方法取出来的是容器中对象
	如果是Object或其他父类，需要使用元素特有方法时要向下转型


​	
5，其他：
​	boolean retainAll(Collection coll);取交集。
​	Object[] toArray():将集合转成数组。 
​	

-------------------------------
Collection
	|--List：有序(存入和取出的顺序一致),元素都有索引(角标)，元素可以重复。
	|--Set：元素不能重复,无序。


List:特有的常见方法：有一个共性特点就是都可以操作角标。
	
1，添加
	void add(index,element);
	void add(index,collection);


2，删除；
	Object remove(index):


3，修改：
	Object set(index,element);
	

4，获取：
	Object get(index);
	int indexOf(object);
	int lastIndexOf(object);
	List subList(from,to);
	
	
list集合是可以完成对元素的增删改查。

List:
	|--Vector:内部是数组数据结构，是同步的。增删，查询都很慢！
	|--ArrayList:内部是数组数据结构，是不同步的。替代了Vector。查询的速度快。
	|--LinkedList:内部是链表数据结构，是不同步的。增删元素的速度很快。
	

集合类的由来：
	对象用于封装特有数据，对象多了需要存储，如果对象的个数不确定。
	就使用集合容器进行存储。
	
集合特点：
1，用于存储对象的容器。
2，集合的长度是可变的。
3，集合中不可以存储基本数据类型值。 



集合容器因为内部的数据结构不同，有多种具体容器。
不断的向上抽取，就形成了集合框架。

框架的顶层Collection接口：

Collection的常见方法：

1，添加。
	boolean add(Object obj):
	boolean addAll(Collection coll):
	

2，删除。
	boolean remove(object obj):
	boolean removeAll(Collection coll);
	void clear();
	
3，判断：
	boolean contains(object obj):
	boolean containsAll(Colllection coll);
	boolean isEmpty():判断集合中是否有元素。 

4，获取：
	int size():
	Iterator iterator():取出元素的方式：迭代器。
	该对象必须依赖于具体容器，因为每一个容器的数据结构都不同。
	所以该迭代器对象是在容器中进行内部实现的。
	对于使用容器者而言，具体的实现不重要，只要通过容器获取到该实现的迭代器的对象即可，
	也就是iterator方法。
	
	Iterator接口就是对所有的Collection容器进行元素取出的公共接口。
	其实就是抓娃娃游戏机中的夹子！


​	
5，其他：
​	boolean retainAll(Collection coll);取交集。
​	Object[] toArray():将集合转成数组。 
​	

-------------------------------
Collection
	|--List：有序(存入和取出的顺序一致),元素都有索引(角标)，元素可以重复。
	|--Set：元素不能重复,无序。


List:特有的常见方法：有一个共性特点就是都可以操作角标。
	
1，添加
	void add(index,element);
	void add(index,collection);


2，删除；
	Object remove(index):


3，修改：
	Object set(index,element);
	

4，获取：
获取元素方法有2种，
一种是迭代(得到的是Object，需要向下转型)，
一种是遍历+get(得到的是add的对象类型)
	Object get(index);
获取角标：
	int indexOf(object);
	int lastIndexOf(object);
获取子列表：
	List subList(from,to);
	
	
list集合是可以完成对元素的增删改查。

在迭代过程中不能使用集合的方法对元素进行操作，会导致java.util.ConcurrentModificationException异常
因为使用集合方法操作，迭代器不知道集合中数据的变化，会导致数据的不确定性
所以要使用迭代器的方法，但是迭代器没有添加或修改的方法，有next()和remove()
----->迭代器的子接口ListInterator
如何获取子接口ListInterator对象呢？
通过List接口中的listIterator()就可以
**列表迭代器只有List接口有，而且可以增删改查



List:
	|--Vector:内部是数组数据结构，是同步的。增删，查询都很慢！
	|--ArrayList:内部是数组数据结构，是不同步的。替代了Vector。查询的速度快。
	|--LinkedList:内部是链表数据结构，是不同步的。增删元素的速度很快。
	
	
LinkedList:

	addFirst();
	addLast():
	jdk1.6
	offerFirst();
	offetLast();


​	
​	getFirst();.//获取但不移除，如果链表为空，抛出NoSuchElementException.
​	getLast();
​	jdk1.6
​	peekFirst();//获取但不移除，如果链表为空，返回null.
​	peekLast():
​	
	removeFirst();//获取并移除，如果链表为空，抛出NoSuchElementException.
	removeLast();
	jdk1.6
	pollFirst();//获取并移除，如果链表为空，返回null.
	pollLast();

List集合如何去除重复元素？
思路：
1， 创建临时容器，用于存储唯一性的元素
2， 遍历原容器，将遍历到的元素与临时容器中去判断是否存在
3， 如果存在，不存储到临时容器中；不存在就存
4， 遍历结束后，临时容器中存储的就是唯一性的元素
5， 如果需要将这些唯一性的元素保留到原容器中，只要将原容器清空，然后将
	临时容器中的元素加到原容器中

如果集合里面存的是对象，contains源码里面用的是equals，object中的equals是判断地址
所以需要重写被判断对象的equals，让其判断内容

以上虽然能达到目的，但是太麻烦，所以Set接口可以deduplicate

---------------------------------------------

Set:元素不可以重复，是无序。
	Set接口中的方法和Collection一致。
	|--HashSet: 内部数据结构是哈希表 ，是不同步的。查询速度快，不保证顺序
		哈希表
		数组中存储的都是元素，角标是通过哈希函数得到的
		查询速度比数组快，但是重复元素存不进去
		
		哈希冲突
		元素的哈希值（hashCode()）一致，会再次判断元素内容是否相同（equals）
		equals返回true，元素相同，不存
		equals返回false，元素不同，存储，继续通过算法算出位置
		
		如何保证该集合的元素唯一性呢？
		是通过对象的hashCode和equals方法来完成对象唯一性的。
		如果对象的hashCode值不同，那么不用判断equals方法，就直接存储到哈希表中。 
		如果对象的hashCode值相同，那么要再次判断对象的equals方法是否为true。
		如果为true，视为相同元素，不存。如果为false，那么视为不同元素，就进行存储。
		 
		记住：如果元素要存储到HashSet集合中， 必须覆盖hashCode方法和equals方法。
		一般情况下，如果定义的类会产生很多对象，比如人，学生，书，通常都需要覆盖equals，hashCode方法。
		建立对象判断是否相同的依据。
		
		如果既想要HashSet的快速查询，又想要按照存储的顺序取出，而非无序，
		就要用到HashSet的子类LinkedHashSet
		
		集合遍历不好写，所以为了简化语句，Collection继承了Iterable, 
		里面有iterator方法，提供了foreach方式，让之后继承的子类也都有这个方法
		for(数据类型 变量 ： 集合或者数组)用于遍历集合和数组，通常只能遍历元素，无法过多操作
		for(Object obj : list){}
		foreach必须有被遍历的目标，只能是集合或者数组，无法通过角标操作


​		
​		
​		
​		
​	|--TreeSet:可以对Set集合中的元素进行排序。是不同步的。 
​				
				TreeSet的add方法内部最终实现：
				需要将元素转成Comparable类型，因为这个类型具有排序的能力
				Comparable类型专门为排序提供了compareTo方法
				如果要让传入的对象具备比较排序的功能，就要让对象扩展功能，实现Comparable接口
				
				内部数据是二叉树方式存储，比较方式是二分比较
				判断元素唯一性的方式：
				就是根据比较方法的返回结果是否是0，是0，就是相同元素，不存。 
				
				TreeSet对元素进行排序的方式一：
				元素自身具备自然排序（已经实现Comparable接口）或者让元素自身具备比较功能，
				其实就是实现Comparable接口。覆盖compareTo方法。
				
			  	如果不想按照对象中具备的自然顺序进行排序。或者对象中不具备自然顺序。怎么办？
			  	可以用方式一，也可以使用TreeSet集合第二种排序方式二：比较器
				就是在创建TreeSet集合时，在构造函数中制定具体的比较方式
				让集合自身具备比较功能，定义一个类实现Comparator接口，覆盖compare方法。
				将该类对象作为参数传递给TreeSet集合的构造函数。


​				

在往集合中存储对象时，通常该对象都需覆盖hashCode, equals
同时实现comparable接口，建立对象的自然排序，通常也会复写toString()

if(this.hashCode()== obj.hashCode() && this.equals(obj))



哈希表确定元素是否相同
1，判断的是两个元素的哈希值是否相同。
	如果相同，在判断两个对象的内容是否相同。

2，判断哈希值相同，其实判断的是对象的hashCode的方法。判断内容相同，用的是equals方法。

注意：如果哈希值不同，是不需要判断equals。

集合的一些技巧：

需要唯一吗？
需要：Set
	需要制定顺序： 
			需要： TreeSet
			不需要：HashSet
			但是想要一个和存储一致的顺序(有序):LinkedHashSet
不需要：List
	需要频繁增删吗？
		需要：LinkedList
		不需要：ArrayList
		
如何记录每一个容器的结构和所属体系呢？

看名字！


List
	|--ArrayList
	|--LinkedList

Set
	|--HashSet
	|--TreeSet

后缀名就是该集合所属的体系。

前缀名就是该集合的数据结构。

看到array：就要想到数组，就要想到查询快，有角标.	
看到link：就要想到链表，就要想到增删快，就要想要 add get remove+frist last的方法 
看到hash:就要想到哈希表，就要想到唯一性，就要想到元素需要覆盖hashcode方法和equals方法。查询速度更快 
看到tree：就要想到二叉树，就要想到可以排序且唯一，就要想到两个接口Comparable覆盖compareTo，Comparator覆盖compare方法 。

而且通常这些常用的集合容器都是不同步的。 


============================================


Map：一次添加一对元素。Collection 一次添加一个元素。
	Map也称为双列集合，Collection集合称为单列集合。
	其实map集合中存储的就是键值对。 
	map集合中必须保证键的唯一性。 
	
	
常用方法：
1，添加。
	value put(key,value):返回前一个和key关联的值，如果没有返回null.

2，删除。
	void  clear():清空map集合。
	value remove(key):根据指定的key翻出这个键值对。 

3，判断。
	boolean containsKey(key):
	boolean containsValue(value):
	boolean isEmpty();

4，获取。 
	value get(key):通过键获取值，如果没有该键返回null。
					当然可以通过返回null，来判断是否包含指定键。 
	int size(): 获取键值对的个数。 
	
						
	
Map常用的子类：
	|--Hashtable :内部结构是哈希表，是同步的。不允许null作为键，null作为值。
		|--Properties：用来存储键值对型的配置文件的信息，可以和IO技术相结合。 		
	|--HashMap : 内部结构是哈希表，不是同步的。允许null作为键，null作为值。
	|--TreeMap : 内部结构是二叉树，不是同步的。可以对Map集合中的键进行排序。 

工具类

----Collections：集合框架中用于操作集合对象的工具类，都是静态的工具方法
				求最值，排序，二分查找，逆序，同步集合方法

----Arrays:集合框架中用于操作数组的工具类，都是静态的工具方法
			详见ArraysDemo.java
			**排序，二分查找，数组复制，元素比较，数组转为字符串
Arrays.asList(数组)  将数组转成集合，集合对单个元素的操作更丰富
			好处：其实可以使用集合的方法操作数组中的元素。
		 	注意：数组的长度是固定的，所以对于集合的增删方法是不可以使用的
		 	否则会发生UnsupportedOperationException

集合转成数组呢？
		 * 详见ToArray.java
		 * 使用的就是Collection接口中的toArray方法。
		 * 
		 * 集合转成数组：可以对集合中的元素操作的方法进行限定。不允许对其进行增删。

============================================
Collection集合一次只能存储一个元素，想存有映射关系的一对元素，咋办？
集合框架中还有Map<K,V>集合

Map：一次添加一对元素。Collection 一次添加一个元素。
	Map也称为双列集合，Collection集合称为单列集合。
	其实map集合中存储的就是键值对。（key value） 
	map集合中必须保证键的唯一性，但是不保证值的唯一性，不能通过值获取键
	详见MapDemo.java
	
常用方法：
1，添加。
	value put(key,value):返回前一个和key关联的值，如果没有返回null.
						存储的是夫妻，put返回前妻

2，删除。
	void  clear():清空map集合。
	value remove(key):根据指定的key翻出这个键值对。 

3，判断。
	boolean containsKey(key):
	boolean containsValue(value):
	boolean isEmpty();

4，获取。 没有迭代器
	value get(key):通过键获取值，如果没有该键返回null。
					当然可以通过返回null，来判断是否包含指定键。 
	int size(): 获取键值对的个数。 
	
	
/*
 * map集合没有迭代器
 * 取出元素的方式：将map转成单列集合，在使用单列集合的迭代器就可以了
 * map集合也不能直接用foreach循环遍历
 *
****************************
 * 如何取出map中的所有元素？
 * 原理，先取出所有的键，返回的是一个单列集合，因为键唯一，所以得是Set
 * 可以通过keySet方法获取map中所有的键所在的Set集合
 * 在通过Set的迭代器获取到每一个键
 * 在对每一个键通过map集合的get方法获取其对应的值即可
****************************
 * 另一个方法。entrySet。
 * 该方法将键和值的映射关系作为对象存储到了Set集合中，
 * 而这个映射关系的类型就是Map.Entry类型(结婚证)
 * 在通过Set的迭代器获取到每一个映射关系
 * 在通过Map.Entry的getKey()和getValue()方法分别获取其对应的键和值即可
 *
 * 详见MapDemo.java
 */					
	

Map常用的子类：
	|--Hashtable :数据结构是哈希表，是同步的。不允许null作为键，不允许null作为值。
		|--Properties：属性集，键和值都是字符串，而且可以结合流进行键值的操作
		用来存储键值对型的配置文件的信息，可以和IO技术相结合。 		
	|--HashMap : 数据结构是哈希表，不是同步的。允许null作为键，也允许null作为值。不保证顺序
				如果想变成同步的，可以用Collections.synchronizedMap()
		｜--LinkedHashMap:数据结构是基于链表+哈希表，可以保证map集合有序（存入和取出的顺序一致）		
	|--TreeMap : 内部结构是二叉树，不是同步的。可以对Map集合中的键进行排序。 
	
什么时候使用map呢？
分析问题时出现对应关系，应该立即想到map
如果对应关系中出现了有序的数字，想到数组
注意：如果对应关系个数不确定，还是以map为主

...用在参数上，称为函数的可变参数。
静态导入 import static 类中静态成员全名
导入指定的类中的静态成员，可以简化书写

system

List list = new ArrayList();//非同步的。

list = MyCollections.synList(list);//返回一个同步的list.

给非同步的集合加锁。

class MyCollections{

	public static  List synList(List list){
		
		return new MyList(list);
	}
	
	private class MyList implements List{
	private List list;
	
	private static final Object lock = new Object();
	MyList(List list){	
		this.list = list;	
	}
	
	public boolean add(Object obj){
		synchronized(lock)
		{
			return list.add(obj);
		}
	}
	
	public boolean remove(Object obj){
		synchronized(lock)
		{
			return list.remove(obj);
		}
	}

}
}







![image-20210203223134802](/Users/s/Library/Application%20Support/typora-user-images/image-20210203223134802.png)

