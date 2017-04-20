package models

import scala.io.Source
import scala.util.Random

class NameGenerator {

  private val r: Statistics = new Statistics
  val dict: List[Word] = readDictionary("res/words")
//  printList(dict)

  def main(args: Array[String]): Unit = {

  }

  private def readDictionary(path: String): List[Word] = {
    Source.fromFile(path).getLines().map(x => Word.build(x)).toList
  }

  private def printList(args: TraversableOnce[_]): Unit = {
    args.foreach(println)
  }

  def generateNickname: String = {
    val first: Word = r.nextFromList(dict)
    val second: Noun = r.nextFromList(dict.collect {case a: Noun => a})

    first match {
      case x: Noun => first.word + " и " + second.word
      case y: Adjective => second.gender.buildAdjective(y) + " " + second.word
    }
  }

  private class Statistics extends Random {
    def nextFromList[A](l: List[A]): A = {
      l(this.nextInt(l.length))
    }
  }

}

