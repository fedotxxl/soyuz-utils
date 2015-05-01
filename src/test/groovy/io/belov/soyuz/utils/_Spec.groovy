package io.belov.soyuz.utils

import spock.lang.Specification
import io.belov.soyuz.utils._ as utils

/**
 * Created by fbelov on 01.05.15.
 */
class _Spec extends Specification {

    def "should replace params in string"() {
        expect:
        assert utils.s(source, params as Object[]) == expected

        where:
        source                     | params                                 | expected
        "hello world"              | []                                     | "hello world"
        "hello {0} param"          | ["first"]                              | "hello first param"
        "hello {0} and {2} params" | ["first", "second", "third", "fourth"] | "hello first and third params"
    }

}
