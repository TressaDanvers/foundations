package logic

interface NonFree<T: NonFree<T>>: Logeme {
  override fun invoke(vararg map: Pair<Free, Logeme>): T
  override fun invoke(vararg map: Logeme) = invoke(*free.zip(map).toTypedArray())
}