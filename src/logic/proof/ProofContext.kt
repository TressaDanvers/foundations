package logic.proof

import logic.Logeme
import logic.implication.Implication
import logic.implication.implies

class ProofContext {
  private val hypothesis: MutableList<Logeme> = mutableListOf()
  private val currentForm: MutableList<Logeme> = mutableListOf()
  private val conclusion get() = currentForm.lastOrNull()

  fun assuming(hypothesized: Logeme): Logeme {
    hypothesis += hypothesized
    currentForm += hypothesized
    return hypothesized
  }

  fun argue(argument: Logeme): Logeme {
    var arg = argument
    currentForm += arg
    while (arg is Implication && currentForm.any { it == arg.antecedent }) {
      arg = arg.consequent
      currentForm += arg
    }
    return arg
  }

  val qed: Nothing get() =
    if (conclusion == null)
      throw EmptyProofException("cannot form a proof of nothing")
    else if (hypothesis.isEmpty())
      throw EarlyReturn(conclusion as Logeme)
    else throw EarlyReturn(hypothesis
      .foldRight(conclusion!!) { a, b -> a implies b } as Implication)
}