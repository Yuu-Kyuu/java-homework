package com.java.homework.weekseven.controller.readwrite;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoutingDataSourceController {

    AbstractRoutingDataSource abstractRoutingDataSource;
}
