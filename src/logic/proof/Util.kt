package logic.proof

import logic.*
import logic.implication.*

fun proof(f: ProofContext.() -> Nothing) =
  try { f(ProofContext()) }
  catch(er: EarlyReturn) { er.final }

val Logeme.roll: List<Logeme> get() = when(this) {
  is Implication -> listOf(antecedent) + consequent.roll
  else -> listOf(this)
}

val Logeme.expand get() =
  roll.dropLast(1).map { proof {
    argue(this@expand)
    argue(it)
    qed
  } }