package logic.disjunction

import logic.*

infix fun Logeme.or(other: Logeme) = Disjunction(this, other)