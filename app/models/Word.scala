package models

object Word {
  def build(s: String): Word = {
    val array = s.split(',')
    array(1) match {
      case "n" => Noun(array(0),Gender.getGender(array(2)))
      case "adj" => Adjective(array(0),array(2),array(3),array(4),array(5))
      case _ => throw new Exception("Undefined Type of speech")
    }
  }
}

abstract class Word{
  def word: String
}

case class Noun(word: String, gender: Gender) extends Word
case class Adjective(word: String, mEnding: String, fEnding: String, nEnding: String, plEnding: String) extends Word

