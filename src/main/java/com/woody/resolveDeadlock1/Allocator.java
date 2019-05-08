package com.woody.resolveDeadlock1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudih
 * @date 2019/5/8 16:25
 * @since 1.0.0
 */
public class Allocator {
    final List<Object> hold = new ArrayList<>();

    public boolean apply(Object from, Object to) {
        synchronized (this) {
            if (hold.contains(from) && hold.contains(to)) {
                return false;
            }
            hold.add(from);
            hold.add(to);
            return true;
        }
    }

    public void free(Object from, Object to) {
        synchronized (this) {
            hold.remove(from);
            hold.remove(to);
        }
    }
}
