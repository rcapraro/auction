package com.teads.auction.algorithm

import com.teads.auction.model.AuctionItem
import com.teads.auction.model.AuctionResult

/**
 * The interface for all Auction Algorithm.
 */
interface AuctionAlgorithm {
    /**
     * Determine the Result of the Auction Process.
     */
    fun determineWinners(item: AuctionItem): AuctionResult
}