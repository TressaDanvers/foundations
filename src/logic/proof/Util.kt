package logic.proof

fun proof(f: ProofContext.() -> Nothing) =
  try { f(ProofContext()) }
  catch(er: EarlyReturn) { er.final }