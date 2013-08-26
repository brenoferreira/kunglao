package models

/**
 * Created with IntelliJ IDEA.
 * User: Breno
 * Date: 23/08/13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
case class Player(val nome:String) {
  def winsOver(loser:Player) = new Victory(this, loser)
}

class Victory(val winner:Player, val loser:Player){
  def by(winnerScore:Int) = new Score(winner, winnerScore, loser, 0)
}

class Score(val winner:Player, val winnerScore:Int, val loser:Player, val loserScore:Int) {
  if(winnerScore > 2 || loserScore > 2) throw new Exception
  def to(loserScore:Int) = new Score(this.winner, this.winnerScore, this.loser, loserScore)
}