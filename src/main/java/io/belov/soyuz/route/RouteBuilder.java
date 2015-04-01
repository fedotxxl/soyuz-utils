package io.belov.soyuz.route;

import io.belov.soyuz.utils._;
import io.belov.soyuz.utils.is;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by fbelov on 01.04.15.
 */
public class RouteBuilder {

    private Map<String, String> urls = new HashMap<>();

    RouteBuilder add(String path, String url) {
        urls.put(path, url);
        return this;
    }

    Routes build() {
        Routes root = new Routes();

        for (Map.Entry<String, String> e : urls.entrySet()) {
            Routes current = root;

            for (String part : Router.Utils.splitPath(e.getValue())) {
                Routes child = current.getChild(part);

                if (child == null) {
                    child = current.addChildren(new Routes(part));
                }

                current = child;
            }

            if (current != null) {
                current.setRouteName(e.getKey());
            }
        }

        root.build();

        return root;
    }

}
