package logic.proof

fun proof(f: ProofContext.() -> Nothing) = runCatching {
  try { f(ProofContext()) }
  catch(er: EarlyReturn) { er.final }
}