object Main extends App {
  val arr = Array(10,25,30)

  arr.foreach(x => {
   if(x % 2 == 0) println(x * 2)
   else println(x * 3)
  })
}
