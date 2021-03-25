# CommunityReview
- Spring Boot를 활용한 게시판 개인 프로젝트입니다.
- 2021.01 ~ 2021.02 약 두달의 기간동안 스터디를 운영하며 pull requests를 활용한 코드리뷰를 진행했습니다.
- RESTful Project
- 2021.03 한 달동안 템플릿 언어를 mustache에서 thymeleaf로 전환하고, 템플릿을 변경하여 적용했습니다.
- 보완할 사항들을 꾸준히 개발하는 중입니다.

![main 1](https://user-images.githubusercontent.com/39761461/112292423-6aeffc00-8cd4-11eb-8c3a-f781cfff49b1.gif)

- 만들어져 있는 무료 배포 템플릿을 다운 받아 적용시켰습니다. (출처: https://themewagon.com/theme_tag/free/)

---
# 배포
- AWS 서버를 활용하였습니다. <br>
http://52.78.112.93:8080/

---
# 개발 환경
- IntelliJ
- JDK 11
- Spring Boot, Gradle, JPA, Lombok, Spring-web, thymeleaf
- MariaDB
- AWS EC2, AWS RDS

---
# Member

![signup in 1](https://user-images.githubusercontent.com/39761461/112443702-9afcd500-8d90-11eb-9290-436c65d42a42.gif)

- 기본적인 정보를 입력받아 회원가입을 진행합니다.
- 로그인, 로그아웃에 따라 세션을 관리합니다.

- Google, Kakao, Naver Login API (진행)

---
# Board

![board 1](https://user-images.githubusercontent.com/39761461/112444126-0e064b80-8d91-11eb-87e2-7a11614bd787.gif)

- summernote API를 활용하였습니다.
- 댓글을 입력할 수 있도록 했습니다.

- 대댓글 (진행)

---
# Mypage

![mypage 1](https://user-images.githubusercontent.com/39761461/112444585-8ec54780-8d91-11eb-9dd9-f5b349268027.gif)

- 자신의 회원 정보를 관리할 수 있는 공간입니다.


---
## 보완할 부분
- 게시판 스크롤 페이징
- summernote API Image 크기 조정
- 익명 게시판 카테고리 생성
- 게시글 좋아요, 댓글 추천
- 에러페이지 커스텀
- 게시글 sns 공유


