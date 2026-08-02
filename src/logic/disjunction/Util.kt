package logic.disjunction

import logic.*
import logic.conjunction.Conjunction

infix fun Logeme.or(other: Logeme) = Disjunction(this, other)