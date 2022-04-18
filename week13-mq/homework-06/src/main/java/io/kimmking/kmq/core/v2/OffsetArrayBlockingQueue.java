package io.kimmking.kmq.core.v2;

import java.util.concurrent.ArrayBlockingQueue;

public class OffsetArrayBlockingQueue<E> extends ArrayBlockingQueue<E> {

    public OffsetArrayBlockingQueue(int capacity) {
        super(capacity);
    }



}
