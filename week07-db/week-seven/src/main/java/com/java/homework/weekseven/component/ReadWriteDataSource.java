package com.java.homework.weekseven.component;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author qiucihang
 */

public class ReadWriteDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
