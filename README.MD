# Teads development test
## Problem
Let's consider a second-price, sealed-bid auction:

    An object is for sale with a reserve price.
    We have several potential buyers, each one being able to place one or more bids.
    The buyer winning the auction is the one with the highest bid above or equal to the reserve price.
    The winning price is the highest bid price from a non-winning buyer above the reserve price (or the reserve price if none applies)

## Example:
Consider 5 potential buyers (A, B, C, D, E) who compete to acquire an object with a reserve price set at 100 euros, bidding as follows:
 
    A: 2 bids of 110 and 130 euros
    B: 0 bid
    C: 1 bid of 125 euros
    D: 3 bids of 105, 115 and 90 euros
    E: 3 bids of 132, 135 and 140 euros
 
The buyer E wins the auction at the price of 130 euros.

## Goal 
The goal is to implement an algorithm to find the winner and the winning price. You can implement the solution in the language of your choice. Tests should be separated from your algorithm.
 
Be careful, the problem is non-deterministic on purpose. Be smart!

## Possible solution to the Test:
To solve the test, i have chosen to implement a _Vickrey_ auction algorithm.
A Vickrey auction is a type of sealed-bid auction. 
The highest bidder wins but the price paid is the second-highest bid.

https://en.wikipedia.org/wiki/Vickrey_auction

## Unit tests
There is a Unit test which tests some other examples in the folder:
 
 `src/test/kotlin/com/teads/auction/algorithm`

## Running the test
This project uses Gradle to build and launch the code.
To run the test and view their results, simply type the following command in your shell:

` ./gradlew test`