package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNext(String s);

    String getNext();

    List<String> getHistory();

    void printString();

}
