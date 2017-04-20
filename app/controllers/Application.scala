package controllers

import play.api._
import play.api.mvc._
import play.api.cache.Cache
import play.api.Play.current

import play.api.db._
import models.NameGenerator

object Application extends Controller {

  private def nameGenerator: NameGenerator = new NameGenerator

  def index = Action {
    Ok(views.html.index(null))
  }

  def generate = Action {
    Ok(nameGenerator.generateNickname)
  }
}
