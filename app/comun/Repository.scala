package comun

import scala.concurrent.Future


trait Repository[A] {



  def crate (value: A): Future[Int]
  def find (): Future[Seq[A]]

}
