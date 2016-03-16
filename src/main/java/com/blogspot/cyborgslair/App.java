package com.blogspot.cyborgslair;


import com.blogspot.cyborgslair.searcher.Searcher;

import java.util.ArrayList;
import java.util.List;

public class App
{
    // todo create sufficient test cases - apply TDD
    // different lengths etc.
    public static void main( String[] args )
    {
        Searcher searcher = new Searcher();
        searcher.add((List)new ArrayList<String>(){{add("A");add("B");}});
        searcher.add((List)new ArrayList<String>(){{add("X");add("B");}});

        searcher.search((List)new ArrayList<String>(){{add("X");add(null);}});
//        searcher.search((List)new ArrayList<String>(){{add("A");add(null);}});
    }
}
