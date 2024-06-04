package com.example.storypickbackend.api.service;

import com.example.storypickbackend.api.domain.entity.ApplyBookEntity;
import com.example.storypickbackend.api.domain.repository.ApplyBookRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyBookService {

    private ApplyBookRepository applyBookRepository;

    public Long saveApply(ApplyBookEntity applyBook) {
        ApplyBookEntity savedApplyBook = applyBookRepository.save(applyBook);
        return savedApplyBook.getApplyBook_id();
    }
}
