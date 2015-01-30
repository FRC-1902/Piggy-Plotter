package com.explodingbacon.amap;

import java.util.ArrayList;
import java.util.List;

public class Command {
    
    public List<String[]> data = new ArrayList<>();
    
    public Command() {}
    
    public Command(String[] data) {
        this.data.add(data);
    }    
}
