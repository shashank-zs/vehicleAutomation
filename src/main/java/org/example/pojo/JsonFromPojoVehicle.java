package org.example.pojo;

import java.util.ArrayList;

import static org.example.utils.TestUtil.getSerialization;

public class JsonFromPojoVehicle {
    public static String createJsonVehicle(Object number, Object type, Object vendorId, Object storeId) {
        JsonToPojoConvertForVehicle pojoVehicle = new JsonToPojoConvertForVehicle();
        pojoVehicle.setNumber( number);
        pojoVehicle.setType(type);
        pojoVehicle.setVendorId( vendorId);
        pojoVehicle.setStoreId( storeId);

        return getSerialization(pojoVehicle);
    }
}
