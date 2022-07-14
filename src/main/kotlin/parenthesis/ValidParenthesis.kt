package parenthesis

import java.util.*

class ValidParenthesis {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        var popped: Char?
        for(c in s.toCharArray()) {
            when(c) {
                '(' -> stack.push(c)
                '[' -> stack.push(c)
                '{' -> stack.push(c)
                ')' -> {
                    if(stack.isEmpty()) {
                        return false
                    }
                    popped = stack.pop()
                    if(popped != '(') {
                        return false
                    }
                }
                ']' -> {
                    if(stack.isEmpty()) {
                        return false
                    }
                    popped = stack.pop()
                    if(popped != '[') {
                        return false
                    }
                }
                '}' -> {
                    if(stack.isEmpty()) {
                        return false
                    }
                    popped = stack.pop()
                    if(popped != '{') {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    println(ValidParenthesis().isValid("(())[]{}"))
    println(ValidParenthesis().isValid("(("))
    println(ValidParenthesis().isValid("((]]"))
    println(ValidParenthesis().isValid("([)]"))
    println(ValidParenthesis().isValid(""))
    println(ValidParenthesis().isValid("]"))
}
