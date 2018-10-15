package ca.cours5b5.frederiksylvain.Exceptions;

public class ErreurDeSerialisation extends RuntimeException {

    public ErreurDeSerialisation(Exception e){

        super(e);
    }


    public ErreurDeSerialisation(String msg){

        super(msg);
    }
}
