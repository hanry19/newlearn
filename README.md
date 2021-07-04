# NewLearn README

# 프로젝트 특징



- 프로젝트 명 : 인터넷 강의 플렛폼 제작
- 개발 인원 : 5명
- 사용환경 : Apache Tomcat 8.0
- IDE : Intellij
- 사용 프레임워크 : JAVA11, Springboot(2.4x), Spring Security, Thymeleaf, Mybatis,
- 사용 기술 : MVC, jQuetry, Ajax, Mail API, 결제API
- Database : MySQL
- 개발기간 : 2021.05.01  ~ 2021.06.08

# 개요



  코로나19로 인해 사회의 전반적인 흐름이 바뀌고 있습니다. 그 변화들을 들여다보면 업무뿐만 아니라 교육 또한 대면에서 비대면으로 바뀌고, 그로 인해 인터넷 강의를 찾는 사람들과 매출이 꾸준히 증가하고 있습니다.(**그림 1-1)** 특히 **그림 1-2**에서 보여지는 것 처럼 온라인 교육 수요의 증가는 코로나 19 이전부터 계속해서 증가 해오고 있습니다.

 그 중 IT업계는 불안정한 상황에서 많은 사람들의 관심을 받았습니다. 코로나로 인해 수 많은기업들이 위기에 봉착 하였을 오히려 성장하며 일부 업계는 최대 실적을 세우기도 했습니다.**(그림 1-3)** 또한 4차산업과 고액연봉을 받는다는 기사로인해 비대면 기반으로 한 코딩 학습 열풍이 불고 코딩 학원의 수강생이 증가했습니다.**(참조 1-4)**

  본  프로젝트의 목표는 현 시대적 흐름과 추세에 따라 비대면 강의를 제공할 수 있는 웹 사이트를 구현하고자 합니다. 코딩을 처음 접하는 사람들에게 좋은 무료강의를 제공하는 것을 목표로 하여, 회원들이 자신들의 지식을 자발적으로 강의로 만들어 올리고 판매를 함으로써 현업에서 코딩의 기초와 현업에서 업무를 기반으로 일을 배울 수 있는 환경을 제공합니다. 또한 자유롭게 토론을 통해 성장할 수 있는 공간과 스터디를 만들 수 있는 환경을 제공하여 회원들 스스로 성장하고 개발자들의 커뮤니티를 만들고자 합니다.

 해당 프로젝트를 통해 얻고자하는 것은  협업이 무엇인지, 문제에 봉착했을 때 어떻게 헤쳐나갈지, 필요한 기능을 검색 방법에 대해서 익숙해지고자 합니다. 이 프로젝트가 끝날 때면 사용프로그램들에 대한 숙련도 향상 및 리펙토링을 통해 간결성과 효율성을 높일 수 있는 계기가 될 것으로 기대합니다. 

![Untitled](https://user-images.githubusercontent.com/63430211/121376534-95209400-c97c-11eb-9415-8afe3395e429.png)

(그림 1-1 ) ’18년 하반기~’20년 상반기 콘텐츠산업 상장사 매출액 변동

![Untitled 1](https://user-images.githubusercontent.com/63430211/121376568-9b167500-c97c-11eb-844c-549be305dafb.png)

(그림1-2) 비대면 교육의 성장

![Untitled 2](https://user-images.githubusercontent.com/63430211/121376570-9baf0b80-c97c-11eb-9fc6-a0f8e31376e4.png)

(그림 1-3) 네이버 커머스, 핀테크, 클라우드 매출 추이

> **reference**

[한국콘텐츠진흥원](https://www.kocca.kr/cop/bbs/view/B0158949/1843644.do?searchCnd=1&searchWrd=%EC%BD%98%ED%85%90%EC%B8%A0%EC%82%B0%EC%97%85+%EB%8F%99%ED%96%A5%EB%B6%84%EC%84%9D+%EB%B3%B4%EA%B3%A0%EC%84%9C&cateTp1=&cateTp2=&useAt=&menuNo=203779&categorys=0&subcate=0&cateCode=&type=&instNo=0&questionTp=&uf_Setting=&recovery=&option1=&option2=&year=&categoryCOM062=&categoryCOM063=&categoryCOM208=&categoryInst=&morePage=&delCode=0&qtp=&pageIndex=1)

참조 1-1

[[코로나가 바꾼 일상] (1) ... 어온강에서 늘온강으로](https://www.mk.co.kr/news/economy/view/2020/04/403111/)

참조 1-2

[[2020 IT업계 총결산] ② "코로나 위기? NO!"... 인터넷기업 시대가 열렸다](https://www.ajunews.com/view/20201224173730492)

참조 1-3

["이러다 취업 못할라"...코로나가 불붙인 20대 '코딩 열풍' [현장+]](https://www.hankyung.com/it/article/202008128319g)

참조 1-4

# 1. 요구사항 분석



![Untitled 3](https://user-images.githubusercontent.com/63430211/121376574-9c47a200-c97c-11eb-8df9-a580191e9c39.png)


# 2. 테이블 설계



- **ERD 설계**

![_v1_210503](https://user-images.githubusercontent.com/63430211/121376595-9fdb2900-c97c-11eb-86ad-5e00f5ae6492.png)

- **테이블 구성**

![Untitled 4](https://user-images.githubusercontent.com/63430211/121376743-b8e3da00-c97c-11eb-9a1e-c60b9e310ab6.png)
# 3. 화면 설계



- 메인페이지
  ![메인페이지](https://user-images.githubusercontent.com/63430211/124388102-313f8000-dd1c-11eb-9011-bcb278097646.png)

- 로그인
  ![로그인](https://user-images.githubusercontent.com/63430211/124388134-706dd100-dd1c-11eb-8b42-e416d97699f8.png)
  
- 회원가입
  ![회원가입](https://user-images.githubusercontent.com/63430211/124388137-76fc4880-dd1c-11eb-9d30-b02cff03d2a8.png)



- 비밀번호 찾기 

![비밀번호 찾기](https://user-images.githubusercontent.com/63430211/124388139-78c60c00-dd1c-11eb-8480-9f2adf4df60b.png)

- 강의 리스트 
![111](https://user-images.githubusercontent.com/63430211/124388205-d2c6d180-dd1c-11eb-8f6f-b43075ae8f03.png)



- 강의 상세

 ![강의 상세 페이지](https://user-images.githubusercontent.com/63430211/124388145-7f548380-dd1c-11eb-982f-ff12b27e7608.png)

- 강의 영상 길이 및 리뷰
![강의 상세](https://user-images.githubusercontent.com/63430211/124388159-909d9000-dd1c-11eb-898a-7b863df9e646.png)

- 강의 실행 페이지   

![강의 상세2](https://user-images.githubusercontent.com/63430211/124388172-a317c980-dd1c-11eb-9491-b2d61b8ac30f.png)


- 관리자 페이지 
![ㅋㅋㅋㅋㅋㅋㅋ](https://user-images.githubusercontent.com/63430211/124388276-394bef80-dd1d-11eb-8faf-0deefa8974d6.png)



# 4. 개발일지


<br>


### 1. 한성준[조장] : Back-End



## 1.1 **맡은 업무**


<br>


1. Spring Security를 활용한 회원가입 / 로그인 구현
2. 가입 이메일을 통한 비밀번호 찾기 기능 
3. 마이페이지  : 회원정보 수정 및 탈퇴
4. 커뮤니티 게시판 구현

## 1.2 **업무 일지**

### **2021.05.12**

1. **Spring Security를 이용하여 로그인, 회원가입 구현**
    - 회원가입 시 이메일 유효성 검사 진행
    - 비로그인 상태로 특정 페이지 요청시 login 페이지로 이동
2. **비밀번호 저장 시 암호화 진행 완료** 
    - BCrypt를 이용하여 비밀번호 암호화하여 저장
3. **권한에 따른 페이지 접근** 
    - 관리자, 일반계정, 비회원으로 구분하여 모든계정이 접근 가능한 페이지와 관리자만 접근가능한 페이지를 구분
4. **로그인 성공/실패 시 로직 커스텀 작업 구현**
    - 로그인 시 접근 ip와 로그인 성공 여부 기록
    - 로그인 시 비밀번호가 다섯번 틀릴 경우 해당 계정 Lock

### **2021.05.19**

1. **MyPage(마이페이지) 접근 시 권한에 따라 페이지 구분** 
    - 접근 권한이 "admin" 일 경우 admin page로 이동한다.
    - 관리자는 모든 회원의 정보를 조회, 수정 및 삭제가 가능하고 회원은 본인의 정보만 수정이 가능하다.

### **2021.05.20**

1. 팀원들과 병합을 위한 디렉토리 구조 정립 및 초기 양식 업로드

### **2021.05.21**

1. 회원 정보 수정 시 비밀번호가 공백(" ")dm로 전달되어 공백에 대한 암호화 되어 저장되던 것을 공백이 입력될 시 비밀번호는 변경되지 않도록 보완

### **2021.05.25**

1. 비밀번호 분실 시 가입 시 등록한 이메일을 통해 임시 비밀번호 발송
    - 임시 비밀번호는 정규화를 이용하여 랜덤으로 8글자 발송 됨과 동시에 db에 비밀번호 변경됨.


<br>


# 직면한 문제


<br>


1. **비로그인 시 CSS/JS 적용 안되는 현상**

    **1.1 문제 정의**

    - Spring Security 연동 시 CSS/JS 까지 연동이 안되는 문제 발생
    - ignore 까지 했지만 안되는 현상이 발생하여 문제 추적 중
    - 하지만 회원 로그인을 할 경우 제대로 CSS/JS가 적용 되었다
    - 

    **1.2 원인 및 해결**

    - Spring Security 특징 인 인증/인가에 따라 권한에 따라 URL의 접근 여부를 결정할 수 있다.
    - 기존의 설정에는 'ROLE_USER' 이상의 권한을 가진 자만 CSS/JS를 접근할 수 있었기에 비회원은 CSS/JS가 미적용된 페이지를 보게되었다.
    - 그리하여 CSS/JS는 모든 클라이언트가 접근할 수 있도록 설정을 변경해줌으로 써 문제를 해결할 수 있었다.

    ```java
    http.authorizeRequests()
                 .antMatchers("/user/**").access("hasRole('ROLE_USER')")
                 .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                 .antMatchers("/mypage/**").access("hasRole('ROLE_USER')or hasRole('ROLE_ADMIN')")

                 //누구나 접속할 수 있는 페이지이기 때문에 누구나 접근이 가능하다 (.permitAll())
                 .antMatchers("/main",
                         "/login",
                         "/sign-Up",
                         "/pwFind",
                         "/login/**",
                         "/community/**",
                         "/main",
                         "/pwFind",
                         "/css/**","/js/**","/img/**","/plugin/**","/vendor/**",** // CSS/JS 같은 정적인 데이터는 누구나 접근할 수 있도록 설정 변경
                         "/logout"
                 ).permitAll()

                 //기타 /** 의 경로는 인증을 필요로 한다
                 .antMatchers("/**").authenticated();
    ```


<br>


2. **로그인 시 페이지가 제대로 넘어가질 않는 문제 발생**

    **2.1 원인 및 추론**

    - 로그인 이후 부가작업을 진행하기 위해 **SimpleUrlAuthenticationSuccessHandler.class** 중 **onAuthenticationSuccess** 메서드를 상속받을 때 **FilterChain** 이 포함된 메서드를 상속받아 로그인 이후 페이지로 넘어가질 못하였다.

    ```java
    `public void onAuthenticationSuccess(HttpServletRequest request,
                                          HttpServletResponse response,
                                          **FilterChain chain,**
                                          Authentication authentication) throws IOException, ServletException {`
    ```

    - 하지만 확장 및 설정을 고려하지 않은 상황에서 메서드에 포함이 되어 있어 404 error가 발생하였다. 심지어 url조차 전달이 되지 않았다.

    ![https://user-images.githubusercontent.com/63430211/118206624-da48c780-b49d-11eb-9757-363af28b323c.png](https://user-images.githubusercontent.com/63430211/118206624-da48c780-b49d-11eb-9757-363af28b323c.png)

    **2.2 해결 및 추론**

    - FilterChain이 포함되어있지않는 메서드를 다시 오버로딩하여 사용함으로써 로그인 이후 페이지로 넘어갔다
    - 첫 서버 running 시 진행한 Filter이 외 Filter에 대한 접근이 없기에 정상적으로 진행된 것으로 생각이 든다.

        ```java
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                             Authentication authentication) throws IOException, ServletException {
        ```

    **2.3 공부한 내용**

    - FilterChain은 Chain 구조로 이루어져 있는 스프링 시큐리티 내부의 필터들이며 요청을 받아 처리를 한다.
    - 개발 시 해당필터를 확장하고 설정하면 스프링 시큐리티를 이용해 다양한 형태로 로그인 처리가 가능하다.
    - 개발 시 IDE를 신뢰하고 인자 값들을 제대로 확인하지 못한 점에 대해서 크게 반성을 한다.
    - 특히나 보안을 작업할 땐 꼼꼼하게 확인해야 한다는 것과 작은 실수하나로 사이트 전체를 멈춰버릴 수 있다는 것을 배울 수 있었다.

    **2.4 더 이해가 필요한 부분**

    - Filter에 대한 개념과 진행방법에 대해 더 깊은 이해가 필요할 것으로 판단 됨


<br>


3. **GitHub 업로드 시 파일 삭제**

    **3-1 문제 발생 경위 및 추론**

    - 팀 repository에 병합한 파일 공유를 위해 push 작업 진행
    - 정상적인 push 이후 최초에 test로 만든 branch를 삭제를 시도함.
    - 삭제 과정에서 GitHub 사용의 미숙함으로 이전 test로 올린 파일과 합쳐지며 push한 내용들이 삭제됨
    - 삭제된 사실도 모른채 test branch 삭제 및 history 삭제 진행

    3**-2 문제해결 및 추론**

    - 커밋한 내용을 되돌리기 위해 터미널에서 시도를 하였지만, 어느 시점에서 문제가 발생했는지 확인할 수 없었기에 재 병합 작업 시작

    **3-3 공부한 내용**

    - 데이터를 이동하는 작업 진행 시 불확실한 경우 백업(back-up)파일을 생성해야한다는 것을 배움
    - git bash를 이용한 깃 사용에 익숙해 짐

    **3-4 이해가 더 필요한 부분**

    - GitHub 사용에 대한 이해도 향상이 필요하다.
