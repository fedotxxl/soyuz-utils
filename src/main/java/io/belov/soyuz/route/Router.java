package io.belov.soyuz.route;

import javax.script.*;import javax.script.Bindings;import javax.script.ScriptEngine;import javax.script.ScriptEngineManager;import javax.script.ScriptException;import javax.script.SimpleBindings;
import java.io.InputStream;
import java.io.Reader;import java.lang.Object;
import java.util.Map;

/**
 * Created by fbelov on 01.04.15.
 */
public class Router {

    private static final Object ANY = new Object();

//    private Object routes = null;

    public Router(Reader reader) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        Bindings bindings = new SimpleBindings();
        engine.eval(reader, bindings);

        Map<Object, Object> routes = (Map) ((Map) bindings.get("nashorn.global")).get("vRoutes");
        mapRoutes(routes, "");
    }

    private void mapRoutes(Map<Object, Object> routes, String path) {
        for (Map.Entry e : routes.entrySet()) {
            Object v = e.getValue();
            if (v instanceof Map) {
                mapRoutes((Map<Object, Object>) v, path + "." + e.getKey());
            } else {
                String url = (String) e.getValue();
            }
        }
    }

    private void mapUrl(String url) {

    }

    public String getRoutePath(String url) {
        int vimeo = url.indexOf('?');
        if (vimeo >= 0) url = url.substring(0, vimeo);

        vimeo = url.indexOf(':');
        if (vimeo >= 0) {
            url = url.substring(0, vimeo);
            vimeo = url.lastIndexOf('/');
            if (vimeo >= 0) {
                url = url.substring(0, vimeo);
            }
        }

        Routes routes = new Routes();
        String[] parts = url.split("/");
        for (String part : parts) {
            routes = routes.get(part);
            if (routes == null) break;
        }

        if (routes != null) {
            return routes.getPath();
        } else {
            return null;
        }
    }
}
