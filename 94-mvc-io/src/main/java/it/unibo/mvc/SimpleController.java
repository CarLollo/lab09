package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    
    private List<String> list = new ArrayList<>();

    @Override
    public void setNext(String s) {
        this.list.add(s);
    }

    @Override
    public String getNext() {
        return this.list.get(this.list.size()-1);
    }

    @Override
    public List<String> getHistory() {
       return List.copyOf(this.list);
    }

    @Override
    public void printString() {
        System.out.println(this.getNext());
    }

}