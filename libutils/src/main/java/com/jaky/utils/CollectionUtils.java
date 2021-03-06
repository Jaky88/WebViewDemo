package com.jaky.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jaky on 2018/2/12 0012.
 */

public class CollectionUtils {
    static public boolean isNullOrEmpty(final Collection list) {
        return list == null || list.size() <= 0;
    }

    static public boolean isNullOrEmpty(final Map map) {
        return map == null || map.size() <= 0;
    }


    static public boolean contains(final Set<String> set, final String value) {
        if (set != null && set.size() > 0) {
            return set.contains(value);
        }
        return true;
    }

    static public boolean contains(final Set<String> source, final Collection<String> target) {
        if (source == null && target == null) {
            return true;
        }
        if (source == null || target == null) {
            return false;
        }
        for (String string : target) {
            if (source.contains(string)) {
                return true;
            }
        }
        return false;
    }

    static public boolean equals(final Set firstSet, final Set secondSet) {
        if (firstSet == null || secondSet == null) {
            return false;
        }
        return firstSet.equals(secondSet);
    }

    static public boolean contains(final List<String> list, final String string) {
        if (list == null) {
            return true;
        }
        if (list.contains(string)) {
            return true;
        }
        return false;
    }

    static public int getSize(Collection collection) {
        return collection == null ? 0 : collection.size();
    }

    static public boolean safelyContains(final Set<String> set, final String string) {
        return set != null && set.contains(string);
    }

    static public boolean safelyContains(final List<String> list, final String string) {
        if (list == null) {
            return true;
        }
        if (list.contains(string)) {
            return true;
        }
        return false;
    }

    public static void diff(final HashSet<String> origin, final HashSet<String> target, final HashSet<String> diff) {
        for(String s : target) {
            if (!origin.contains(s)) {
                diff.add(s);
            }
        }
    }
}

