# 0. 목차 
[1. 목적](#1-목적)  
[2. Mar팀 개발자 소개](#2-mar-팀-소개)  
[3. 프로젝트 Markit 기획](#3-프로젝트-기획)   
[4. 프로젝트 Markit 설계](#4-프로젝트-설계)  
[5. 기능시연](#5-기능시연)  

​
​
# 1. 목적  
* Spring 프레임워크를 사용하여 웹표준 Full-Stack 융합 프로젝트 구현 기술 습득
* gitHub형상관리를 사용하여 조직적 직무수행에 필요한 기술 습득
* 결제 API를 사용하여 온라인 쇼핑몰 전자상거래 구현
* Spring MVC아키텍처를 기반으로 Dispatcher-Servlet 원리 이해
* Tiles적용으로 반복적인 화면 템플릿 관리


​
​
# 2. *MAR* 팀 소개
### 2.1. 조원 /  조장
```
조장: 김혜영   
조원: 김재욱, 신한솔, 이승호, 차예빈
```

​
​
### 2.2. 담당업무
|이름|담당업무|
|:----------:|:-------|
|김재욱     | 레시피관리(등록,삭제,수정,조회)/이벤트(상품할인율적용)/회원관리(로그인,로그아웃,회원가입,회원탈퇴)|
|김혜영     | 목록(카테고리별,등록일순,판매량순,할인율적용된 상품)/검색/공통화면관리     |
|신한솔     | 상품관리(등록,삭제)/문의답변(문의등록&답변)                                |
|이승호     | 문의등록/주문목록/주문상품조회/상품후기, 자기가 쓴 후기(등록)                    |
|차예빈     | 상품주문/장바구니/늘사는것(찜하기기능)/결제(API)                           |

​
​
# 3. 프로젝트 기획
## 3.1. 프로젝트명  
### [Markit - 온라인 쇼핑몰]
<img src="https://user-images.githubusercontent.com/72611381/115550882-4ee87600-a2e5-11eb-820b-30e846e22529.png" width="100%">
Markit은 조이름인 mar와 하나의 묶은 그 전부를 의미하는 kit을 붙여 지어진 프로젝트명입니다.
식료품 전문 온라인 판매점이라는 특성에 맞춰 소비자가 원하는 모든 것이 저희 Markit온라인 쇼핑몰에 있음을 상징합니다.

​
​
## 3.2. 프로젝트 선정 배경
* 코로나19로 인해 외부활동이 위축됨에 따라 온라인 웹사이트의 비중 증가  
* 5인 이상 집합 금지에 따라 배달 음식, 1인 혼밥, 스스로 요리하는 등 소비 대상의 변화 발생  
* 언택트 시대를 맞아 최근 빠르게 성장하고 있는 '마켓컬리'를 벤치마킹 사이트로 선정  

​
​
## 3.3. 개발 환경
![개발도구](https://user-images.githubusercontent.com/72611381/117753845-23a5d680-b254-11eb-8a2b-90857c2ccd57.PNG)

## 3.4. 프로젝트 진행일정
- **WBS**
![WBS](https://user-images.githubusercontent.com/72611381/117754856-23a6d600-b256-11eb-8196-6c76e623c14d.PNG)    


​
​
[▲목차](#0-목차)
# 4. 프로젝트 설계
## 4.1. 요구사항정의서
![image](https://user-images.githubusercontent.com/72611381/117756220-bcd6ec00-b258-11eb-9071-1398d68aee36.png)
![image](https://user-images.githubusercontent.com/72611381/117756233-c52f2700-b258-11eb-9313-91b032fad579.png)

​
​
## 4.2. 개발아키텍쳐 : MVC
![April_WBS](https://github.com/HYKim8/April/blob/master/aprilPrj/src/main/webapp/WEB-INF/doc/April_MVC.png "April_MVC")

​
​
## 4.3. 테이블 정의서
![테이블정의서](https://user-images.githubusercontent.com/72611381/117756742-b9903000-b259-11eb-80fc-f9b1b7197feb.png)

​
​
## 4.4. ERD
- ERD를 통해 테이블의 식별/비식별 관계 연결
![ERD](https://user-images.githubusercontent.com/72611381/117757153-7edac780-b25a-11eb-8286-2867e47380b3.PNG)  


​
​
[▲목차](#0-목차) 
# 5. 기능시연

## 김혜영 개발자 part
Markit은 마켓컬리를 벤치마킹한 프로젝트로, 관리자영역을 제외한 전체적 구성은 마켓컬리와 유사한 점이 많습니다.

사용자가 저희 사이트를 사용할때 가장 처음 마주하게될 메인화면은, 접근성을 향상시키기 위해 간결하고 이해하기 쉽게 구성하였습니다. 그리고 jstl을 통해 썸네일 카드를 동적으로 생성한 이미지형 게시물을 구현하였습니다.
![2021-05-12 15-14-11 mkv_000001000](https://user-images.githubusercontent.com/72611381/117927864-c41ff780-b335-11eb-8fde-8f8a854cd3b0.gif)  

메뉴바의 카테고리는 드롭다운을 통해 식품종류를 세부적으로 구분하여 원하는 종류의 상품을 쉽게 조회할 수 있도록 하였습니다.
![2021-05-12 15-14-11 mkv_000011367](https://user-images.githubusercontent.com/72611381/117927890-c8e4ab80-b335-11eb-8d58-fdcfe2604cb4.gif)
(샐러드/간편식 카테고리에 속한 상품조회 결과)
![2021-05-12 15-14-11 mkv_000022183](https://user-images.githubusercontent.com/72611381/117927903-cc783280-b335-11eb-8e2c-b1eccf334324.gif)
(면/양념/오일 카테고리에 속한 상품조회 결과)  

신상품 메뉴를 누르면 가장 최근에 등록된 상품목록을 보여줍니다.
![2021-05-12 15-14-11 mkv_000032500](https://user-images.githubusercontent.com/72611381/117928375-7061de00-b336-11eb-87dd-43b34e9c0707.gif)  

베스트 메뉴는 판매량이 높은 순서로 상품목록을 보여줍니다. 판매량은 구매확정이 될 시 Item테이블의 sales컬럼의 숫자가 업데이트 되도록 구현하였습니다. 상세한 설명은 주문상품 부분에서 더 자세히 설명드리겠습니다.
![2021-05-12 15-14-11 mkv_000040083](https://user-images.githubusercontent.com/72611381/117928392-76f05580-b336-11eb-8953-b56d34777e03.gif)
![image](https://user-images.githubusercontent.com/72611381/117929527-e450b600-b337-11eb-9027-001dfce14e32.png)

알뜰쇼핑을 누르면 할인율이 적용된 상품을 볼 수 있고 이 할인율은 관리자가 직접 등록하도록 구현하였습니다.
![2021-05-12 15-14-11 mkv_000048483](https://user-images.githubusercontent.com/72611381/117928408-7bb50980-b336-11eb-9584-3a1510cd62b0.gif)  
![image](https://user-images.githubusercontent.com/72611381/117930438-f2530680-b338-11eb-80cf-8d490ed5f7d6.png)  

레시피 메뉴는 관리자가 등록한 레시피 목록을 띄워주고 레시피의 상세페이지로 이동가능합니다.
![2021-05-12 15-14-11 mkv_000058167](https://user-images.githubusercontent.com/72611381/117928417-7eaffa00-b336-11eb-913d-4b5bbbff35ee.gif)

Markit은 오직 회원만 상품을 구매할 수 있도록 했기 때문에 결제할 상품을 담아두는 장바구니는 로그인 후 불러올 수 있도록 하였습니다.
![2021-05-12 15-14-11 mkv_000069567](https://user-images.githubusercontent.com/72611381/117928429-82dc1780-b336-11eb-805a-0a4011a26cd8.gif)

검색창에 원하는 상품을 조회하기 위해 상품이름을 입력하여 검색할 수 있습니다. 
![2021-05-12 15-14-11 mkv_000078767](https://user-images.githubusercontent.com/72611381/117928437-85d70800-b336-11eb-892f-87e56dd78975.gif)

로그인세션에 따라 변하는 메뉴를 확인하실 수 있습니다.
![2021-05-12 15-14-11 mkv_000101633](https://user-images.githubusercontent.com/72611381/117928445-88396200-b336-11eb-8970-ce4cb11ddd8c.gif)

Tiles를 통해 각자 생성한 body에 중복되는 템플릿(헤더,메뉴바,사이드,푸터)들이 적용될 수 있도록 구현하였습니다.
![2021-05-12 15-14-11 mkv_000131667](https://user-images.githubusercontent.com/72611381/117928455-8a9bbc00-b336-11eb-80b7-90ce0223738d.gif)

