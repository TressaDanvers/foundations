package logic

data class Free(val name: String): Logeme {
  override fun toString() = name
  override val free get() = listOf(this)
  override operator fun invoke(vararg map: Pair<Free, Logeme>) =
    map.toMap().getOrDefault(this, this)
}