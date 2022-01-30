package com.epam.rd.autotasks;

import java.util.Arrays;

public class HalvingCarousel extends DecrementingCarousel {
    protected int[] arr;
    protected int capacity;
    private int i = 0;
    private boolean runHav = false;

    public HalvingCarousel(final int capacity) {
        super(capacity);
        HalvingCarousel.this.arr = new int[capacity];
    }

    @Override
    public int next() {
        if (arr.length == 0 || Arrays.stream(arr).sum() == 0)
            return -1;

        if (i >= capacity)
            while (arr[i] == 0) {
                i++;
                if (i > arr.length - 1)
                    i = 0;
            }

        if (arr[i] > 0)
            return arr[i++] / 2;

        return 0;
    }

    @Override
    public HalvingCarousel run() {

        if (!runHav) {
            runHav = true;
            return this;
        } else
            return null;
    }
}
