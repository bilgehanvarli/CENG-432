object ImmutableTest extends App {
  val mySet : IyteImmutableSet = IyteImmutableSet();
  println(mySet.add(1).add(5).add(10).add(7))
}
