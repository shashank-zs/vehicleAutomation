package org.example.pojo;

import static org.example.utils.TestUtil.getSerialization;

public class JsonFromPojoPostProduct {
    /**
     * creates json from pojo for post product
     * @param title
     * @param price
     * @return
     */
    public static String createJsonPostProduct(Object title, Object price) {
        JsonToPojoConverterPostProduct pojoProduct = new JsonToPojoConverterPostProduct();
        pojoProduct.setTitle( title);
        pojoProduct.setPrice(price);

        return getSerialization(pojoProduct);
    }
}
