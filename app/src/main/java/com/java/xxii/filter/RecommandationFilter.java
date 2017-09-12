package com.java.xxii.filter;

import java.util.List;

/**
 * Created by Hao on 09/09/2017.
 */

public class RecommandationFilter implements BaseFilter {
    @Override
    public List filterFrom(List original) {
        return original;
    }
}
