package com.teads.auction.exception

/**
 * Exception thrown if the are issues during the Auction process (ie: No Bids)
 */
class AuctionException(override val message: String) : RuntimeException(message)