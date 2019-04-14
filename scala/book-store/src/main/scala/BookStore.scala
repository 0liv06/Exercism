import scala.annotation.tailrec

object BookStore {
  val bookPrice: Int = 800
  val discounts: Map[Int, Double] = Map(1 -> 0, 2 -> 0.05, 3 -> 0.1, 4 -> 0.2, 5 -> 0.25)

  def total(books: List[Int]): Int = {

    if (books.isEmpty) 0
    else {
      @tailrec
      def build(book: Int, l: List[Int], resIdx: Int, res: List[List[Int]], strat: Boolean): List[List[Int]] = {
        if (l.isEmpty) res
        else if (res.size <= resIdx) build(l.head, l.tail, resIdx, res ++ List(List(book)), strat)
        else if (res(resIdx).contains(book)) build(book, l, resIdx + 1, res, strat)
        else {
          val v: List[Int] = res(resIdx) ++ List(book)
          val vv: List[List[Int]] = res.take(resIdx) ++ res.drop(resIdx + 1)
          val vvv: List[List[Int]] =  {
            if (!strat) vv ++ List(v)
            else List(v) ++ vv
          }
          build(l.head, l.tail, 0, vvv, strat)
        }
      }

      val strategy = books.count(f => books.indexOf(f) == books.lastIndexOf(f)) % 2 == 0 && books.size % 2 == 0
      val groups = build(books.head, books.tail ++ List(0), 0, List(List()), strategy)
      val group2 = build(books.head, books.tail ++ List(0), 0, List(List()), !strategy)
      val cost = groups.map(x => x.size * bookPrice - ((bookPrice * x.size) * discounts(x.size)))
      val cost2 = group2.map(x => x.size * bookPrice - ((bookPrice * x.size) * discounts(x.size)))

      if (cost.sum.toInt < cost2.sum.toInt) cost.sum.toInt
      else cost2.sum.toInt
    }
  }
}
