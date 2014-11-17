import scala.collection.mutable.ArrayBuffer

class IyteMutableList {
  var array = new ArrayBuffer[Int]()

  def add(x: Int): Unit = {
    array += x
  }

  override def toString = {
    var str = array.applyOrElse(0, {_: Int => ""}).toString
    // execute if size > 0
    for (i <- 1 until array.length) {
      str = str.concat("," +  array(i))
    }
    str
  }
}

object IyteMutableList extends IyteMutableList{
  def apply = new IyteMutableList()
}
