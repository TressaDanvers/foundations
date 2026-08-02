package logic

interface NonFree<T: NonFree<T>>: Logim {
  override fun invoke(vararg map: Pair<Free, Logim>): T
  override fun invoke(vararg map: Logim) = invoke(*free.zip(map).toTypedArray())
}