package logic.disjunction

import logic.*

data class Disjunction(
  override val antecedent: Logeme,
  override val consequent: Logeme
): Operation<Disjunction> {
  override val free get() =
    (antecedent.free + consequent.free).distinct()
  override fun build(antecedent: Logeme, consequent: Logeme) =
    Disjunction(antecedent, consequent)
  override fun toString() = "($antecedent ∨ $consequent)"
}