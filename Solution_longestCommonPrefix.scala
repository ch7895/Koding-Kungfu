

object Solution_longestCommonPrefix {

   val runtime = Runtime.getRuntime

  def main(args: Array[String]) {
    println("Hello, world!\n==========")
    val mb = 1024 * 1024

    println("** Before Used Memory:  " + runtime.totalMemory() + "/" + runtime.freeMemory() + "/" +  (runtime.totalMemory - runtime.freeMemory))
    

    val strs = Array("leets", "leetcode", "leet", "leeds")

    val result1 = longestCommonPrefix1(strs)
    println(result1)
    println("** fun1 Used Memory:  " + (runtime.totalMemory - runtime.freeMemory))

    val result2 = longestCommonPrefix2(strs)
    println(result2)
    println("** fun2 Used Memory:  " + (runtime.totalMemory - runtime.freeMemory))

    val result3 = longestCommonPrefix3(strs)
    println(result3)
    println("** fun3 Used Memory:  " + (runtime.totalMemory - runtime.freeMemory))

    
    val result4 = longestCommonPrefix4(strs)
    println(result4)
    println("** fun4 Used Memory:  " + (runtime.totalMemory - runtime.freeMemory))

  }

  def longestCommonPrefix1(strs: Array[String]): String = {

    if (strs.length == 0) return "";
    var prefix = strs(0);
    for (i <- 0 until strs.size)
      while (strs(i).indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) return "";
      }
    return prefix

  }

  
  
  
  
  
  def longestCommonPrefix2(strs: Array[String]): String = {
    if (strs == null || strs.length == 0)
      return "";
    var minLen = Integer.MAX_VALUE;

    for (str <- strs) minLen = Math.min(minLen, str.length());
    var low = 1;
    var high = minLen;
    while (low <= high) {
      var middle = (low + high) / 2;
      println(middle)
      if (isCommonPrefix(strs, middle))
        low = middle + 1;
      else
        high = middle - 1;
    }
    strs(0).substring(0, (low + high) / 2)
  }

  def isCommonPrefix(strs: Array[String], len: Int): Boolean = {
    val str1 = strs(0).substring(0, len);
    for (i <- 0 until strs.size) {
      if (!strs(i).startsWith(str1))
        false;
    }
    true;
  }

  
  
  
  
  def longestCommonPrefix3(strs: Array[String]): String = {
    if (strs == null || strs.length == 0) return "";
    return longestCommonPrefix3(strs, 0, strs.length - 1);
  }

  def longestCommonPrefix3(strs: Array[String], l: Int, r: Int): String = {
    if (l == r) {
      return strs(l);
    } else {
      var mid = (l + r) / 2;
      var lcpLeft = longestCommonPrefix3(strs, l, mid);
      var lcpRight = longestCommonPrefix3(strs, mid + 1, r);
      return commonPrefix(lcpLeft, lcpRight);
    }
  }

  def commonPrefix(left: String, right: String): String = {
    val min = Math.min(left.length(), right.length());
    for (i <- 0 until min) {
      if (left.charAt(i) != right.charAt(i))
        return left.substring(0, i);
    }
    return left.substring(0, min);
  }

  def longestCommonPrefix4(strs: Array[String]): String = {
   strs.foldLeft("")((_,_) =>    (strs.min,strs.max).zipped.takeWhile(v => v._1 == v._2).unzip._1.mkString)

  }

}
