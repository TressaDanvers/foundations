package logic

sealed interface Logim {
  val free: List<Free>
  operator fun invoke(vararg map: Pair<Free, Logim>): Logim

  operator fun invoke(vararg map: Logim): Logim =
    invoke(*free.zip(map).toTypedArray())
}