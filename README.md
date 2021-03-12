# CommunityReview
- Spring Boot를 활용한 게시판 개인 프로젝트입니다.
- 2021.01 ~ 2021.02 약 두달의 기간동안 스터디를 운영하며 pull requests를 활용한 코드리뷰를 진행했습니다.
- RESTful Project

image

- 만들어져 있는 무료 배포 템플릿을 다운 받아 적용시켰습니다.

---
# 배포
- AWS 서버를 활용하였습니다. <br>
http://52.78.112.93:8080/

---
# 개발 환경
- IntelliJ
- JDK 11
- Spring Boot, Gradle, JPA, Lombok, Spring-web, mustache
- MariaDB
- AWS EC2, AWS RDS

---
# Member Sign up / Sign in / Sign out

image

- 기본적인 정보를 입력받아 회원가입을 진행합니다.
- 로그인, 로그아웃에 따라 세션을 관리합니다.
- Google, Kakao, Naver Login API를 활용하였습니다. (토큰이 아닌 세션으로 관리)

---
# Community

image

- summernote API를 활용하였습니다.
- 댓글, 대댓글도 작성할 수 있습니다.

---
# Mypage

image

- 자신의 회원 정보를 관리할 수 있는 공간입니다.




