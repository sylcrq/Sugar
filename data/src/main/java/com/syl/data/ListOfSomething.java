package com.syl.data;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Shen YunLong on 2016/07/27.
 */
public class ListOfSomething<T> implements ParameterizedType {

    private Class<?> wrapped;

    public ListOfSomething(Class<T> wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{wrapped};
    }

    @Override
    public Type getOwnerType() {
        return null;
    }

    @Override
    public Type getRawType() {
        return List.class;
    }
}
