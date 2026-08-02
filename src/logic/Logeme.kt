package logic

sealed interface Logeme {
  val free: List<Free>
  operator fun invoke(vararg map: Pair<Free, Logeme>): Logeme

  operator fun invoke(vararg map: Logeme): Logeme =
    invoke(*free.zip(map).toTypedArray())
}