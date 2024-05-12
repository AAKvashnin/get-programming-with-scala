package org.example.registrations

import io.getquill.{PostgresJAsyncContext, SnakeCase}
import scala.concurrent.{ExecutionContext, Future}

case class Customer(id:Int, name:String)
class CustomerQueries(ctx: PostgresJAsyncContext[SnakeCase.type]) {

  import ctx._

  private val customers = quote { query[Customer] }

  def all()(implicit ec:ExecutionContext):Future[Seq[Customer]] = {
    run(customers)
  }

  def nameById(id:Int)(implicit ec:ExecutionContext):Future[Seq[String]] = {
    val q = quote {
      customers.filter(_.id == lift(id)).map(_.name)
    }
    run(q)
  }

  def save(customer:Customer)(implicit ec:ExecutionContext):Future[String] = {
    val q = quote {
      customers.insertValue (lift(customer)).returning(_.name)
    }
    run(q)
  }

  def updateNameById(id:Int, nameToUpdate:String)(implicit ec:ExecutionContext):Future[Long] = {
    val q = quote {
      customers.filter(_.id == lift(id)).update(_.name -> lift(nameToUpdate))
    }
    run(q)
  }

  def deleteById(id:Int)(implicit ec:ExecutionContext):Future[Long] = {
    val q = quote {
      customers.filter(_.id == lift(id)).delete
    }
    run(q)
  }

}
