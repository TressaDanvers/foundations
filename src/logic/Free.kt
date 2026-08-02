package logic

data class Free(val name: String): Logim {
  override fun toString() = name
  override val free get() = listOf(this)
  override operator fun invoke(vararg map: Pair<Free, Logim>) =
    map.toMap().getOrDefault(this, this)
}