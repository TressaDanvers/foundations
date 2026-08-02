package logic.conjunction

import logic.*

data class Conjunction(
  override val antecedent: Logeme,
  override val consequent: Logeme
): Operation<Conjunction> {
  override val free get() =
    (antecedent.free + consequent.free).distinct()
  override fun build(antecedent: Logeme, consequent: Logeme) =
    Conjunction(antecedent, consequent)
  override fun toString() = "($antecedent ∧ $consequent)"
}