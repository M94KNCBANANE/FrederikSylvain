package ca.cours5b5.frederiksylvain.donnees;

import java.util.Map;

public interface ListenerChargement {

    void reagirSucces(Map<String, Object> objetJson);
    void reagirErreur(Exception e);
}
