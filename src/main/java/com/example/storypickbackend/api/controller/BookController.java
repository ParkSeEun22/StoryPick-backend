package com.example.storypickbackend.api.controller;


import com.example.storypickbackend.api.dto.response.ResponseVo;
import com.example.storypickbackend.api.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
//@CrossOrigin(origins = "*")
public class BookController {

    private BookService bookService;
    private final WebClient.Builder webClientBuilder;

    @GetMapping("/api")
    public String springData(String msg) {
        return msg;
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



    @GetMapping("/hello")
    public ResponseEntity<ResponseVo> initApi(@RequestParam String input) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setUcd("0");
        responseVo.setMessage("수신된 값" + input);
        return ResponseEntity.ok(responseVo);
    }

    @GetMapping("/bookinfo")
    public ResponseEntity<ResponseVo> testApi(@RequestParam String data) {
        String apiKey = data;   //ttbcmss03302033001
        String itemId = "9791155817049";

        String apiUrl = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?ttbkey={apiKey}&itemIdType=ISBN&ItemId={itemId}&output=xml&Version=20131101&OptResult=ebookList,usedList,reviewList";
        String res = webClientBuilder.build()
                .get()
                .uri(apiUrl, apiKey, itemId, data)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(res);

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

