package zigzagpatern

import java.lang.StringBuilder

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"


Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */
class ZigZagPattern {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val sb = Array(numRows) { StringBuilder() }
        var i = 0
        var j = 0
        while (i < s.length) {
            if (j < 0) {
                j = 1
            }
            if (j <= 1) {
                while (j < numRows && i < s.length) {
                    sb[j].append(s.elementAt(i))
                    j += 1
                    i += 1
                }
            }
            if (j == numRows) {
                j -= 2
                while (j >= 0 && i < s.length) {
                    sb[j].append(s.elementAt(i))
                    j -= 1
                    i += 1
                }
            }
        }

        return sb.map { it.toString() }.reduce { acc, str -> acc + str }
    }
}

fun main() {
    val input = "PAYPALISHIRING"
    val outpuit3 = "PAHNAPLSIIGYIR"
    val outpuit4 = "PINALSIGYAHRPI"
    println(ZigZagPattern().convert("AB", 1))
}
