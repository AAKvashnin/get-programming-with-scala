package org.example.quiz.dao

import io.getquill.{PostgresJAsyncContext, SnakeCase}

import scala.concurrent.ExecutionContext

class Dao(ctx: PostgresJAsyncContext[SnakeCase.type])
         (implicit ec: ExecutionContext) {

  val category = new CategoryDao(ctx)
  val generic = new GenericDao(ctx)
  val questionAnswer = new QuestionAnswerDao(ctx)

}
