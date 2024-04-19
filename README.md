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

implementation 'org.springframework.boot:spring-boot-starter-validation'
은 @NotEmpty, @Size() , @Valid<br>
