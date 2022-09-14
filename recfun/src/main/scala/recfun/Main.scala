package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if (c == 0 || r == c) 1
    else pascal(c-1,r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def scanChar(char: Char): Int = 
      if(char == '(') 1
      else if(char == ')') -1
      else 0
    
    def count(x: Int, str: List[Char]): Boolean = 
      if(x < 0) false
      else if(str.isEmpty) x == 0
      else count(x + scanChar(str.head), str.tail)

    count(0, chars)
  }
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def change(money: Int, coins: List[Int]): Int =
      if(money < 0 || coins.isEmpty) 0
      else if(money == 0) 1
      else change(money - coins.head, coins) + change(money, coins.tail)

    change(money, coins) 
  }
}
