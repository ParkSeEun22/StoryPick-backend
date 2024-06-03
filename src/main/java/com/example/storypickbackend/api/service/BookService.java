package com.example.storypickbackend.api.service;

import com.example.storypickbackend.api.domain.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

}

/*
//restTemplate 방식
    RestTemplate restTemplate = new RestTemplate();
    @Transactional
    public void fetchData() {
        //예시
        //근데 이 isbn 값도 front에서 post로 받은 bookid이어야 하는데 일단 !
        String isbn = "9791155817049";
        String openApi_permitted = "ttbcmss03302033001";
        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey="+openApi_permitted+"&itemIdType=ISBN&ItemId="+isbn+"&output=xml&Version=20131101&OptResult=ratingInfo,reviewList,fulldescription2,Story";
}
 */