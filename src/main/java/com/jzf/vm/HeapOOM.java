package com.jzf.vm;

import com.jzf.App;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {

    }

    public static void main( String[] args )
    {
        List<OOMObject> oomObjectList = new ArrayList<>();

        while (true) {
            oomObjectList.add(new OOMObject());
            System.out.println(oomObjectList.size());
        }
    }

}
