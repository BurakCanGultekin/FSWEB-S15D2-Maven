package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getannsTasks() {
        return annsTasks;
    }

    public Set<Task> getbobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getcarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getunassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String owner){
        switch (owner) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                return getUnion(bobsTasks, annsTasks, carolsTasks);
        }
        return null;
    }

    public Set<Task> getUnion(Set<Task>... sets) {
       HashSet<Task> allTasks = new LinkedHashSet<>();
       for(Set<Task> tasks : sets){
           allTasks.addAll(tasks);
       }
        return allTasks;

    }
    public Set<Task> getIntersection (Set<Task> set1, Set<Task> set2){
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    public Set<Task> getDifferences (Set<Task> set1, Set<Task> set2){
        Set<Task> diff = new HashSet<>(set1);
        diff.removeAll(set2);
        return diff;
    }

}

