package by.it_academy.jd2.view;

import java.util.ArrayList;
import java.util.List;

public class NameView {

    private final List<String> list = new ArrayList<>();

    public void addNames(String name){
        this.list.add(name);
    }

    public List<String> getAll(){
        this.list.remove(list.size()-1);
        return this.list;
    }
}
