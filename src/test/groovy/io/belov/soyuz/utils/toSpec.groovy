package io.belov.soyuz.utils

import spock.lang.Specification
import io.belov.soyuz.utils.to as utils

/**
 * Created by fbelov on 05.02.16.
 */
class toSpec extends Specification {

    def "should correctly convert to map"() {
        when:
        def answer = utils.map("a", 1, "b", 2, "c", 3)

        then:
        assert answer.keySet().size() == 3
        assert answer.a == 1
        assert answer.b == 2
        assert answer.c == 3
    }

}
