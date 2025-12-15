package com.example.integradoraalice.service;

import com.example.integradoraalice.Model.HistoryAction;
import com.example.integradoraalice.Structures.ArrayStack;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private ArrayStack<HistoryAction> stack = new ArrayStack<>(100);

    public ArrayStack<HistoryAction> getStack() {
        return stack;
    }

    public void push(HistoryAction action) {
        stack.push(action);
    }

    public HistoryAction pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
