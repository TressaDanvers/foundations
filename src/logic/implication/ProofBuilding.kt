package logic.implication

import logic.Logim

private class EarlyReturn(val final: Logim): Exception()
class LogicalError(message: String): Exception(message)

class ProofBuilder {
  private val hypothesis: MutableList<Logim> = mutableListOf()
  private val currentForm: MutableList<Logim> = mutableListOf()
  private val conclusion get() = currentForm.lastOrNull()

  fun assuming(hypothesized: Logim) {
    hypothesis += hypothesized
    currentForm += hypothesized
  }

  fun argue(argument: Logim) {
    var arg = argument
    while (true) {
      currentForm += arg
      if (arg !is Implication ||
        currentForm.none { it == arg.antecedent }) break
      arg = arg.consequent
    }
  }

  val qed: Nothing get() =
    if (conclusion == null)
      throw LogicalError("cannot form a proof of nothing")
    else if (hypothesis.isEmpty())
      throw EarlyReturn(conclusion as Logim)
    else throw EarlyReturn(hypothesis
      .foldRight(conclusion!!) { a, b -> a implies b } as Implication)
}

fun Proof(f: ProofBuilder.() -> Nothing) =
  try { f(ProofBuilder()) }
  catch(er: EarlyReturn) { er.final }