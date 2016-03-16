package com.blogspot.cyborgslair;


import com.blogspot.cyborgslair.searcher.Searcher;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Searcher searcher = new Searcher();
        searcher.add((List)new ArrayList<String>(){{add("A");add("B");}});
        searcher.add((List)new ArrayList<String>(){{add("X");add("B");}});

        searcher.search((List)new ArrayList<String>(){{add(null);add("B");}});
//        searcher.search((List)new ArrayList<String>(){{add("A");add(null);}});
    }
}
