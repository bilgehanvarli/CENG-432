import scala.Option

sealed trait RandomStuffTrait {
  def transform(list: List[Int], op: (Int) => Int) : List[Int]
  def allValid(list: List[Int], op: (Int) => Boolean) : Boolean
  def executeWithRetry(retryCount: Int, op: => Int) : Option[Int]
}

object RandomStuff extends RandomStuffTrait {
  def transform(list: List[Int], op: (Int) => Int): List[Int] = {
    var newList = List[Int]()
    list.foreach(x => newList = newList :+ op(x))
    newList
  }

  def allValid(list: List[Int], op: (Int) => Boolean): Boolean = {
    for(element <- list; if(!op(element))) { return false }
    true
  }

  def executeWithRetry(retryCount: Int, op: => Int): Option[Int] = {
    var result = MyTry(op).toOption
    for(i <- 0 to retryCount) {
      if(result.isEmpty) result = MyTry(op).toOption
      else return result
    }
    result
  }
}
