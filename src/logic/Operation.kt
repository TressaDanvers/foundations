package logic

interface Operation<T: Operation<T>>: NonFree<T> {
  val antecedent: Logim
  val consequent: Logim

  override fun invoke(vararg map: Pair<Free, Logim>) =
    build(antecedent(*map), consequent(*map))

  fun build(antecedent: Logim, consequent: Logim): T
}