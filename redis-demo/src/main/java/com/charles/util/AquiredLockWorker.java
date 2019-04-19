package com.charles.util;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 获取锁后需要处理的逻辑
 * @author: GanZiB
 * Date: 2019-04-18
 * Time: 14:03
 */
public interface AquiredLockWorker<T> {
    T invokeAfterLockAquire() throws Exception;
}
