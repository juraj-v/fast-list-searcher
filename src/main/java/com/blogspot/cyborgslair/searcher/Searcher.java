package com.blogspot.cyborgslair.searcher;

import java.util.*;

// todo make more generic - ordered collection is enough, list of generic contained object also
public class Searcher {//<E implements List<F extends Object>> {
    private final ArrayList<List<Object>> list = new ArrayList<>();
    // todo replace by more efficient collections
    private final Map<Integer, Map<Object, Set<Integer>>> valuesCache = new HashMap<>();

// todo clear method

    public void add(List<Object> row) {
        int index = list.size();
        cacheRow(row, index);
        list.add(row);
        // todo regenerate the smallest set
    }

    public List<List<Object>> search(List<Object> queryList) {

        Set<Integer> resultIndexes = null;

        // todo get the smallest one set?

        for (int i = 0; i < queryList.size(); i++) {
            Map<Object, Set<Integer>> valsForPosition = valuesCache.get(i);

            if (valsForPosition != null) {
                if (resultIndexes == null) {
                    if (valsForPosition.get(queryList.get(i)) != null) {
                        resultIndexes = new HashSet<>(valsForPosition.get(queryList.get(i)));
                    }
                } else {
                    Set<Integer> temSet = valsForPosition.get(queryList.get(i));
                    if (temSet != null) {
                        resultIndexes.retainAll(temSet);
                    }
                }
            }
        }

        List<List<Object>> result = new ArrayList<>();

        for (Integer matchingRowPosition : resultIndexes) {
            result.add(list.get(matchingRowPosition));
        }

        return result;
    }

    private void cacheRow(List<Object> row, int position) {

        for (int positionInRow = 0; positionInRow < row.size(); positionInRow++) {
            cacheValue(row.get(positionInRow), positionInRow, position);
        }
    }

    private void cacheValue(Object val, int positionInRow, int position) {

        Map<Object, Set<Integer>> valsInList = null;

        if ((valsInList = valuesCache.get(positionInRow)) == null) {
            Map<Object, Set<Integer>> valsInListMap = new HashMap<>();
            valuesCache.put(positionInRow, valsInListMap);
            valsInList = valsInListMap;
        }

        if (valsInList.get(val) == null) {
            valsInList.put(val, new HashSet<>());
        }

        valsInList.get(val).add(position);
    }
}
