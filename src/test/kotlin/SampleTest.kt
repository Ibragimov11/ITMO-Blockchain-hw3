import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 *@author Said Ibragimov on 03.11.2022 20:59
 */

class SampleTest : StringSpec({
    "strings.length should return size of string" {
        "hello".length shouldBe 5
    }
})
