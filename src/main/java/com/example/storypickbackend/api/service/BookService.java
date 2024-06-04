package com.example.storypickbackend.api.service;

import com.example.storypickbackend.api.domain.entity.ApplyBookEntity;
import com.example.storypickbackend.api.domain.repository.ApplyBookRepository;
import com.example.storypickbackend.api.domain.repository.BookRepository;
import com.example.storypickbackend.api.dto.response.BookListDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void fetchListData(String res, int max) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(res);

        BookListDto bookListDto = new BookListDto();

        if(res != null) {
            for(int i = 0; i < max; i++) {
                bookListDto.setTitle(rootNode.get("item").get(i).get("title").asText());
                bookListDto.setIsbn(rootNode.get("item").get(i).get("isbn13").asText());
                bookListDto.setCover(rootNode.get("item").get(i).get("cover").asText());

/*                System.out.println("Title: " + bookListDto.getTitle());
                System.out.println("ISBN13: " + bookListDto.getIsbn());
                System.out.println("Cover: " + bookListDto.getCover());*/
            }
        }

    }

    public void fetchData(String res) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(res);

        BookListDto bookListDto = new BookListDto();

        bookListDto.setTitle(rootNode.get("item").get(0).get("title").asText());
        bookListDto.setIsbn(rootNode.get("item").get(0).get("isbn13").asText());
        bookListDto.setCover(rootNode.get("item").get(0).get("cover").asText());
        bookListDto.setAuthor(rootNode.get("item").get(0).get("author").asText());
        bookListDto.setDescription(rootNode.get("item").get(0).get("description").asText());
        bookListDto.setCategoryName(rootNode.get("item").get(0).get("categoryName").asText());
        bookListDto.setRatingScore(rootNode.get("item").get(0).get("subInfo").get("ratingInfo").get("ratingScore").asInt());


/*        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN13: " + isbn13);
        System.out.println("Cover: " + cover);
        System.out.println("Description: " + description);
        System.out.println("category: " + category);
        System.out.println("rating: " +ratingScore);*/

    }

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