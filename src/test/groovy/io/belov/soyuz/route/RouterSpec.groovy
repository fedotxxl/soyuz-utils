package io.belov.soyuz.route

import spock.lang.Specification

/**
 * Created by fbelov on 01.04.15.
 */
class RouterSpec extends Specification {

    def "should correctly read routes"() {
        when:
        def router = new Router(getClassPathInputStream("urls.js").newReader())

        then:
        assert router.routes
    }

    private getClassPathInputStream(String path) {
        return this.getClass().getClassLoader().getResourceAsStream(path);
    }

}
