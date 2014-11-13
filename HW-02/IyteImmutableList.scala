sealed trait IyteImmutableList {
  def add(value: Int) = this match {
    case Nil => PreCons(value, Nil)
    case PreCons(_, _) => PreCons(value, this)
  }

  override def toString = this match {
    case Nil => ""
    case PreCons(h, Nil) => h.toString
    case PreCons(h, t) => h.toString + "," + t.toString
  }
}

// PreCons is a Cons that prepends instead of appending
case class PreCons(head: Int, tail: IyteImmutableList) extends IyteImmutableList
case object Nil extends IyteImmutableList

case object IyteImmutableList extends IyteImmutableList {

  def apply(values: Int*): IyteImmutableList = {
    if(values.isEmpty) Nil
    // else values.foldRight(Nil) ((value, node) => node.add(value))
    else PreCons(values.head, apply(values.tail: _*))
  }
}
