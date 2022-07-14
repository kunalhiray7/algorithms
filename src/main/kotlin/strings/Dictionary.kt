package strings

/*
You are given a dictionary of words and a large input string. You have to find out whether the input string can be
completely segmented into the words of a given dictionary. The following two examples elaborate on the problem further.
Ex.
Given dictionary words - apple, pear, pier, pie
input - "applepie" - output - true as it has "apple" and "pie" from dictionary
input - "applepeer" - output - false as it has "apple" but "peer" is not from dictionary
 */

class Dictionary {
    fun canSegmentString(s: String, dictionary: Set<String>): Boolean {
        var temp: String = s
        for (word in dictionary) {
            if(s.contains(word) && temp.isNotBlank()) {
                temp = temp.replace(word, "")
            }
        }

        return temp.isBlank()
    }

    /*
    Given a string, find the length of the longest substring which has no repeating characters.
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val chars = s.toCharArray()
        var maxLength = Int.MIN_VALUE
        var set = HashSet<Char>()
        var counter = 0
        for(c in chars) {
            if(set.add(c)) {
                counter++
            } else {
                if(counter > maxLength) {
                    maxLength = counter
                }
                counter = 0
                set = HashSet()
            }
        }

        if(counter > maxLength) {
            maxLength = counter
        }

        return maxLength
    }
}

fun main() {
    val dictionary = Dictionary()
    val dict = setOf("apple", "pie", "pear", "pier")
    println(dictionary.canSegmentString("applepie", dict))
    println(dictionary.canSegmentString("applepeer", dict))
    println(dictionary.canSegmentString("pieapplepear", dict))
    println(dictionary.canSegmentString("pierapp", dict))
    println("-----------------------------")
    println(dictionary.lengthOfLongestSubstring("bjkdbfjdabfjafjklafbjjjjkkkjbb"))
    println(dictionary.lengthOfLongestSubstring("abcdefghaghijklmnopqrst"))
}
