package com.andy.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Description: 实现 LinkedHashMap 的 LRU 算法 </p>
 * <p>@Author wuqiong  2020/12/17 </p>
 */
public class CacheLRU<K,V>  extends LinkedHashMap<K,V> implements Map<K,V> {
    private static final int MAX_ENTRIES = 5;

    /**
     * Constructs an empty <tt>LinkedHashMap</tt> instance with the
     * specified initial capacity, load factor and ordering mode.
     *
     * @param  initialCapacity the initial capacity
     * @param  loadFactor      the load factor
     * @param  accessOrder     the ordering mode - <tt>true</tt> for
     *         access-order, <tt>false</tt> for insertion-order
     * @throws IllegalArgumentException if the initial capacity is negative
     *         or the load factor is nonpositive
     */
    public CacheLRU(int initialCapacity, float loadFactor,boolean accessOrder) {
        super(initialCapacity, loadFactor,accessOrder);
    }

    /**
     *
     * @param eldest The least recently inserted entry in the map, or if
     *               this is an access-ordered map, the least recently accessed
     *               entry.  This is the entry that will be removed it this
     *               method returns <tt>true</tt>.  If the map was empty prior
     *               to the <tt>put</tt> or <tt>putAll</tt> invocation resulting
     *               in this invocation, this will be the entry that was just
     *               inserted; in other words, if the map contains a single
     *               entry, the eldest entry is also the newest.
     * @return <tt>true</tt> if the eldest entry should be removed
     * from the map; <tt>false</tt> if it should be retained.
     */
    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }
}
