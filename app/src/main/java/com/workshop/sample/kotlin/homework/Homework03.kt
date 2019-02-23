package com.workshop.sample.kotlin.homework

fun getCityThatMostCustomersAreFrom(shop: Shop): City? {
    val cityCustomerMap: MutableMap<City, Int> = mutableMapOf()

    shop.customers.forEach { c ->
        if (cityCustomerMap.containsKey(c.city)) {
            cityCustomerMap.put(c.city, cityCustomerMap.getValue(c.city) + 1)
        } else {
            cityCustomerMap.put(c.city, 1)
        }
    }

    var result: City = cityCustomerMap.keys.iterator().next();
    var count: Int = 0;
    for (city in cityCustomerMap.keys.iterator()) {
        if (cityCustomerMap.getValue(city) > count) {
            result = city;
            count = cityCustomerMap.getValue(city)
        }
    }
    return result
}

fun getCustomerWithMaximumNumberOfOrders(shop: Shop): Customer? {
    var result: Customer = shop.customers[0];
    var count: Int = 0;
    shop.customers.forEach { c ->
        if (c.orders.size > count) {
            result = c
            count = c.orders.size
        }
    }
    return result
}
