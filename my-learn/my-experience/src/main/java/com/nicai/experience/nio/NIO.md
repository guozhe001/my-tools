# NIO实践
## 怎么理解Buffer和Channel
***假设有两辆火车，其中一辆（A）装满了货物，另一辆（B）货车是空的，我们通过一个叉车把A上的货物卸下来装在B上；
Channel就是上例中的火车，其中A出货的使用调用read方法,B装货的时候调用write方法，Buffer就是上例中的叉车***
* Buffer
* Channel
* Selector 此概念建立在非阻塞的基础之上，大家经常听到的*多路复用* 在Java世界中指的就是它，用于实现一个线程管理多个 Channel

## Buffer类源码解读

```java
public abstract class Buffer {
  
    // Invariants: mark <= position <= limit <= capacity
    /*
     *  mark到底什么时候用呢？
     *  考虑以下场景，我们在 position 为 5 的时候，先 mark() 一下，然后继续往下读，读到第 10 的时候，
     *  我想重新回到 position 为 5 的地方重新来一遍，那只要调一下 reset() 方法，position 就回到 5 了。
     */
    private int mark = -1;
    /*
     * 写模式下：每次写入一个值，position就加1，代表下一次的写入位置
     * 读模式下：每读一个值，position就加1，代表下一次的读取位置
     */
    private int position = 0;
    /*
     * 写模式下：limit代表可以写的最大的位置
     * 读模式下：limit代表可以读的最大位置，因为不一定写满所以limit小于等于capacity
     */
    private int limit;
    // 缓冲区容量
    private int capacity;
    
    /**
    * 由写模式转换读模式
    */
    public final Buffer flip() {
        limit = position;
        position = 0;
        mark = -1;
        return this;
    }

    /**
    * 由读模式转换为写模式
    */
    public final Buffer clear() {
        position = 0;
        limit = capacity;
        mark = -1;
        return this;
    }
}
```