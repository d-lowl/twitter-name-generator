package models

object Gender {
  def getGender(s: String): Gender = s match {
    case "m" => MasculineGender
    case "f" => FeminineGender
    case "n" => NeutralGender
    case "pl" => PluralNonGender
    case _ => throw new Exception("Undefined Gender")
  }
}

trait Gender{
  def buildAdjective(s: Adjective): String
}

object MasculineGender extends Gender{
  override def buildAdjective(s: Adjective): String = s.word+s.mEnding
}

object FeminineGender extends Gender{
  override def buildAdjective(s: Adjective): String = s.word+s.fEnding
}

object NeutralGender extends Gender{
  override def buildAdjective(s: Adjective): String = s.word+s.nEnding
}

object PluralNonGender extends Gender{
  override def buildAdjective(s: Adjective): String = s.word+s.plEnding
}

object NilGender extends Gender{
  override def buildAdjective(s: Adjective): String = ""
}