package com.example.project.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

    @Getter
    @Service
    @RequiredArgsConstructor
    public class ViewService {
        private long viewCount = 0;

        public void increaseViewCount() {
        ++viewCount;
    }
}
