package org.example.services;

import org.example.interfaces.IOperation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Service
public class HistoryService {
    private Set<String> history = new LinkedHashSet<>();
    public HistoryService() {}
    public Set<String> getHistory(){
        return new LinkedHashSet<>(history);
    }
    public void addHistory(String operation){
        if (operation != null && !operation.trim().isEmpty()) {
            history.add(operation);
        }
    }
}
