package org.dieschnittstelle.ess.basics;


import org.dieschnittstelle.ess.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.ess.basics.annotations.DisplayAs;
import org.dieschnittstelle.ess.basics.annotations.StockItemProxyImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

import static org.dieschnittstelle.ess.utils.Utils.*;

public class ShowAnnotations {

    public static void main(String[] args) {
        // we initialise the collection
        StockItemCollection collection = new StockItemCollection(
                "stockitems_annotations.xml", new AnnotatedStockItemBuilder());
        // we load the contents into the collection
        collection.load();

        for (IStockItem consumable : collection.getStockItems()) {
            try {
                showAttributes(((StockItemProxyImpl) consumable).getProxiedObject());

            } catch (IllegalAccessException exception) {
                exception.printStackTrace();
            }

        }

        // we initialise a consumer
        //Consumer consumer = new Consumer();
        // ... and let them consume
        //consumer.doShopping(collection.getStockItems());

    }

    /*
     * TODO BAS2
     */
    private static void showAttributes(Object instance) throws IllegalAccessException {
        // TODO BAS2: create a string representation of instance by iterating
        //  over the object's attributes / fields as provided by its class
        //  and reading out the attribute values. The string representation
        //  will then be built from the field names and field values.
        //  Note that only read-access to fields via getters or direct access
        //  is required here.


        // TODO BAS3: if the new @DisplayAs annotation is present on a field,
        //  the string representation will not use the field's name, but the name
        //  specified in the the annotation. Regardless of @DisplayAs being present
        //  or not, the field's value will be included in the string representation.

        Class ObjectClass = instance.getClass();
        String finalString = ObjectClass.getSimpleName() + " ";
        for (Field field : ObjectClass.getDeclaredFields()) {
            field.setAccessible(true);
            // Annotation
            String fieldName = field.isAnnotationPresent(DisplayAs.class) ? field.getAnnotation(DisplayAs.class).value() : field.getName();
            String fieldValue = field.get(instance).toString();
            finalString += fieldName + " : " + fieldValue + " , ";
        }

        show("{ %s }", finalString.substring(0, finalString.length() - 3));
        // Könnte auch mit JsonObject optimiert werden

    }

}
