import java.lang.StringBuilder

class IyteMutableSet {
  var node: MutableBST = Nil

  def add(x: Int): Unit = {
    if (node == Nil) node = new Node(x, Nil, Nil)
    else node.add(x)
  }

  def contains(x: Int): Boolean = node.contains(x)

  override def toString = node.toString
}

sealed trait MutableBST {
  def add(x: Int): Unit = this match {
    case n @ Node(h, Nil, _) if(x < h) => n.left = new Node (x, Nil, Nil)
    case n @ Node(h, _, Nil) if(x > h) => n.right = new Node(x, Nil, Nil)
    case Node(h, l, r) =>
      if(x > h) r.add(x)
      else if (x < h) l.add(x)
      else Unit
  }

  def contains(x: Int): Boolean = this match {
    case Nil => false
    case Node(h,l,r) =>
      if(x > h) r.contains(x)
      else if (x < h) l.contains(x)
      else true
  }

  override def toString: String =  {
    val str = new StringBuilder
    var first = true
    def go(n: MutableBST): Unit = n match {
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

case class Node(var head: Int, var left: MutableBST, var right: MutableBST) extends MutableBST
case object Nil extends MutableBST

object IyteMutableSet {
  def apply() = new IyteMutableSet
}
