package com.intern.edamammvvm.base;

public abstract class BaseDataSourceImpl<I extends BaseDataSource,O extends BaseDataSourceImpl>{
    private static BaseDataSourceImpl repository;
    private I dataSource;
}
