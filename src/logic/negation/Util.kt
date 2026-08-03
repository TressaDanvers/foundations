package logic.negation

import logic.*

operator fun Logeme.not() = Negation(this)