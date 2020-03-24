package com.aistar.service;

import java.util.List;

public interface BaseService<T> {
    public boolean add(T t);
    public boolean modify(T t);
    public boolean delete(Integer id);
    public T getById(Integer id);
    public List<T> getAll();

}
