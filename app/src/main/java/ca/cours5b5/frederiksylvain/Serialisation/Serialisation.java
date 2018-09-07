package ca.cours5b5.frederiksylvain.Serialisation;

import java.lang.reflect.Field;
import java.util.Map;

import ca.cours5b5.frederiksylvain.Exceptions.ErreurDeSerialisation;

public class Serialisation {

    public Map<String, Object> serialiser(Serialisable obj) throws ErreurDeSerialisation{
        return null;
    }

    public void deserialiser(Serialisable obj, Map<String, Object> objetJson) throws  ErreurDeSerialisation{

    }

    private static void serialiserAttributs(Map<String, Map> objetJson, Serialisable obj){

    }

    private static boolean siAttributSerialisable(Field attribut){
        return false;
    }

    private static void serialiserAttribut(Map<String, Object> objetJson, Serialisable obj, Field attribut){

    }

    private static Object serialiserValeur(Class Type, Object valeur){
        return null;
    }

    private static void desirialiserAttributs(Serialisable obj, Map<String, Object> objectJson){

    }

    private static void desirialiserAttributs(Serialisable obj, String nomAttribut, Object valeurAttribut){

    }

    private static void desirialiserAttributs(Serialisable obj, Field attribut, Object valeurAttribut){

    }


}
