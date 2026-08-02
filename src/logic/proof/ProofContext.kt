package logic.proof

import logic.Logim
import logic.implication.Implication
import logic.implication.implies

class ProofContext {
  private val hypothesis: MutableList<Logim> = mutableListOf()
  private val currentForm: MutableList<Logim> = mutableListOf()
  private val conclusion get() = currentForm.lastOrNull()

  fun assuming(hypothesized: Logim) {
    hypothesis += hypothesized
    currentForm += hypothesized
  }

  fun argue(argument: Logim) {
    var arg = argument
    currentForm += arg
    while (arg is Implication && currentForm.any { it == arg.antecedent }) {
      arg = arg.consequent
      currentForm += arg
    }
  }

  val qed: Nothing get() =
    if (conclusion == null)
      throw EmptyProofException("cannot form a proof of nothing")
    else if (hypothesis.isEmpty())
      throw EarlyReturn(conclusion as Logim)
    else throw EarlyReturn(hypothesis
      .foldRight(conclusion!!) { a, b -> a implies b } as Implication)
}