package com.epam.mjc.collections.combined;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        return projects.entrySet()
                .stream()
                .map(es -> es.getValue().contains(developer) ? es.getKey() : "")
                .filter(project -> !project.isEmpty())
                .sorted(((o1, o2) -> o2.length() - o1.length() == 0
                        ? o2.compareTo(o1)
                        : o2.length() - o1.length()
                ))
                .collect(Collectors.toList());
    }
}
