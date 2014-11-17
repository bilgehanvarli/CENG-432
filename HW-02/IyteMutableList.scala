import scala.collection.mutable.ArrayBuffer
import java.lang.StringBuilder

class IyteMutableList {
  var array = new ArrayBuffer[Int]()

  def add(x: Int): Unit = {
    array += x
  }

  override def toString = {
    if(array.size == 0) ""
    else {
      val strBuf = new StringBuilder(array(0).toString)
      for (i <- 1 until array.length) {
        strBuf.append("," +  array(i))
      }
      strBuf.toString
    }
  }
}

object IyteMutableList extends IyteMutableList{
  def apply = new IyteMutableList()
}

