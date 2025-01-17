package simplifypath

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SimplifyPathTest {

    @ParameterizedTest
    @CsvSource(
            "/home//foo/, /home/foo",
            "/../, /",
            "/home/user/Documents/../Pictures, /home/user/Pictures",
            "///home/user/Documents/../../Pictures//something, /home/Pictures/something",
            "/.../a/../b/c/../d/./, /.../b/d",
            "///, /",
    )
    fun `should return simplified path`(input: String, expected: String) {
        assertEquals(expected, SimplifyPath().simplifyPath1(input))
    }
}