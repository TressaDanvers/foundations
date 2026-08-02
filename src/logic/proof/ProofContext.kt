package logic.proof

import logic.*
import logic.implication.*

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
    while (arg is Implication) {
      if (currentForm.none { it == arg.antecedent })
        assuming(arg.antecedent)
      arg = arg.consequent
      currentForm += arg
    }
    return arg
  }

  val qed: Nothing get() =
    if (conclusion == null)
      throw EarlyReturn(tru)
    else if (hypothesis.isEmpty())
      throw EarlyReturn(conclusion as Logeme)
    else throw EarlyReturn(hypothesis
      .foldRight(conclusion!!) { a, b -> a implies b } as Implication)
}