package logic

interface Property<T: Property<T>>: NonFree<T> {
  val logeme: Logeme

  override fun invoke(vararg map: Pair<Free, Logeme>) =
    build(logeme(*map))

  fun build(logeme: Logeme): T
}