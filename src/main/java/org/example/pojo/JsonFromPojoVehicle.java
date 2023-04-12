package org.example.pojo;

import java.util.ArrayList;

import static org.example.utils.TestUtil.getSerialization;

public class JsonFromPojoVehicle {
    /**
     * create json from pojo for post auth
     * @param username
     * @param password
     * @return
     */
    public static String createJsonAuth(Object username, Object password) {
        JsonToPojoConvertForPostAuth pojoAuth = new JsonToPojoConvertForPostAuth();
        pojoAuth.setUsername( username);
        pojoAuth.setPassword(password);

        return getSerialization(pojoAuth);
    }
}
