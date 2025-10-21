package prg1.lx05.ex02c_memory

import prg1.lx05.ex02_complex1.{Complex => Complex1}
import prg1.lx05.ex02_complex2.{Complex => Complex2}
import prg1.lx05.ex02_complex3.{Complex => Complex3}

object MemoryTest {
  val runtime = scala.sys.runtime
  def consumedMemory = runtime.totalMemory() - runtime.freeMemory()

  def memoryTest1(N: Int) = {
    runtime.gc()
    val memUsageBefore = consumedMemory
    val v: Array[Complex1] = Array.tabulate(N){ i => new Complex1(i, i) }
    runtime.gc()
    val memUsageAfter  = consumedMemory
    memUsageAfter - memUsageBefore
  }

  def memoryTest2(N: Int) = {
    runtime.gc()
    val memUsageBefore = consumedMemory
    val v: Array[Complex2] = Array.tabulate(N){ i => new Complex2(i, i) }
    runtime.gc()
    val memUsageAfter  = consumedMemory
    //(memUsageAfter - memUsageBefore, v(scala.util.Random.nextInt(v.length)))
    memUsageAfter - memUsageBefore
  }

  def memoryTest3(N: Int) = {
    runtime.gc()
    val memUsageBefore = consumedMemory
    val v: Array[Complex3] = Array.tabulate(N){ i => new Complex3(i, i) }
    runtime.gc()
    val memUsageAfter  = consumedMemory
    memUsageAfter - memUsageBefore
  }

  @main def test = {
    val N = 1 << 20

    def log(usage: Long, heading: String) : Unit = {
      println(f"$heading> $usage bytes used.  ${usage / N} bytes, or ${usage / N / 8} words, per a Complex object")
    }

    for (i <- 1 to 5) {
      println(" ")
      log(memoryTest1(N), "Test 1 (val re = _re)")
      log(memoryTest2(N), "Test 2 (def re = _re)")
      log(memoryTest3(N), "Test 3 (val 引数)    ")
      //memoryTest2(N) match { case(usage, _) => log(usage, "Test 2") }
    }
  }
}
