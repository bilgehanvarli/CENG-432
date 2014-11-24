import java.lang.StringBuilder

sealed trait IyteImmutableSet {
  def add(x: Int): IyteImmutableSet = this match {
    case Nil => new Node(x, Nil, Nil)
    case Node(head, left, right) =>
      if(x < head) new Node(head, left.add(x), right)
      else if (x > head) new Node(head, left, right.add(x))
      else this
  }

  def contains(x: Int): Boolean = this match {
    case Nil => false
    case Node(head, left, right) => {
      if(head == x) true
      else if (x > head) right.contains(x)
      else left.contains(x)
    }
  }

  override def toString: String =  {
    val str = new StringBuilder
    var first = true
    def go(n: IyteImmutableSet): Unit = n match {
      case Nil => return Unit
      case Node(h,l,r) =>
        go(l)
        if(first) first = false else str append ","
        str.append(h)
        go(r)
    }
    go(this)
    str.toString
  }
}

case class Node(head: Int, left: IyteImmutableSet, right: IyteImmutableSet) extends IyteImmutableSet
case object Nil extends IyteImmutableSet

object IyteImmutableSet {
  def apply() = Nil
}
