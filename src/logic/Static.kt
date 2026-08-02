package logic

data class Static(val name: String): NonFree<Static> {
  override fun toString() = name
  override val free get() = emptyList<Free>()
  override fun invoke(vararg map: Pair<Free, Logeme>) = this
}