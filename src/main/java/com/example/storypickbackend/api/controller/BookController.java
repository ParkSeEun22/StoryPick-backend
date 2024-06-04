package com.example.storypickbackend.api.controller;


import com.example.storypickbackend.api.domain.entity.ApplyBookEntity;
import com.example.storypickbackend.api.dto.response.ResponseVo;
import com.example.storypickbackend.api.service.ApplyBookService;
import com.example.storypickbackend.api.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
//@CrossOrigin(origins = "*")
public class BookController {

    private final BookService bookService;
    private final ApplyBookService applyBookService;
    private final WebClient.Builder webClientBuilder;
    private final int MAX_RESULTS = 10;

    @GetMapping("/api")
    public String springData(String msg) {
        return msg;
    }


    @GetMapping("/hello")
    public ResponseEntity<ResponseVo> initApi(@RequestParam String input) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setUcd("0");
        responseVo.setMessage("수신된 값" + input);
        return ResponseEntity.ok(responseVo);
    }

    // 책 리스트 나열
    @GetMapping("/booklist")
    public ResponseEntity<ResponseVo> showApiList(@RequestParam String data) throws JsonProcessingException{
        String apiKey = data;

        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemList.aspx?ttbkey={apiKey}&QueryType=ItemNewAll&MaxResults=MAX_RESULTS&start=1&SearchTarget=Book&output=js&Version=20131101";
        String res = webClientBuilder.build()
                .get()
                .uri(apiUrl, apiKey, data)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        bookService.fetchListData(res , MAX_RESULTS);

        ResponseVo responseVo = new ResponseVo();

        if(res == null){
            responseVo.setUcd("99");
            responseVo.setMessage("실패");
        }
        else{
            responseVo.setUcd("00");
            responseVo.setMessage(res);
        }
        return ResponseEntity.ok(responseVo);
    }

    // 책 상세 정보
    @GetMapping("/bookinfo")
    public ResponseEntity<ResponseVo> showBookInfo(@RequestParam String data, @RequestParam String itemId) throws JsonProcessingException {
        String apiKey = data;   //ttbcmss03302033001

        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey={apiKey}&itemIdType=ISBN&ItemId={itemId}&output=js&Version=20131101&OptResult=ratingInfo,reviewList";
        String res = webClientBuilder.build()
                .get()
                .uri(apiUrl, apiKey, itemId, data)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        bookService.fetchData(res);

        ResponseVo responseVo = new ResponseVo();

        if(res == null){
            responseVo.setUcd("99");
            responseVo.setMessage("실패");
        }
        else{
            responseVo.setUcd("00");
            responseVo.setMessage(res);
        }
        return ResponseEntity.ok(responseVo);

    }

    @PostMapping("/bookinfo")
    public Long ApplyBook(@RequestParam ApplyBookEntity applyBookEntity) {
        // isbn 정보 and 현재 로그인 중인 회원 id
        return applyBookService.saveApply(applyBookEntity);
    }


    /*
    //service에서 book객체로 저장된 걸 가져온다
    @PostMapping("/")
    @Operation(hidden = true)
    public ResponseEntity<ApiResponse> fetchDataFromApi() {
        bookService.fetchData();
        ApiResponse response = new ApiResponse<>(true, "책 데이터 DB 저장 완료");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    */



    /*
     * @GetMapping("/api1")
     *     public Mono<String> useWebClient() {
     *         HttpClient httpClient = HttpClient.create()
     *                 .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000) //timeout 시간
     *                 .responseTimeout(Duration.ofMillis(5000))
     *                 .doOnConnected(conn->
     *                         conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
     *                                 .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));
     *
     *         var webClient = WebClient.builder()
     *                 .baseUrl("http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey=ttbcmss03302033001&itemIdType=ISBN&ItemId=9791155817049&output=xml&Version=20131101&OptResult=ebookList,usedList,reviewList")
     *                 .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
     *                 .clientConnector(new ReactorClientHttpConnector(httpClient))
     *                 .build();
     *
     *         return webClient.get()
     *                 .retrieve()
     *                 .bodyToMono(String.class);
     *
     *     }
     *
     *
     * */
}

