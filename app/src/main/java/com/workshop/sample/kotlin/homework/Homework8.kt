package com.workshop.sample.kotlin.homework


fun getCitiesOfOrders(shop: Shop): List<City> {
    val result: MutableList<City> = mutableListOf()
    shop.customers.filter { c -> c.orders.size > 0 }.forEach { c -> result.add(c.city) }
    return result
}

fun customerCount(shop: Shop, city: City): Int? {
    return shop.customers.filter { c -> c.city.equals(city) }.count()
}

fun descendingCustomer(shop: Shop): List<Customer> {
    return shop.customers.sortedByDescending { c -> c.orders.count() }
}

fun getProductsOfCustomer(shop: Shop, customer: Customer): List<Product> {
    val result: MutableList<Product> = mutableListOf()
    shop.customers.filter { c -> c.equals(customer) }
        .forEach { c -> c.orders.forEach { o -> result.addAll(o.products) } }
    return result
}

fun orderedProducts(shop: Shop): Set<Product> {
    val result: MutableSet<Product> = mutableSetOf()
    shop.customers.forEach { c -> c.orders.forEach { o -> result.addAll(o.products) } }
    return result
}
