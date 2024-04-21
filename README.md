# b01
자바웹개발 워크북


일부영역을 다른파일에서 해당부분만을 개발할수 있게만드는 build.gradle의 라이브러리<br>
    implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.1.0'<br>

@Entity와 @Id는 세트<br>


@EntityListeners(value = {AuditingEntityListener.class})<br>
AuditingEntityListener를 적용하면 엔티티가 데이터베이스에 추가되거나 변경될 때 자동으로 시간 값을 지정할 수 있습니다.<br>


★ 439p testInsert가 board문제로 실행 안될경우<br>
Haidi에서 root입장 > 사용자 관리자에서 webuser 자격 증명에서 로그인<br>

Querydsl(제목/내용/작성자)을 이용하기 위해서는 build.gradle 설정을 변경해줄 필요가 있다.<br>

★449p Gradle메뉴는 오른쪽에 있다. <br>
compilejava실행해야 Querydsl이 설정된다.<br>

PageRequestDTO는 페이징 관련 정보(page/size) 외에 검색의 종류(type)와 키워드(keyword)를 추가해서 지정합니다.<br>
PageResponseDTO는 화면에 DTO의 목록과 시작 페이지/끝 페이지 등에 대한 처리를 담당<br>

○ 날짜 포맷팅 처리<br>
등록일(regDate)이 너무 길고 상세하게 나오는 것을 볼 수 있습니다. 이 부분은 Thymeleaf의 #temporals라는 유틸리티
객체를 이용해서 처리합니다.<br>

○implementation 'org.springframework.boot:spring-boot-starter-validation' 은 @NotEmpty, @Size() , @Valid와 관계<br>

★ http://localhost/board/list에서 read로 이동되지만<br>
http://localhost/board/list?size=10&type=&keyword=&page=2 형식에서 read페이지로 이동하면 오류발생하는이유<br>
PageRequestDTO.java에서 "&keyword=" 를 $keyword= 로 잘못입력<br>

○ e.preventDefault() 페이지의 동작 중단<br>
○ e.stopPropagation() 이벤트가 상위 엘리멘트에 전달되지 않게 막아준다.(이벤트 중단)<br>

○REST는 효율적, 안적적이며 확장가능한 분산 시스템을 가져올 수 있는 소프트웨어 아키텍처 디자인 제약의<br>
모음을 나타냅니다. 그리고 그 제약들을 준수했을 때 그 시스템은 RESTful하다고 일컬어집니다.<br>
○ URL(Uniform Resource Locator)과 URI(Uniform Resource Identifier) 자원 식별자<br>

★ 워크북 515p 깃허브 1.reply_backend 참조 https://github.com/lonen8188/WorkBook/blob/1.reply_backend/build.gradle<br>
 json 테스트용 -> postman 사용해도 무관 -> 부트3에서 작동 안함<br>
implementation 'io.springfox:springfox-swagger-ui:3.0.0'<br>
implementation group: 'io.springfox', name: 'springfox-boot-starter', version: '3.0.0'<br>
대신 implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2' 사용<br>

★ 519p 위의 방식으로 입력하면 board/list정상작동하고 CustomServletConfig 작성 할 필요없다.<br>

★ 599p 파일업로드 기능 안되니 프론트에서 테스트해볼것<br>

★ReplyController.java<br>
@ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록") 대신<br>
 @Operation(summary = "Replies POST") 사용<br>

○ 539p - no session이라는 의미가 데이터베이스와 추가적인 연결이 필요해서 발생하는 문제<br>
548p<br>

★ 548p 학원에서 깃을 push한것을 집의 vm에서 실행했을경우 /read 웹페이지가 실행 안되는 상황<br>
id 'org.springframework.boot' version '3.2.4' 버전은 compiler uses the '-parameters' flag 에서발생하여<br>
    id 'org.springframework.boot' version '3.1.0'로 수정<br>
★ java: Attempt to recreate a file for type org.zerock.b01.domain.QBaseEntity 실행안되면 clean만 하고 javaCompile은
설치하지 않고 웹 실행해보기<br>
