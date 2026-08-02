package logic

interface Operation<T: Operation<T>>: NonFree<T> {
  val antecedent: Logeme
  val consequent: Logeme

  override fun invoke(vararg map: Pair<Free, Logeme>) =
    build(antecedent(*map), consequent(*map))

  fun build(antecedent: Logeme, consequent: Logeme): T
}