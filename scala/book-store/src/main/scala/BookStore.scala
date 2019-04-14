import scala.annotation.tailrec

object BookStore {
  private val bookPrice: Int = 800
  private val discounts: Map[Int, Double] = Map(1 -> 1, 2 -> 0.95, 3 -> 0.9, 4 -> 0.8, 5 -> 0.75)

  @tailrec
  private def build(book: Int, l: List[Int], resIdx: Int, res: List[List[Int]], strat: Boolean): List[List[Int]] = {
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

  @tailrec
  private def equalizeGroups(list: List[Int], take: Int, res: List[List[Int]]): List[List[Int]] = {
    if (list.isEmpty) res
    else equalizeGroups(list.slice(take, list.size), take, res ++ List(list.slice(0, take)))
  }

  def total(books: List[Int]): Int = {

    if (books.isEmpty) 0
    else {
      val strategy = books.count(f => books.indexOf(f) == books.lastIndexOf(f)) % 2 == 0 && books.size % 2 == 0
      val groups = build(books.head, books.tail ++ List(0), 0, List(List()), strategy)
      val group2 = build(books.head, books.tail ++ List(0), 0, List(List()), !strategy)
      val f = groups.flatten
      val b = {
        if (f.size % 4 == 0) equalizeGroups(f, f.size / 4, List())
        else List()
      }
      val cost = groups.map(x => x.size * bookPrice  * discounts(x.size)).sum
      val cost2 = group2.map(x => x.size * bookPrice * discounts(x.size)).sum
      val cost3 = b.map(x => x.size * bookPrice * discounts(x.size)).sum
      val fin = List(cost, cost2, cost3)
      val k = fin.filter(!_.equals(0.0)).sortWith(_ > _)
      k.last.toInt
    }
  }
}
