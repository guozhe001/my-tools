# 公平锁


```java
    /**
     * Sync object for fair locks
     */
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -3000897897090466540L;

        final void lock() {
            acquire(1);
        }

        /**
         * Fair version of tryAcquire.  Don't grant access unless
         * recursive call or no waiters or is first.
         */
        protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                /*
                hasQueuedPredecessors:
                 Queries whether any threads have been waiting to acquire longer than the current thread.
                 查询是否有比当前线程等待时间更长的其他线程
                 compareAndSetState：
                  Atomically sets synchronization state to the given updated
                      * value if the current state value equals the expected value.
                      * This operation has memory semantics of a {@code volatile} read
                      * and write.
                      
                  setExclusiveOwnerThread：
                  Sets the thread that currently owns exclusive access.
                  如果没有比当前线程等待时间更长的其他线程，并且当前线程设置状态成功
                  则当前线程获取锁成功，指定拥有权限的线程为当前线程
                */
                if (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
    }
```