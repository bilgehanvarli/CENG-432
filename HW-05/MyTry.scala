import scala.Option

sealed trait MyTry[T] {
  def isFailure: Boolean = this match {
    case Failure(exc) => true
    case Success(_) => false
  }

  def isSuccess: Boolean = this match {
    case Failure(exc) => false
    case Success(_) => true
  }

  def get = this match {
    case Failure(exc) => throw exc
    case Success(x) => x
  }

  def getOrElse[TT >: T] (default: TT) = this match {
    case Failure(_) => default
    case Success(x) => x
  }

  def toOption = this match {
    case Failure(_) => None
    case Success(x) => Some(x)
  }
}

case class Success[T](result :T) extends MyTry[T]

case class Failure[T](exc: Exception) extends MyTry[T]

object MyTry {
  def apply[T](f: => T): MyTry[T] = {
    val attempt: MyTry[T] = try {
      Success(f)
    }
    catch {
      case e: Exception => Failure(e)
    }
    attempt
  }
}
