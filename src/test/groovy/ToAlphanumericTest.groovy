import org.junit.*
import com.lesfurets.jenkins.unit.*
import static groovy.test.GroovyAssert.*

class ToAlphanumericTest extends  BasePipelineTest {
    def toAlphanumeric
    def toUpperCase
    def calc

    @Before
    void setUp() {
        super.setUp()
        // load toAlphanumeric
        toAlphanumeric = loadScript("vars/toAlphanumeric.groovy")
        toUpperCase = loadScript("vars/toUpperCase.groovy")
        calc = loadScript("vars/add.groovy")
    }

    @Test
    void testCall() {
        def result = toAlphanumeric(text: "a_B-c.1-&^")
        assertEquals "result:", "abc1", result
    }

    @Test
    void testToUpperCase() {
        def result = toUpperCase(text: "hari kammana")
        assertEquals "result:", "HARI KAMMANA", result
    }

    @Test
    void testCalculator() {
        def result = calc(x: 10, y: 20)
        assertEquals "result:", 30, result
    }
}
