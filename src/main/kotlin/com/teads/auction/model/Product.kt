package com.teads.auction.model

/**
 * The product to sell at the Auction.
 * The product has a price under which the auction shall not be validated (eg: the reserve price).
 *
 * @property name the name of the product
 * @property reservePrice the reserve price of the product in this auction
 */
data class Product(val name: String, val reservePrice: Int)