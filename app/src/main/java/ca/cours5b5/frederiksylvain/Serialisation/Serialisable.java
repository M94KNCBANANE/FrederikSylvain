package ca.cours5b5.frederiksylvain.Serialisation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Serialisable {

    public @Retention(RetentionPolicy.RUNTIME) @interface AttributSerialisable{

    }
}
