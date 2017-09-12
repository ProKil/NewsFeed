package com.java.xxii.filter;

import java.util.List;

/**
 * Created by Hao on 09/09/2017.
 */

public interface BaseFilter<T> {
    public List<T> filterFrom(List<T> original);
}
