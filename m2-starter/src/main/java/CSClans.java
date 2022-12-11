import java.util.*;


// Convert the disjoint set of integers into the disjoint set of strings
class DisjointSet {
    ArrayList<Integer> p;
    ArrayList<Integer> sz;
    ArrayList<String> roots;
    HashMap<String, Integer> stringToInteger;
    HashMap<Integer, String> numberToString;
    HashMap<String, Set<String>> allClans;

    public DisjointSet() {
        p = new ArrayList<>();
        sz = new ArrayList<>();
        allClans = new HashMap<>();
        roots = new ArrayList<>();
        stringToInteger = new HashMap<>();
        numberToString = new HashMap<>();
    }

    public void add(String name) {
        if (!stringToInteger.containsKey(name)) {
            stringToInteger.put(name, stringToInteger.size());
            numberToString.put(numberToString.size(), name);
        }
        if (!allClans.containsKey(name)) {
            allClans.put(name, new HashSet<>());
            allClans.get(name).add(name);
        } else {
            allClans.get(name).add(name);
        }

        roots.add(name);
        p.add(stringToInteger.size() - 1);
        sz.add(1);
    }

    public String root(String name) {
        int i = stringToInteger.get(name);
        while (p.get(i) != i) i = p.get(i);
        return numberToString.get(i);
    }


    public void link(String x, String y) {
        int rootX = stringToInteger.get(root(x)), rootY = stringToInteger.get(root(y));
        int szX = sz.get(rootX), szY = sz.get(rootY);
        if (szX <= szY) {
            p.set(rootX, p.get(rootY));
            sz.set(rootY, szX + szY);
            allClans.get(root(y)).addAll(allClans.get(x));
            roots.remove(x);
        } else {
            p.set(rootY, p.get(rootX));
            sz.set(rootX, szX + szY);
            allClans.get(root(x)).addAll(allClans.get(y));
            roots.remove(y);
        }
    }
}

public class CSClans {
    final DisjointSet disjointSet;
    final HashMap<String, Integer> evilAuraHash;

    public CSClans() {
        evilAuraHash = new HashMap<>();
        disjointSet = new DisjointSet();
    }

    public void set(String name, int evilAura) {
        if (!evilAuraHash.containsKey(name))
            disjointSet.add(name);
        evilAuraHash.put(name, evilAura);
    }

    void tailShake(String catA, String catB) {
        if (disjointSet.root(catA).equals(disjointSet.root(catB))) return;
        disjointSet.link(catA, catB);
    }

    public Map<String, Double> report() {
        Map<String, Double> report = new HashMap<>();

        for (String x : disjointSet.roots) {
            Set<String> clan = disjointSet.allClans.get(x);
            report.put(findMaxCat(clan), findAverage(clan));
        }

        return report;
    }

    public Double findAverage(Set<String> clan) {
        Double total = 0.0;
        for (String cat : clan) {
            total += evilAuraHash.get(cat);
        }
        return total / clan.size();
    }

    public String findMaxCat(Set<String> clan) {
        String maxCat = "";
        int maxEvilAura = Integer.MIN_VALUE;
        for (String cat : clan) {
            int currentEvilAura = evilAuraHash.get(cat);
            if (currentEvilAura > maxEvilAura) {
                maxCat = cat;
                maxEvilAura = currentEvilAura;
            }
        }
        return maxCat;
    }

    public static void main(String[] args) {
        {
            CSClans cs = new CSClans();
            cs.set("Taro", 50);
            cs.set("Yellow", 100);
            cs.set("Tabot", 1);
            cs.tailShake("Taro", "Tabot");
            cs.set("Tabot", 100);
            Map<String, Double> expected = Map.of("Yellow", 100.0, "Tabot", 75.0);
            Map<String, Double> yourAnswer = cs.report();
            System.out.println(yourAnswer);
            System.out.println(expected.equals(yourAnswer));
        }
        {
            CSClans cs = new CSClans();
            cs.set("Beth", 8);
            cs.set("Deb", 50);
            cs.set("Jolie", 2);
            cs.set("Alice", 23);
            cs.tailShake("Jolie", "Deb");
            cs.set("Jolie", 10);
            cs.set("Vera", 4);
            cs.set("Cathy", 21);
            cs.tailShake("Cathy", "Beth");
            cs.tailShake("Beth", "Vera");
            cs.set("Alice", 21);
            // expect: {Deb=30.0, Alice=21.0, Cathy=11.0}
            Map<String, Double> expected = Map.of("Deb", 30.0, "Alice", 21.0, "Cathy", 11.0);
            Map<String, Double> yourAnswer = cs.report();
            System.out.println(yourAnswer);
            System.out.println(expected.equals(yourAnswer));
        }

        {
            CSClans cs = new CSClans();
            int n = 100000;
            for (int i = 0; i < n; i++) cs.set("c" + i, 0); // all cats with 0 evilness
            int p = 10000;
            for (int b = 0; b < n; b += p) {
                for (int i = 0; i < p - 1; i++) {
                    cs.tailShake("c" + (b + i), "c" + (b + i + 1));
                    cs.set("c" + (b + i), (b / p) + p - i);
                }
            }
            Map<String, Double> expected = Map.of(
                    "c40000", 5004.4995, "c50000", 5005.4994, "c30000", 5003.4996, "c10000",
                    5001.4998, "c20000", 5002.4997, "c70000", 5007.4992, "c60000", 5006.4993,
                    "c0", 5000.4999, "c80000", 5008.4991, "c90000", 5009.499
            );
            Map<String, Double> yourAnswer = cs.report();
            System.out.println(yourAnswer);
            System.out.println(expected.equals(yourAnswer));
            System.out.println();
            // expect:
            // {c40000=5004.4995, c50000=5005.4994, c30000=5003.4996, c10000=5001.4998, c20000=5002.4997, c70000=5007.4992, c60000=5006.4993, c0=5000.4999, c80000=5008.4991, c90000=5009.499}
        }
    }
}

